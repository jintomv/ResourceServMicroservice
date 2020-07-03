package com.security.ResourceServer.v1.dto.request;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.security.ResourceServer.v1.model.User;

/**
 * 
 * Class is used as a data transfer object for Table user
 * 
 * @author jinto varghese
 *
 */
public class UserRequestDTO {
	
	@NotBlank(message="Please enter your firstname")
	@Size(min = 3, max = 15, message = "firstname must be between 3 and 15 characters")
	private String firstname;
	
	@NotBlank(message="Please enter your lastname")
	@Size(min = 3, max = 15, message = "lastname must be between 3 and 15 characters")
	private String  lastname;
	
	private String  gender;
	
	private Date dob;
	
	private String   address;
	
	@Email(message = "Email should be valid")
	private String  userMail;
	
	@Size(max = 10,message = "Not a valid phone number")
	private Long phoneno;
	
	private String  occupation;
	
	private String  qualification;

	
	
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

	
	public User toModel(UserRequestDTO userDTO)
	{
		User user = new User();
		try {
			user.setFirstname(userDTO.getFirstname());
			user.setLastname(userDTO.getLastname());
			user.setGender(userDTO.getGender());
			user.setDob(userDTO.getDob());
			user.setAddress(userDTO.getAddress());
			user.setUserMail(userDTO.getUserMail());
			user.setPhoneno(userDTO.getPhoneno());
			user.setOccupation(userDTO.getOccupation());
			user.setUserMail(userDTO.getUserMail());
			user.setPhoneno(userDTO.getPhoneno());
			user.setQualification(userDTO.getQualification());
		}
		catch(Exception e) {
			
		}
		return user;
		
	}

}
