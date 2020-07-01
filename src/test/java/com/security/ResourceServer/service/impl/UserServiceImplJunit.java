package com.security.ResourceServer.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.security.ResourceServer.v1.Entity.UserEntity;
import com.security.ResourceServer.v1.dto.request.UserRequestDTO;
import com.security.ResourceServer.v1.dto.response.UserResponseDTO;
import com.security.ResourceServer.v1.model.User;
import com.security.ResourceServer.v1.repository.UserRepository;
import com.security.ResourceServer.v1.service.UserService;
import com.security.ResourceServer.v1.service.impl.UserServiceImpl;


/**
 * 
 * junit test class for userserviceimpl
 *
 */

//@RunWith(jun.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = UserServiceImpl.class)
public class UserServiceImplJunit {
	
	@MockBean
	private UserRepository userRepo;
	
	static User user;
	
	static UserEntity userEntity;
	
	static UserResponseDTO userResponsedto;
	
	static UserRequestDTO userRequestDTO;
	
	@Autowired
	UserService userservice;
	
	
	@BeforeAll
	public static void setUp() {
		
		
		user = new User();
		user.setId(1L);
		user.setUserName("userName");
		user.setPassword("password");
		user.setEmail("email");
		user.setActive(true);
		
		userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setUserName("userName");
		userEntity.setPassword("password");
		userEntity.setEmail("email");
		userEntity.setActive(true);
		
		userResponsedto = new UserResponseDTO();
		userResponsedto.setId(1L);
		userResponsedto.setUserName("userName");
		userResponsedto.setEmail("email");
		
		userRequestDTO = new UserRequestDTO();
		userRequestDTO.setId(1L);
		userRequestDTO.setUserName("userName");
		userRequestDTO.setEmail("email");
		userRequestDTO.setPassword("password");
		userRequestDTO.setActive(true);
	}
	
	/**
	 * junit positive scenario for user creation
	 */
	@Test
	void createUser()
	{
		userservice.addUser(userRequestDTO);
		
		Mockito.when(userRepo.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);
	}
	
	/**
	 * junit positive scenario for retrieval of user based on user id
	 */
	@Test
	void fetchUser()
	{
		userservice.findUserByID(userRequestDTO.getId());
		
		Mockito.when(userRepo.findUserByid(Mockito.anyLong())).thenReturn(userEntity);
	}
	
	/**
	 * junit positive scenario for retrieval of user based on username
	 */
	@Test
	void fetchUserName()
	{
		userservice.findByUserName(userRequestDTO.getUserName());
		
		Mockito.when(userRepo.findByUserName(Mockito.any(String.class))).thenReturn(userEntity);
	}
	
	/**
	 * junit positive scenario for updating a user
	 */
	@Test
	void updateUser()
	{
		
		userservice.updateUser(userRequestDTO.getId(), userRequestDTO);
		
		Mockito.when(userRepo.findUserByid(Mockito.any(Long.class))).thenReturn(userEntity);
		
		Mockito.when(userRepo.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);
		
	}
	
//	@Test
//	void deleteUser() {
//		userservice.deleteUser(userRequestDTO.getId());
//		
//		Mockito.when(userRepo.findUserByid(Mockito.any(Long.class))).thenReturn(userEntity);
//		
//		Mockito.when(userRepo.delete(Mockito.any(UserEntity.class))).thenReturn(userEntity);
//		
//	}
	
}
