package com.security.ResourceServer.v1.model;

import com.security.ResourceServer.v1.Entity.UserEntity;

public class User {
	
	private Long id;
	private String userName;
	private String email;
	private String password;
	private boolean active;
	
	
	
	
	
	//Getters and setters
	
	public User()
	{
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "user [id=" + this.id + ", userName="
				+ this.userName + ",email="+this.email+",password="+this.password+",active="+this.active+"]";
	}
	public UserEntity toEntity(User user)
	{
		UserEntity userEntity = new UserEntity();
		try {
			userEntity.setId(user.getId());
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity.setEmail(user.getEmail());
			userEntity.setActive(user.getActive());
		}
		catch(Exception e) {
		}
		return userEntity;
	}
	
	public User(Long id)
	{
		this.id = id;
	}

}
