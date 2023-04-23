package com.eApp.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eApp.dao.CustomerDao;
import com.eApp.entity.Customer;
import com.eApp.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	AddressService addressService;
	
	public static String hashPassword(String password) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashedPassword) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        // Handle exception
	    }
	    return null;
	}
	
	@Override
	public Customer getCustomer(Integer customerId) throws CustomerException {
		
		return customerDao.findById(customerId).orElseThrow(() -> new CustomerException(" Customer is not present with id: "+customerId));
		 
	}
	
	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		
		customer.setMobileNo(customer.getMobileNo());

		customer.setPassword(hashPassword(customer.getPassword()));
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws Exception {
		
		customer.setMobileNo(customer.getMobileNo());
		customer.setPassword(hashPassword(customer.getPassword()));
		return customerDao.save(customer);
	}

	

	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerException {
		
		Customer customer=getCustomer(customerId);
		customerDao.delete(customer);
		
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		
		return customerDao.findAll();
	}

}
