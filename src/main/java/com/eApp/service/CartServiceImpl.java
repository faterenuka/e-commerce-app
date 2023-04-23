package com.eApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eApp.dao.CartDao;
import com.eApp.dao.OrderDetailsDao;
import com.eApp.dao.ProductDao;
import com.eApp.entity.Cart;
import com.eApp.entity.Customer;
import com.eApp.entity.OrderDetails;
import com.eApp.entity.Product;
import com.eApp.exception.CartException;
import com.eApp.exception.CustomerException;
import com.eApp.exception.OrderDetailsException;
import com.eApp.exception.OrderException;
import com.eApp.exception.ProductException;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderDetailsDao orderDetailsDao;
	
	@Autowired
	UserLoginService userLoginService;
	
	@Override
	public Cart getCartById(Integer id) throws CartException {
		
		return cartDao.findById(id).orElseThrow(() ->new CartException("Cart is not present"));

	}

	@Override
	public Cart addProductToCart(String uuid,Integer customerId, Integer productId, Integer quantity)
			throws CustomerException, Exception {
		
		userLoginService.getById(uuid);
		Product product=productService.getByProductId(productId);
		if(quantity<=0 && quantity!=null) {
            if(product.getProductQuantity()<quantity)
            	throw new CartException("Quantity should be less than product Quantity!!!");
			
        else
        throw new CartException("quantity should be more than 0");
		
		}
		
		Customer customer=customerService.getCustomer(customerId);
		Cart cart=cartDao.findByCustomerId(customerId);
		    if(cart ==null) {
			   cart=new Cart();
			   cart.setCustomer(customer);
		    }
		OrderDetails od=new OrderDetails(product,quantity);
		cart.getOrderDetails().add(od);
		return cartDao.save(cart);
			
	}

	@Override
	public Cart removeProductFromCart(Integer customerId, Integer orderDetailsId) throws CustomerException, OrderException, ProductException, CartException {
 
		
		Cart cart=cartDao.findByCustomerId(customerId);
		if(cart != null) {
			
			List<OrderDetails>od = cart.getOrderDetails();
			if(od.size() != 0) {
				
				for(int i=0;i<od.size();i++) {
					
					OrderDetails orderDetails=od.get(i);
					if(orderDetails.getId()==orderDetailsId) {

                        od.remove(orderDetails);
						return cartDao.save(cart);
					}
				}
				throw new OrderException("Product is not in the cart");

			}
			else 
				throw new CartException("There is No Product in the cart");
		}
		
		else {
			throw new OrderException("You donot have any cart");
		}
	}

	@Override
	public Cart updateProductQuality(Integer customerId, Integer pid, Integer quantity)
			throws Exception {
		
		Cart cart=cartDao.findByCustomerId(customerId);
		Product product=productService.getByProductId(pid);
		
		if(cart != null) {
			
			List<OrderDetails>od=cart.getOrderDetails();
			if(od.size() !=0) {
				
				for(int i=0;i<od.size();i++) {
					OrderDetails orderDetails=od.get(i);
					if(orderDetails.getProduct()==product) {
						if(orderDetails.getProduct().getProductQuantity()>=quantity) {
						    orderDetails.setQuantity(quantity);
						    orderDetailsDao.save(orderDetails);
					    }else 
						    throw new OrderDetailsException("Product Quantity is not enough!!");
					    
					}
					else 
						throw new OrderException("product is not present there..");
					
				}
				
			}
			return cartDao.save(cart);
			
		}else
			throw new CartException("Cart is null");
		
	}

	@Override
	public List<OrderDetails> viewAllProducts(Integer cartId) throws CartException, OrderDetailsException{
		Cart cart=getCartById(cartId);
		if(cart != null) {
			
			 return cart.getOrderDetails();
		}
		else
			throw new CartException("Cart is null");
		
	}

	@Override
	public Cart removeAllProduct(Integer customerId)
			throws CustomerException, ProductException, CartException {
		
		Cart cart=cartDao.findByCustomerId(customerId);
		if(cart != null) {
			cart.getOrderDetails().clear();
			cartDao.save(cart);
			
		}
		return cart;
	}


}
