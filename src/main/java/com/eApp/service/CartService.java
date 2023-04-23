package com.eApp.service;

import java.util.List;

import com.eApp.entity.Cart;
import com.eApp.entity.OrderDetails;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderDetailsException;
import com.eApp.exception.OrderException;
import com.eApp.exception.ProductException;

public interface CartService {
 
	Cart getCartById(Integer id) throws CartException;
	
    Cart addProductToCart(String uuid, Integer customerId, Integer productId, Integer quantity) throws CustomerException, Exception;
	
	Cart removeProductFromCart(Integer customerId, Integer productId) throws CustomerException, OrderException, ProductException, CartException;
	
	Cart updateProductQuality(Integer customerId, Integer pid, Integer quantity)
			throws CustomerException, OrderException, ProductException, CartException, Exception;

	List<OrderDetails> viewAllProducts(Integer cartId) throws CartException, OrderDetailsException;

	Cart removeAllProduct(Integer customerId) throws CustomerException, ProductException, CartException;

	
}
