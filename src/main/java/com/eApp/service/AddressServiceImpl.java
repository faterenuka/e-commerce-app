package com.eApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eApp.dao.AddressDao;
import com.eApp.entity.Address;
import com.eApp.exception.AddressException;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressDao addressDao;
	
	@Override
	public Address getAddress(Integer addressId) throws AddressException {
		
		return addressDao.findById(addressId).orElseThrow(() -> new AddressException("Address is not present of id "+addressId));
	}

	@Override
	public Address addAddress(Address address) throws Exception {
		
	    address.setPincode(address.getPincode());
		return addressDao.save(address);
	}

	@Override
	public Address updateAddress(Address address) throws Exception {
		
		 address.setPincode(address.getPincode());
		return addressDao.save(address);
	}

	@Override
	public Address removeAddress(Integer addressId) throws AddressException {
		
		Address address=getAddress(addressId);
		addressDao.delete(address);
		return address;
	}

	@Override
	public List<Address> viewAllAddress() {
		
		return addressDao.findAll();
	}

	@Override
	public List<Address> viewAllAddressByCity(String city) {
		
		return addressDao.findAllByCity(city);
	}
}
