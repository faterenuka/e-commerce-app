package com.eApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eApp.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
