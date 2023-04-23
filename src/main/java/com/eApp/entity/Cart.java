package com.eApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<OrderDetails> orderDetails = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer id, Customer customer, List<OrderDetails> orderDetails) {
		super();
		this.id = id;
		this.customer = customer;
		this.orderDetails = orderDetails;
	}
	
	
}
