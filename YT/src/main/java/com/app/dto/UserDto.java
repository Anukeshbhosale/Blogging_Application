package com.app.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.app.pojos.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto{
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be minimum of 4 characters")
	private String name;
	@Email(message="Email address is not valid!!")
	private String email;
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum of 3 chars and maximum of 10 chars !! ")
	
	private String password;
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles= new HashSet<>();
	
}