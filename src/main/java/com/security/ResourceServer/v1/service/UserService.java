package com.security.ResourceServer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.security.ResourceServer.v1.Entity.UserEntity;
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
	UserResponseDTO addUser(UserRequestDTO userDto);
	
	
	UserResponseDTO updateUser(Long id, UserRequestDTO userDto);
	
	
	/**
	 * Deletes an Organization object from the DB.
	 * @param organizationKey
	 */
	void deleteUser(Long id);
	
	UserResponseDTO findByUserName(String userName);
}
