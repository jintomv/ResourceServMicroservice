package com.security.ResourceServer.v1.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.ResourceServer.v1.model.User;
import com.sun.istack.NotNull;

/**
 * 
 * Class is used as a data transfer object for Table user
 *
 */
public class UserRequestDTO {

	//@NotNull
	protected Long id;
	

	@Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")
	protected String userName;
	
	@JsonIgnore
	private String password;
	
	@Email(message = "Email should be valid")
	private String email;
	
	@JsonIgnore
	private boolean active;
	
	
	
	/**
	 * 
	 * @return user id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param userID set the user ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	/**
	 * 
	 * @return Name of the user
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 
	 * @param userName is set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString()
	{
		return "DTO [userID=" + this.id + ", userName="
				+ this.userName + "]";
		
	}
	
	public User toModel(UserRequestDTO userDTO)
	{
		User user = new User();
		try {
			user.setId(userDTO.getId());
			user.setUserName(userDTO.getUserName());
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setActive(userDTO.isActive());
		}
		catch(Exception e) {
			
		}
		return user;
		
	}

}
