package com.eApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eApp.entity.Category;
import com.eApp.entity.Product;
import com.eApp.exception.ProductException;
import com.eApp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<Product>getByProductId(@RequestParam Integer id) throws ProductException{
	
		return new ResponseEntity<Product>(productService.getByProductId(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product>addProduct(@RequestParam String uuid,@RequestBody Product product) throws Exception{
		
		return new ResponseEntity<Product>(productService.addProduct(uuid,product), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/product")
	public ResponseEntity<Product>updateProduct(@RequestBody Product product) throws Exception{
		
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/product")
    public ResponseEntity<Product> removeProduct(@RequestParam Integer pid) throws ProductException{
    	
    	return new ResponseEntity<Product>(productService.removeProduct(pid), HttpStatus.OK);
    }
	
	@GetMapping("/product/all")
	public ResponseEntity<List<Product>> viewAllProductsByCategory(@RequestParam String categoryName){
		
		return new ResponseEntity<List<Product>>(productService.viewAllProductsByCategory(categoryName), HttpStatus.OK);
	}
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		return new ResponseEntity<Category>(productService.addCategory(category), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/category")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		return new ResponseEntity<Category>(productService.updateCategory(category), HttpStatus.ACCEPTED);
	}
}
