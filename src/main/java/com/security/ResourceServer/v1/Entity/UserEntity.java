package com.security.ResourceServer.v1.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.security.ResourceServer.v1.model.User;

/**
 * 
 * Class is for entity representation of DB table userdetails
 * 
 * @author jinto varghese
 *
 */
@Entity
@Table(name = "userdetails")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstName",length = 50)
	private String firstname;
	
	@Column(name = "lastName",length = 50)
	private String  lastname;
	
	@Column(name = "gender",length = 10)
	private String  gender;
	
	@Column(name = "dateOfBirth",length = 20)
	private Date dob;
	
	@Column(name = "address",length = 300)
	private String   address;
	
	@Column(name = "email",length = 50)
	private String  userMail;
	
	@Column(name = "phoneNo",length = 30)
	private Long phoneno;
	
	@Column(name = "occupation",length = 30)
	private String  occupation;
	
	@Column(name = "qualification",length = 20)
	private String  qualification;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + this.id + ","
				+ "firstname=" + this.firstname + ","
				+ "lastname=" + this.lastname + ","
				+ "gender=" + this.gender + ","
				+ "dob=" + this.dob + ","
				+ "address=" + this.address + ","
				+ "userMail=" + this.userMail + ","
				+ "phoneno=" + this.phoneno + ","
				+ "occupation=" + this.occupation + ","
				+ "qualification=" + this.qualification + "]";
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
	
	/**
	 * Method used to convert a userEntity object to user
	 * @param userEntity
	 * @return
	 */
	public User toModel(UserEntity userEntity)
	{
		User user = new User();
		try {
			user.setId(userEntity.getId());
			user.setFirstname(userEntity.getFirstname());
			user.setLastname(userEntity.getLastname());
			user.setGender(userEntity.getGender());
			user.setDob(userEntity.getDob());
			user.setAddress(userEntity.getAddress());
			user.setUserMail(userEntity.getUserMail());
			user.setPhoneno(userEntity.getPhoneno());
			user.setOccupation(userEntity.getOccupation());
			user.setQualification(userEntity.getQualification());
		}
		catch(Exception e) {
		}
		return user;
	}
}
