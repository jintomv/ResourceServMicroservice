package com.security.ResourceServer.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.ResourceServer.v1.dto.request.UserRequestDTO;
import com.security.ResourceServer.v1.dto.response.UserResponseDTO;
import com.security.ResourceServer.v1.service.UserService;
/**
 * @author jinto varghese
 *
 */
@RestController(value="UserController")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserDetailsController {

	@Autowired
	UserService userservice;
	/**
	 * Controller
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
	
	
	@GetMapping("/getAll")
	public ResponseEntity<UserResponseDTO> fetchAllUsers() throws Exception{
		UserResponseDTO userResponseDTO = userservice.retrieveAllUsers();
		return ResponseEntity.ok(userResponseDTO);
		
	}
	
	/**
	 * This API creates new user object
	 * @param UserRequestDTO
	 * @return ResponseEntity<userResponseDTO>
	 */
	@PostMapping("/v1/addUser")
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
		UserResponseDTO userResponseDTO = userservice.addUser(userRequestDTO);
		return ResponseEntity.ok(userResponseDTO);
	}
	
	
	/**
	 * This API updates an user object.
	 * @param userId
	 * @param userRequestDTO
	 * @return ResponseEntity<UserResponseDTO>
	 */
	@PutMapping("/v1/updateUser/{userId}")
	public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long userId,@Valid @RequestBody UserRequestDTO userRequestDTO) {
		UserResponseDTO userResponseDTO = userservice.updateUser(userId, userRequestDTO);
		return ResponseEntity.ok(userResponseDTO);
	}
	
	/**
	 * API to delete an user object.
	 * @param userId
	 * @return ResponseEntity
	 */
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		userservice.deleteUser(userId);
		return ResponseEntity.ok("Deleted");
	}
	
	
	/**
	 * Api for fetching user objects according to
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/findUserList")
	public ResponseEntity<UserResponseDTO> fetchByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName)  throws Exception{
		UserResponseDTO userResponseDTO = userservice.retrieveByFirstNameAndLastName(firstName,lastName);
		return ResponseEntity.ok(userResponseDTO);
	}
	
	
}
