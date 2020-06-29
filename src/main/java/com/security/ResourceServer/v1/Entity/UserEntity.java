package com.security.ResourceServer.v1.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Class is for entity representation of DB table user
 *
 */
@Entity
@Table(name = "User_Details")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userMail")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private Boolean active;
	
	
	
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
	public void setActive(Boolean active) {
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
		return "UserEntity [id=" + this.id + "]";
	}


	/**
	 * Method return DTO representation of current Entity
	 * @return UserDTO
	 */
//	public UserResponseDTO toDTO() {
//		
//		UserResponseDTO responseDTO = new UserResponseDTO();
//		
//		responseDTO.setUserID(getId());
//		responseDTO.setUserName(getUserName());
//		
//		return responseDTO;
//	}
}
