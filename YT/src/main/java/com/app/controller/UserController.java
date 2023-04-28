package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	//we have to create mathods to handle different requests
	@Autowired
	private UserService userService;
	
	//post - create user
//if password present in entity but we dont want to show then we use dto
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		//=we remove all data from user
		UserDto createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{userId}")//konala update karyach particular /{userId} yala path uri variable mhntat 
	//pathvariable madhe jo data yeil tyala fetch krnyasathi khali pathvariable ghetla
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
		
		
	}
	//je return karyacha ahe tyach atype mahit nsel tr question mark dila
	//admin
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse>  deleteUser(@PathVariable Integer userId){
	this.userService.deleteUser(userId);
		//delete method void ahe mg return khich nhi honar js vr update la kel ahe
	return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted",true), HttpStatus.OK);
	
	}
	
	@GetMapping("/")// for getting details of all users
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
