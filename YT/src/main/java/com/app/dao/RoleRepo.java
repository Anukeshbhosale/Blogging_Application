package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Role;


public interface RoleRepo extends JpaRepository <Role, Integer>{

}
