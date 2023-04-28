package com.app.service;

import java.util.List;

import com.app.dto.UserDto;
import com.app.exc_handler.ResourceNotFoundException;
import com.app.pojos.User;

public interface UserService {
	//userDto is used here for operations
	//in userdto we add the entity which take from user
	//in userdto the data are directly exposed 
	//so, User data are remained safe unexposed
	
	UserDto registerNewUser(UserDto user);
 UserDto createUser(UserDto user);
 //not give entity direct in service because we want to pass directly
 UserDto updateUser(UserDto user,Integer userId) throws ResourceNotFoundException;
 UserDto getUserById(Integer userId);
 List<UserDto> getAllUsers();
 void deleteUser(Integer userId);
}
