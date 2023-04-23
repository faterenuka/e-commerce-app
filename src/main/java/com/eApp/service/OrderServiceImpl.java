package com.eApp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eApp.dao.CartDao;
import com.eApp.dao.OrderDao;
import com.eApp.dao.ProductDao;
import com.eApp.entity.Cart;
import com.eApp.entity.Customer;
import com.eApp.entity.OrderDetails;
import com.eApp.entity.Orders;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderException;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	UserLoginService userLoginService;
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@Override
	public Orders getOrderById(Integer orderId) throws OrderException {
		
		return orderDao.findById(orderId).orElseThrow(()-> new OrderException("Order is not present with id: "+orderId));
	}

	@Override
	public Orders addOrder(String uuid,Orders orders,Integer customerId) throws Exception {
		
		userLoginService.getById(uuid);
		Customer customer=customerService.getCustomer(customerId);
		Cart cart=cartDao.findByCustomerId(customerId);
		if(cart!= null) {
	
			LocalDate today=LocalDate.now();
			List<OrderDetails>orderDetail=new ArrayList<>(cart.getOrderDetails());
			if(orderDetail.size() != 0) {
				
				for(int i=0;i<orderDetail.size();i++) {
					OrderDetails od=orderDetail.get(i);
					od.getProduct().setProductQuantity(od.getProduct().getProductQuantity()-od.getQuantity());
					productDao.save(od.getProduct());
					
				}
			}
			orders.setCustomer(customer);
			orders.setDate(today);
			orders.setOrderDetails(orderDetail);
//			orders.setAddress(customer.getAddress());
		    orders=orderDao.save(orders);
			cart.getOrderDetails().clear();
		    cartDao.save(cart);
		    return orders;
		}
		else
			throw new CartException("You donot have cart...");
		
	}

	@Override
	public Orders updateOrder(Orders order) throws CartException, CustomerException {
		
		return orderDao.save(order);
	}

	@Override
	public Orders removeOrder(Integer orderId) throws Exception {
		
		Orders order=getOrderById(orderId);
		List<OrderDetails>orderDetails=order.getOrderDetails();
		if(orderDetails.size() != 0) {
			for(int i=0;i<orderDetails.size();i++) {
				OrderDetails od=orderDetails.get(i);
				od.getProduct().setProductQuantity(od.getQuantity()+od.getProduct().getProductQuantity());
				productDao.save(od.getProduct());
				
			}
			orderDetails.clear();
			orderDao.delete(order);
			return order;
		}else
			throw new OrderException("order is empty");
		
	}

	@Override
	public List<Orders> viewAllOrder(LocalDate date) {
		
		return orderDao.findAllByDate(date);
	}

	@Override
	public List<Orders> viewAllOrderByLocation(String city) {
		
		return orderDao.findAllOrdersByCity(city);
	}

}
