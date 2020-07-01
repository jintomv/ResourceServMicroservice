package com.security.ResourceServer.v1.service.impl;

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
		User user = userDto.toModel(userDto);
		UserEntity entity = user.toEntity(user);
		UserEntity savedUser = userRepo.save(entity);
		if (savedUser != null) {
			System.out.println("user is saved");

			user.setId(savedUser.getId());
			user.setUserName(savedUser.getUserName());
			BeanUtils.copyProperties(user, userResponsedto);
		}
		return userResponsedto;
	}
	
	/**
	 * Method returns the user entity based on
	 * @param userName
	 */
	@Override
	public UserResponseDTO findByUserName(String userName) {
		
		UserResponseDTO userResponsedto = new UserResponseDTO();
		try {
			User user = new User(userName);
			UserEntity entity = user.toEntity(user);
			UserEntity userEntity = userRepo.findByUserName(entity.getUserName());
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
			System.out.println("UserServiceImpl findByUserName failed"+e);	
		}
		return userResponsedto;
	}
	
	@Override
	public UserResponseDTO updateUser(Long id, UserRequestDTO userDto) {
		
		UserEntity userEntity = userRepo.findUserByid(id);
		UserResponseDTO userResponsedto = new UserResponseDTO();
		if(userEntity == null)
		{
			System.out.println("The user doesn't exists!!!");
			return null;
		}
		else
		{
			User user = userDto.toModel(userDto);
			UserEntity entity = user.toEntity(user);
			UserEntity savedUser = userRepo.save(entity);
			user.setId(savedUser.getId());
			user.setUserName(savedUser.getUserName());
			user.setEmail(savedUser.getEmail());
			user.setActive(savedUser.getActive());
			BeanUtils.copyProperties(user, userResponsedto);
		}
		return userResponsedto;
	}

	
	@Override
	public void deleteUser(Long id) {
		UserEntity userEntity = userRepo.findUserByid(id);
		if(userEntity == null)
		{
			System.out.println("The user doesn't exists!!!");
		}
		else
		{
			userRepo.delete(userEntity);
		}
	}

}
