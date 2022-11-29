package com.farmer.labour.collabaration.farmerlabour.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserRequest {
	
	@NotBlank @NotNull
	private String phone;
	@NotBlank @NotNull
	private String password;
}