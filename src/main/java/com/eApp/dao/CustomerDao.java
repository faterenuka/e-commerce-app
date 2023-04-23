package com.eApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eApp.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Customer findByMobileNoAndPassword(String mobile_no,String encreptedPassword);
}
