package com.security.ResourceServer.v1.dto.response;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.security.ResourceServer.v1.dto.request.UserRequestDTO;
import com.security.ResourceServer.v1.model.User;
/**
 * DTO class for sending the response
 * @author jinto varghese
 *
 */

public class UserResponseDTO extends UserRequestDTO{

	//properties
	@NotNull
	private Long id;
	
	private List<User> user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}


	
	
}
