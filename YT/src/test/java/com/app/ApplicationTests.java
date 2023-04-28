package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dao.UserRepo;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private UserRepo userRepo;
	//he ithe test madhe ghetle karn aplyala find karyacha he UserRepo varible kontya class fetch krat ahe karan userRepo interface banvala ahe
	//sobat package pn kadhu shakto apn Reflection api cha vapar krun

	@Test
	void contextLoads() {
	}
	@Test
	
public void repoTest() {
		//reflection api
		//com.sun.proxy.$Proxy108; compiler generate this class name by spring container at run time based on UserRepo interface 
		//above class is implementaion class of userRepo
		
	String className=this.userRepo.getClass().getName();
	String packName=this.userRepo.getClass().getPackageName();
	System.out.println(className);
	System.out.println(packName);
}
}
