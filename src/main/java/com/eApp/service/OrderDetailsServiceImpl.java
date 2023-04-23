package com.eApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eApp.dao.OrderDao;
import com.eApp.dao.OrderDetailsDao;
import com.eApp.dao.ProductDao;
import com.eApp.entity.Cart;
import com.eApp.entity.OrderDetails;
import com.eApp.entity.Orders;
import com.eApp.exception.CartException;
import com.eApp.exception.OrderException;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	OrderDetailsDao orderDetailsDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartService cartService;
	
	@Override
	public OrderDetails getOrderDetailsById(Integer orderDetailsId) throws OrderException {
		
		return orderDetailsDao.findById(orderDetailsId).orElseThrow(() -> new OrderException("OrderDetails not found of id "+orderDetailsId));
	}
	
	@Override
	public OrderDetails addOrderDetails(Integer cartId,OrderDetails orderDetails) throws CartException {
		
		Cart cart=cartService.getCartById(cartId);
		if(cart == null) {
			
			throw new CartException("Cart is null");
		}else
		    orderDetails.getTotalPrice();
		    return orderDetailsDao.save(orderDetails);
	}

	@Override
	public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
		
		orderDetails.getTotalPrice();
		
		return orderDetailsDao.save(orderDetails);
	}

	@Override
	public OrderDetails removeOrderDetails(Integer orderDetailsId, Integer orderId) throws Exception {
		
		Orders op=orderDao.findById(orderId).orElseThrow(() ->new OrderException("Order is not present of id: "+orderId));
		List<OrderDetails>od=op.getOrderDetails();
		OrderDetails deletedOrderDetails=null;
		for(int i=0;i<od.size();i++) {
			OrderDetails orderDetails=od.get(i);
			if(orderDetails.getId()==orderDetailsId) {
				
				Integer totaluantity=orderDetails.getQuantity()+orderDetails.getProduct().getProductQuantity();
				orderDetails.getProduct().setProductQuantity(totaluantity);
				productDao.save(orderDetails.getProduct());
				od.remove(i);
				deletedOrderDetails=orderDetails;
				
			}
		}
		orderDao.save(op);
		return deletedOrderDetails;
	}

}
