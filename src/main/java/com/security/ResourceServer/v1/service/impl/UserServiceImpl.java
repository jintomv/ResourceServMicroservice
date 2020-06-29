package com.security.ResourceServer.v1.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.ResourceServer.v1.Entity.UserEntity;
import com.security.ResourceServer.v1.dto.request.UserRequestDTO;
import com.security.ResourceServer.v1.dto.response.UserResponseDTO;
import com.security.ResourceServer.v1.model.User;
import com.security.ResourceServer.v1.repository.UserRepository;
import com.security.ResourceServer.v1.service.UserService;

/**
 * 
 * Service class implementation for user Entity
 *
 */
@Service(value="UserServiceImpl")
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepo;
	
	/**
	 * Method that returns the userentity from Db according to the object
	 */
	public UserResponseDTO findUserByID(Long id)
	{
		User user = new User(id);
		UserEntity entity = user.toEntity(user);
		UserResponseDTO userResponsedto = new UserResponseDTO();
		try {
			
			UserEntity userEntity = userRepo.findUserByid(entity.getId());
			if(userEntity != null)
			{
				user.setId(userEntity.getId());
				user.setUserName(userEntity.getUserName());
				user.setEmail(userEntity.getEmail());
				user.setActive(userEntity.getActive());
				BeanUtils.copyProperties(user, userResponsedto);
			}
			
		}
		catch(Exception e) {
			
			System.out.println("UserServiceImpl findUserByID failed"+e);
		}
		return userResponsedto;
		
		
	}
	
	/**
	 * Method that persists user object in DB
	 */
	public UserResponseDTO addUser(UserRequestDTO userDto) {
		
		UserResponseDTO userResponsedto = new UserResponseDTO();
		try {
			User user = userDto.toModel(userDto);
			UserEntity entity = user.toEntity(user);
			UserEntity savedUser = userRepo.save(entity);
			if(savedUser != null)
			{
				System.out.println("user is saved");
				
				user.setId(savedUser.getId());
				user.setUserName(savedUser.getUserName());
				BeanUtils.copyProperties(user, userResponsedto);
			}
		}
		catch(Exception e) {
			System.out.println("UserServiceImpl addUser failed"+e);
		}
		return userResponsedto;
	}

}
