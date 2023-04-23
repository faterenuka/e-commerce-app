package com.eApp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eApp.entity.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer> {

	List<Orders> findAllByDate(LocalDate date);
	
	@Query("select o from Orders o where o.customer.address.city = :city")
	List<Orders>findAllOrdersByCity(String city);
}
