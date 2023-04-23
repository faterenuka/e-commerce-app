package com.eApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eApp.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

	List<Address> findAllByCity(String city);
}
