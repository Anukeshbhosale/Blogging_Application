package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.config.AppConstants;
import com.app.dao.RoleRepo;
import com.app.dao.UserRepo;
import com.app.dto.UserDto;
import com.app.pojos.Role;
import com.app.pojos.User;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import com.app.exc_handler.*;
@Service
public class UserServiceImpl implements UserService {

	//sagle operations perform krnyasathi aplyala repository pahije
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		//aplyala pass karyacha ahe user pn aplyakde userdto ahe tr aplyala userdto la user madhe convert karyache ahe
		//ya conversion sathi apn Model mapper use kru shakto pn sadhya apn dto to entity method vapru or entity to dto vapru
		
		User user = this.dtoToUser(userDto);
		this.userRepo.save(user);
		 User savedUser = this.userRepo.save(user);
		 
		return this.userToDto(savedUser);
	}
    
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		//jr user nhi bhetla tr exception throw karyachi
		
			User user1 = this.userRepo.findById(userId).orElseThrow(()-> new  ResourceNotFoundException (" User ","Id",userId));
		user1.setName(userDto.getName());
		user1.setEmail(userDto.getEmail());
		user1.setPassword(user1.getPassword());
		user1.setAbout(userDto.getAbout());
		
		User updatedUser=this.userRepo.save(user1);
		UserDto userDto1=this.userToDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
		//ithe vr map for each pn vaprta yet hota
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		
	}

	//dto to user
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		
//		User user= new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
		
	}
  //user to dto
	
	public UserDto userToDto(User user) {
		UserDto userDto=this.modelMapper.map(user,UserDto.class);
		
		return userDto;
		
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto, User.class);
		//encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		//roles 
		Role role=this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		
		user.getRoles().add(role);
		
		User newUser = this.userRepo.save(user);
		
		return this.modelMapper.map(newUser, UserDto.class);
	}
	

}
