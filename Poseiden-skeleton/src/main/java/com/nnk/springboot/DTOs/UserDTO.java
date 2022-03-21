package com.nnk.springboot.DTOs;

import javax.validation.constraints.NotBlank;

import com.nnk.springboot.util.ValidPasswordConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	@NotBlank
	private String username;
	
	@ValidPasswordConstraint
	private String password;

	private String fullname;

	private String role;

}
