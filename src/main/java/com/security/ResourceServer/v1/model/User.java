package com.security.ResourceServer.v1.model;

import java.util.Date;

import com.security.ResourceServer.v1.Entity.UserEntity;
/**
 * 
 * @author jinto varghese
 *
 */
public class User {
	
	private Long id;
	private String firstname;
	private String  lastname;
	private String  gender;
	private Date dob;
	private String   address;
	private String  userMail;
	private Long phoneno;
	private String  occupation;
	private String  qualification;
	
	
	
	
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
	
	public UserEntity toEntity(User user)
	{
		UserEntity userEntity = new UserEntity();
		try {
			userEntity.setId(user.getId());
			userEntity.setFirstname(user.getFirstname());
			userEntity.setLastname(user.getLastname());
			userEntity.setGender(user.getGender());
			userEntity.setDob(user.getDob());
			userEntity.setAddress(user.getAddress());
			userEntity.setUserMail(user.getUserMail());
			userEntity.setPhoneno(user.getPhoneno());
			userEntity.setOccupation(user.getOccupation());
			userEntity.setQualification(user.getQualification());
		}
		catch(Exception e) {
		}
		return userEntity;
	}
	
	
	/**
	 * user bean that returns with user id
	 * @param id
	 */
	public User(Long id)
	{
		this.id = id;
	}
	
	/**
	 * user bean that returns with
	 * @param firstName
	 * @param lastName
	 */
	public User(String firstName, String lastName)
	{
		this.firstname = firstName;
		this.lastname = lastName;
	}
}
