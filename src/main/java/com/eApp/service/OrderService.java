package com.eApp.service;

import java.time.LocalDate;
import java.util.List;

import com.eApp.entity.Orders;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderException;

public interface OrderService {

	Orders getOrderById(Integer orderId) throws OrderException;
	
    Orders addOrder(String uuid,Orders order,Integer customerId) throws CartException, CustomerException, Exception;
	
	Orders updateOrder(Orders order) throws CartException, CustomerException;
	
	Orders removeOrder(Integer customerId) throws OrderException, Exception;
	
	List<Orders> viewAllOrder(LocalDate date);
	
	List<Orders> viewAllOrderByLocation(String loc);
	
}
