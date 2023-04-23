package com.eApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Product product;
	private Integer quantity;
	private Double totalPrice;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Double getTotalPrice() {
		Double price=getProduct().getPrice();
		Integer q =getQuantity();
		totalPrice=(price*q);
		return totalPrice;
	}

	public void getTotalPrice(Double totalPrice) {
	
		this.totalPrice = totalPrice;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetails(Product product, Integer quantity) {
		
		this.product = product;
		this.quantity = quantity;
	}

	public OrderDetails(Integer id, Product product, Integer quantity, Double totalPrice) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		
		
	}
	
	
}
