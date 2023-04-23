package com.eApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eApp.entity.Cart;
import com.eApp.entity.OrderDetails;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderDetailsException;
import com.eApp.exception.OrderException;
import com.eApp.exception.ProductException;
import com.eApp.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/cart")
    public ResponseEntity<Cart> getCartById(@RequestParam Integer id) throws CartException{
    	
    	return new ResponseEntity<Cart>(cartService.getCartById(id), HttpStatus.OK);
    }
	
	@PostMapping("/cart")
    public ResponseEntity<Cart> addProductToCart(@RequestParam String uuid,@RequestParam Integer customerId,@RequestParam Integer productId,@RequestParam Integer quantity) throws CustomerException, Exception{
    	
    	return new ResponseEntity<Cart>(cartService.addProductToCart(uuid,customerId, productId, quantity), HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/cart")
	public ResponseEntity<Cart> removeProductFromCart(@RequestParam Integer customerId,@RequestParam Integer productId) throws CustomerException, OrderException, ProductException, CartException{
		
		return new ResponseEntity<Cart>(cartService.removeProductFromCart(customerId, productId), HttpStatus.OK);
	}
	
	@PutMapping("/cart")
	public ResponseEntity<Cart>  updateProductQuality(@RequestParam Integer customerId,@RequestParam Integer pid,@RequestParam Integer quantity)
			throws CartException, Exception{
		
		return new ResponseEntity<Cart>(cartService.updateProductQuality(customerId, pid, quantity), HttpStatus.ACCEPTED);
	}

	@GetMapping("/cart/all")
	public ResponseEntity<List<OrderDetails>> viewAllProducts(@RequestParam Integer cartId) throws CartException, OrderDetailsException{
		
		return new ResponseEntity<List<OrderDetails>>(cartService.viewAllProducts(cartId),HttpStatus.OK);
	}

	@DeleteMapping("/cart/all")
	public ResponseEntity<Cart> removeAllProduct(@RequestParam Integer customerId) throws CustomerException, ProductException, CartException{
		
		return new ResponseEntity<Cart>(cartService.removeAllProduct(customerId),HttpStatus.OK);
	}

}
