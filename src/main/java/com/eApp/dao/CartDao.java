package com.eApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eApp.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{

	@Query("select c from Cart c where c.customer.id = :customerId")
	Cart findByCustomerId(Integer customerId);
}
