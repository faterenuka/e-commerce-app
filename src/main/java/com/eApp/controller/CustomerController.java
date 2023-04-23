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

import com.eApp.entity.Customer;
import com.eApp.exception.CustomerException;
import com.eApp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public ResponseEntity<Customer>getCustomer(@RequestParam Integer customerId) throws CustomerException{
		
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception{
		
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer>updateCustomer(@RequestBody Customer customer) throws Exception{
		
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/customer")
	public ResponseEntity<Customer> removeCustomer(@RequestParam Integer customerId) throws CustomerException{
		return new ResponseEntity<Customer>(customerService.removeCustomer(customerId), HttpStatus.OK);
	}
	
	@GetMapping("/customer/all")
	public ResponseEntity<List<Customer>>viewAllCustomer(){
		
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomer(),HttpStatus.OK);
	}
}
