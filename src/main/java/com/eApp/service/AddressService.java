package com.eApp.service;

import java.util.List;

import com.eApp.entity.Address;
import com.eApp.exception.AddressException;

public interface AddressService {

	Address getAddress(Integer addressId) throws AddressException;
	
	Address addAddress(Address address) throws Exception;
	
	Address updateAddress(Address address) throws Exception;
	
	Address removeAddress(Integer addressId) throws AddressException;
	
	List<Address> viewAllAddress();
	
	List<Address> viewAllAddressByCity(String city);
}
