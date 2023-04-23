package com.eApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eApp.entity.UserLogin;
import com.eApp.exception.UserLoginException;
import com.eApp.service.UserLoginService;

@RestController
public class UserLogInController {

	@Autowired
	UserLoginService userLoginService;
	
	@PostMapping("/user/login")
    public ResponseEntity<UserLogin> logIn(@RequestParam String mobilNumber,@RequestParam String password) throws UserLoginException{
    	
    	return new ResponseEntity<UserLogin>(userLoginService.logIn(mobilNumber, password), HttpStatus.ACCEPTED);
    }
	
	@GetMapping("/user/login")
    public ResponseEntity<UserLogin> getById(@RequestParam String uuid) throws UserLoginException{
    	
    	return new ResponseEntity<UserLogin>(userLoginService.getById(uuid), HttpStatus.OK);
    }
	
	@DeleteMapping("/user/login")
	public ResponseEntity<Void> logOut(@RequestParam String uuid) throws UserLoginException{
		
		userLoginService.logOut(uuid);
	     return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
