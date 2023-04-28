package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
