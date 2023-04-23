package com.eApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String productName;
	private double price;
	private String color;
	private String specification;
	private String manufactorer;
	private Integer productQuantity;
	
	@ManyToOne
	private Category category;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	public String getManufactorer() {
		return manufactorer;
	}
	public void setManufactorer(String manufactorer) {
		this.manufactorer = manufactorer;
	}
	
	public Integer getProductQuantity() {
		if(productQuantity>=0) {
		   return productQuantity;
		}else
			return 0;
	}
	public void setProductQuantity(Integer productQuantity) throws Exception {
		    if(productQuantity>=0)
		       this.productQuantity = productQuantity;
		    else
		    	throw new Exception("Product should not be negative");
		    	
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id, String productName, double price, String color, String specification,
			String manufactorer, Integer productQuantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.specification = specification;
		this.manufactorer = manufactorer;
		this.productQuantity = productQuantity;
	}
	
	
}
