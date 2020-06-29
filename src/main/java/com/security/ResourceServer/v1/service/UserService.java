package com.security.ResourceServer.v1.service;

import org.springframework.stereotype.Service;

import com.security.ResourceServer.v1.dto.request.UserRequestDTO;
import com.security.ResourceServer.v1.dto.response.UserResponseDTO;

/**
 * 
 * Service interface used for user Entity
 *
 */
@Service(value="UserService")
public interface UserService {

	/**
	 * Metod gets a user based on id
	 * @param id
	 * @return
	 */
	UserResponseDTO findUserByID(Long id);
	
	/**
	 * 
	 */
	public UserResponseDTO addUser(UserRequestDTO userDto);
}
