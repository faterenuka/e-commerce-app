package com.eApp.service;

import com.eApp.entity.UserLogin;
import com.eApp.exception.UserLoginException;

public interface UserLoginService {

	UserLogin logIn(String mobilNumber,String encreptedPassword) throws UserLoginException;
	
	UserLogin getById(String uuid) throws UserLoginException;
	
	void logOut(String uuid) throws UserLoginException;
	
}
