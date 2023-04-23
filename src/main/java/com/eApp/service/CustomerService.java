package com.eApp.service;

import java.util.List;

import com.eApp.entity.Customer;
import com.eApp.exception.CustomerException;

public interface CustomerService {
	
    Customer getCustomer(Integer customerId) throws CustomerException;
	
	Customer addCustomer(Customer customer) throws Exception;
	
	Customer updateCustomer(Customer customer) throws Exception;
	
	Customer removeCustomer(Integer customerId) throws CustomerException;

	List<Customer> viewAllCustomer();
	
}
