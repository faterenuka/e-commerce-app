package com.eApp.controller;

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

import com.eApp.entity.OrderDetails;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderException;
import com.eApp.exception.ProductException;
import com.eApp.service.OrderDetailsService;

@RestController
public class OrderDetailsController {

	@Autowired
	OrderDetailsService odService;
	
	@GetMapping("/orderDetails")
	public ResponseEntity<OrderDetails>getOrderDetailsById(@RequestParam Integer orderDetailsId) throws OrderException{
		
		return new ResponseEntity<OrderDetails>(odService.getOrderDetailsById(orderDetailsId), HttpStatus.OK);
	}
	
	@PostMapping("/orderDetails")
	public ResponseEntity<OrderDetails>addOrderDetails(@RequestParam Integer cartId,@RequestBody OrderDetails orderDetails) throws CartException, CustomerException, ProductException{
		
		return new ResponseEntity<OrderDetails>(odService.addOrderDetails(cartId,orderDetails), HttpStatus.CREATED);
	}
	
	@PutMapping("/orderDetails")
	public ResponseEntity<OrderDetails>updateOrderDetails(OrderDetails orderDetails) throws CartException{
		
		return new ResponseEntity<OrderDetails>(odService.updateOrderDetails(orderDetails), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/orderDetails")
	public ResponseEntity<OrderDetails> removeOrderDetails(@RequestParam Integer orderDetailsId,@RequestParam Integer orderId)throws Exception{
		
		return new ResponseEntity<OrderDetails>(odService.removeOrderDetails(orderDetailsId, orderId), HttpStatus.ACCEPTED);
	}

}
