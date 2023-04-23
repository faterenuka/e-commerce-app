package com.eApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eApp.dao.CategoryDao;
import com.eApp.dao.ProductDao;
import com.eApp.entity.Category;
import com.eApp.entity.Product;
import com.eApp.exception.ProductException;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	UserLoginService userLoginService;
	
	@Override
	public Product getByProductId(Integer id) throws ProductException {
		
		return productDao.findById(id).orElseThrow(() -> new ProductException("Product is not with id "+id));
	}

	@Override
	public Product addProduct(String uuid,Product product) throws Exception {
		
		userLoginService.getById(uuid);
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product) throws Exception {
		
		return productDao.save(product);
	}

	@Override
	public Product removeProduct(Integer pid) throws ProductException {
		
		Product product=getByProductId(pid);
	    productDao.delete(product);
		return product;
	}

	@Override
	public List<Product> viewAllProductsByCategory(String categoryName) {
		
		return productDao.getAllProductsByCategory(categoryName);
	}

	@Override
	public Category addCategory(Category category) {
		
		return categoryDao.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryDao.save(category);
	}

}
