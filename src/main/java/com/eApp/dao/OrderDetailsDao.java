package com.eApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eApp.entity.OrderDetails;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer>{

}
