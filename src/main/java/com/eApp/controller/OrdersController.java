package com.eApp.controller;

import java.time.LocalDate;
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

import com.eApp.entity.Orders;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderException;
import com.eApp.service.OrderService;

@RestController
public class OrdersController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
    public ResponseEntity<Orders> getOrderById(@RequestParam Integer orderId) throws OrderException{
    	
    	return new ResponseEntity<Orders>(orderService.getOrderById(orderId),HttpStatus.OK);
    }
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrder(@RequestParam String uuid,@RequestBody Orders order,@RequestParam Integer customerId) throws Exception{
		 
		 return new ResponseEntity<Orders>(orderService.addOrder(uuid,order,customerId),HttpStatus.ACCEPTED);
	 }
	
	@PutMapping("/orders")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) throws CartException, CustomerException{
		
	     return new ResponseEntity<Orders>(orderService.updateOrder(order),HttpStatus.ACCEPTED);
    
	}
	
	@DeleteMapping("/orders")
	public ResponseEntity<Orders> removeOrder(@RequestParam Integer customerId) throws Exception{
		
	     return new ResponseEntity<Orders>(orderService.removeOrder(customerId), HttpStatus.OK);
	}
	
	@GetMapping("/orders/all")
	public ResponseEntity<List<Orders>> viewAllOrder(@RequestParam LocalDate date){
		
		return new ResponseEntity<List<Orders>>(orderService.viewAllOrder(date), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/orders/all/location")
	public ResponseEntity<List<Orders>> viewAllOrderByLocation(@RequestParam String loc){
		
		return new ResponseEntity<List<Orders>>(orderService.viewAllOrderByLocation(loc), HttpStatus.ACCEPTED);
	}
	
}
