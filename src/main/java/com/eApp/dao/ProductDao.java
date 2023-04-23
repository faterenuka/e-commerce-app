package com.eApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eApp.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.category.categoryName = :categoryName")
	List<Product> getAllProductsByCategory(String categoryName);
}
