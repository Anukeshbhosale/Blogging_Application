package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepo;
import com.app.exc_handler.ResourceNotFoundException;
import com.app.pojos.User;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired

	private UserRepo userRepo;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	 @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			//loading user from database by username
	User user=	this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","email :+username",0));
		return user;
	}

}
