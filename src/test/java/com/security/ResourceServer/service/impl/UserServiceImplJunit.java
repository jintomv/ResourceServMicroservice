package com.security.ResourceServer.service.impl;

import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

@RunWith(JUnitPlatform.class)
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
		user.setFirstname("Firstname");
		user.setLastname("Lastname");
		user.setGender("Gender");
		user.setDob(new Date());
		user.setAddress("Address");
		user.setUserMail("UserMail");
		user.setPhoneno(new Long(9642157841L));
		user.setOccupation("Occupation");
		user.setUserMail("UserMail");
		user.setQualification("Qualification");
		
		userEntity = new UserEntity();
		userEntity.setFirstname("Firstname");
		userEntity.setLastname("Lastname");
		userEntity.setGender("Gender");
		userEntity.setDob(new Date());
		userEntity.setAddress("Address");
		userEntity.setUserMail("UserMail");
		userEntity.setPhoneno(new Long(9642157841L));
		userEntity.setOccupation("Occupation");
		userEntity.setUserMail("UserMail");
		userEntity.setQualification("Qualification");
		
		userResponsedto = new UserResponseDTO();
		userResponsedto.setId(1L);
		userResponsedto.setFirstname("Firstname");
		userResponsedto.setLastname("Lastname");
		userResponsedto.setGender("Gender");
		userResponsedto.setDob(new Date());
		userResponsedto.setAddress("Address");
		userResponsedto.setUserMail("UserMail");
		userResponsedto.setPhoneno(new Long(9642157841L));
		userResponsedto.setOccupation("Occupation");
		userResponsedto.setUserMail("UserMail");
		userResponsedto.setQualification("Qualification");
		
		userRequestDTO = new UserRequestDTO();
		userRequestDTO.setFirstname("Firstname");
		userRequestDTO.setLastname("Lastname");
		userRequestDTO.setGender("Gender");
		userRequestDTO.setDob(new Date());
		userRequestDTO.setAddress("Address");
		userRequestDTO.setUserMail("UserMail");
		userRequestDTO.setPhoneno(new Long(9642157841L));
		userRequestDTO.setOccupation("Occupation");
		userRequestDTO.setUserMail("UserMail");
		userRequestDTO.setQualification("Qualification");
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
		userservice.findUserByID(1L);
		
		Mockito.when(userRepo.findUserByid(Mockito.anyLong())).thenReturn(userEntity);
	}
	
	/**
	 * junit positive scenario for retrieval of user based on username
	 */
//	@Test
//	void fetchUserName()
//	{
//		userservice.findByUserName(userRequestDTO.getUserName());
//		
//		Mockito.when(userRepo.findByUserName(Mockito.any(String.class))).thenReturn(userEntity);
//	}
	
	/**
	 * junit positive scenario for updating a user
	 */
	@Test
	void updateUser()
	{
		
		userservice.updateUser(1L, userRequestDTO);
		
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
