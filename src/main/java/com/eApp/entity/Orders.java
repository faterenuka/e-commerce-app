package com.eApp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDate date;
	private String orderStatus;
	
	@OneToMany
	private List<OrderDetails> orderDetails;
	
	@OneToOne
	private Customer customer;

//	@OneToOne
//	private Address address;
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer orderId, LocalDate date, String orderStatus, List<com.eApp.entity.OrderDetails> orderDetails,
			com.eApp.entity.Customer customer) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.orderStatus = orderStatus;
		this.orderDetails = orderDetails;
		this.customer = customer;
	}
	
	
}
