package com.eApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eApp.entity.Address;
import com.eApp.exception.AddressException;
import com.eApp.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping("/address")
	public ResponseEntity<Address>getAddress(@RequestParam Integer addressId) throws AddressException{
		
		return new ResponseEntity<Address>(addressService.getAddress(addressId), HttpStatus.OK);
	}
	
	@PostMapping("/address")
    public ResponseEntity<Address>addAddress(@RequestBody Address address) throws Exception{
		
		return new ResponseEntity<Address>(addressService.addAddress(address), HttpStatus.CREATED);
	}
    
	@PutMapping("/address")
    public ResponseEntity<Address>updateAddress(@RequestBody Address address) throws Exception{
		
		return new ResponseEntity<Address>(addressService.updateAddress(address), HttpStatus.ACCEPTED);
	}
    
	@DeleteMapping("/address")
    public ResponseEntity<Address>removeAddress(@RequestParam Integer addressId) throws AddressException{
		
		return new ResponseEntity<Address>(addressService.removeAddress(addressId), HttpStatus.OK);
	}
	
	@GetMapping("/address/all")
	public ResponseEntity<List<Address>> viewAllAddress(){
		
		return new ResponseEntity<List<Address>>(addressService.viewAllAddress(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/address/all/city")
	public ResponseEntity<List<Address>>viewAllAddressByCity(String city){
		
		return new ResponseEntity<List<Address>>(addressService.viewAllAddressByCity(city),HttpStatus.OK);
	}
}
