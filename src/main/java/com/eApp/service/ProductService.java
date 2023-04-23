package com.eApp.service;

import java.util.List;

import com.eApp.entity.Category;
import com.eApp.entity.Product;
import com.eApp.exception.ProductException;


public interface ProductService {

	Product getByProductId(Integer id) throws ProductException;
	
	Product addProduct(String uuid,Product product) throws ProductException, Exception;
	
	Product updateProduct(Product product) throws ProductException, Exception;
	
	Product removeProduct(Integer pid) throws ProductException;
	
	Category addCategory(Category category);
	
	Category updateCategory(Category category);

	List<Product> viewAllProductsByCategory(String categoryName);
}
