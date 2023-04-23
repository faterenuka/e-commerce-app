package com.eApp.service;

import com.eApp.entity.OrderDetails;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderException;
import com.eApp.exception.ProductException;

public interface OrderDetailsService {
	
	OrderDetails getOrderDetailsById(Integer orderDetailsId) throws OrderException;

    OrderDetails addOrderDetails(Integer cartId,OrderDetails orderDetails) throws CartException, CustomerException, ProductException;
	
	OrderDetails updateOrderDetails(OrderDetails orderDetails);

	OrderDetails removeOrderDetails(Integer orderDetailsId, Integer orderId) throws OrderException, Exception;

}
