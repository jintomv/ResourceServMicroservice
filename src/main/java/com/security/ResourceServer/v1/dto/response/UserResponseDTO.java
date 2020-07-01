package com.security.ResourceServer.v1.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.ResourceServer.v1.dto.request.UserRequestDTO;

public class UserResponseDTO extends UserRequestDTO{

	@Override
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@Override
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}
	
}
