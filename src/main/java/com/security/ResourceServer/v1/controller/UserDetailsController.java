package com.security.ResourceServer.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.ResourceServer.v1.dto.request.UserRequestDTO;
import com.security.ResourceServer.v1.dto.response.UserResponseDTO;
import com.security.ResourceServer.v1.service.UserService;
/**
 * 
 *
 */
@RestController(value="UserController")
//@CrossOrigin(origins = "http://localhost:8080")
public class UserDetailsController {

	@Autowired
	UserService userservice;
	/**
	 * 
	 * @param id
	 * @param userDTO
	 * @return
	 * @throws Exception
	 */
	
	@GetMapping("/v1/fetchUser/{id}")
	public ResponseEntity<UserResponseDTO> fetchUserDetByID(@PathVariable Long id
			) throws Exception {
		UserResponseDTO userResponseDTO = userservice.findUserByID(id);
		return ResponseEntity.ok(userResponseDTO);
	}
	
	/**
	 * This API creates new user object
	 * @param UserRequestDTO
	 * @return ResponseEntity<userResponseDTO>
	 */
	@GetMapping("/v1/addUser")
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
	//public ResponseEntity<UserResponseDTO> createUser(){
//		UserRequestDTO dto = new UserRequestDTO();
//		dto.setUserName("jinto");
//		dto.setPassword("Global12$");
//		dto.setEmail("jinto@gmail.com");
		UserResponseDTO userResponseDTO = userservice.addUser(userRequestDTO);
		return ResponseEntity.ok(userResponseDTO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/")
	public String index(@AuthenticationPrincipal Jwt jwt) {
		return String.format("Hello, %s!", jwt.getSubject());
	}

	@GetMapping("/message")
	//@PreAuthorize
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
