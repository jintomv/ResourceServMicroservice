package com.security.ResourceServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
public class ResourceServerController {
	

	@GetMapping("/")
	public String index(@AuthenticationPrincipal Jwt jwt) {
		return String.format("Hello, %s!", jwt.getSubject());
	}

	@GetMapping("/message")
	public String message() {
		return "secret message";
	}
//	
//	@GetMapping("/verifytoken")
//	public void getTokenDetails(HttpHeaders httpHeaders)
//	{
//		List<String> authorizationHeader = httpHeaders.get(HttpHeaders.AUTHORIZATION);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setBearerAuth("1");
//		//restTemplate.put(introspectUri, HttpMethod.POST, headers);
//	}
	
	@PostMapping("/message")
	public String createMessage(@RequestBody String message) {
		return String.format("Message was created. Content: %s", message);
	}
}
