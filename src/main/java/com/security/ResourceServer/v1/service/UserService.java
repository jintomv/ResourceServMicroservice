package com.security.ResourceServer.v1.service;

import org.springframework.stereotype.Service;

import com.security.ResourceServer.v1.dto.request.UserRequestDTO;
import com.security.ResourceServer.v1.dto.response.UserResponseDTO;

/**
 * 
 * Service interface used for user Entity
 * 
 * @author jinto varghese
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
	
	//UserResponseDTO findByUserName(String userName);
	
	/**
	 * Method will returns all the user object persisit in DB
	 * @return
	 */
	UserResponseDTO retrieveAllUsers();
	
	/**
	 * method returns list of entities that have first name and last name according to
	 * @param firstName and lastName
	 */
	
	UserResponseDTO retrieveByFirstNameAndLastName(String firstName, String lastName);
	
}
