package com.security.ResourceServer.v1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * 
 * The class is used for configuring the resource server
 *
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class ResourceServerConfiguration extends WebSecurityConfigurerAdapter{

	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}") 
	String jwkSetUri;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
		.cors()
		.and()
		.csrf().disable()
			.authorizeRequests(
//					authorizeRequests ->
//				authorizeRequests
//					.antMatchers(HttpMethod.GET,"/v1/fetchUser/{id}").permitAll()
//					.antMatchers(HttpMethod.GET,"/v1/findByUserName/{userName}").permitAll()
//					.antMatchers(HttpMethod.POST,"/v1/addUser").access("#oauth2.hasScope('write')")
//					.antMatchers(HttpMethod.PUT,"/v1/updateUser/{userId}").access("hasScope('write')")
//					.antMatchers(HttpMethod.DELETE,"{userId}").access("hasScope('write')")
					//.antMatchers(HttpMethod.GET, "/message/**").hasAuthority("SCOPE_message:read")
					//.antMatchers(HttpMethod.POST, "/message/**").hasAuthority("SCOPE_message:write")
				
				
			)
			.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
			.antMatchers(HttpMethod.GET,"/v1/fetchUser/{id}").permitAll()
			//.antMatchers(HttpMethod.GET,"/v1/findByUserName/{userName}").permitAll()
			.antMatchers(HttpMethod.GET,"/getAll").permitAll()
			.antMatchers("/v1/addUser").permitAll()
			.antMatchers(HttpMethod.PUT,"/v1/updateUser/{userId}").permitAll()
			.antMatchers(HttpMethod.DELETE,"{userId}").permitAll()
			.and()
			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		// @formatter:on
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
		

	}
	
	@Bean
    public FilterRegistrationBean corsFilterRegistrationBean() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.applyPermitDefaultValues();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setExposedHeaders(Arrays.asList("content-length"));
        config.setMaxAge(3600L);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
