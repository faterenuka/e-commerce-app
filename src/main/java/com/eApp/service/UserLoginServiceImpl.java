package com.eApp.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eApp.dao.CustomerDao;
import com.eApp.dao.UserLoginDao;
import com.eApp.entity.Customer;
import com.eApp.entity.UserLogin;
import com.eApp.exception.UserLoginException;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	UserLoginDao userLoginDao;
	
	@Autowired
	CustomerDao customerDao;
	
	public static String hashPassword(String password) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashedPassword) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        // Handle exception
	    }
	    return null;
	}
	
	@Override
	public UserLogin logIn(String mobileNumber, String password) throws UserLoginException {
		
		Customer customer=customerDao.findByMobileNoAndPassword(mobileNumber,hashPassword(password));
		if(customer !=null) {
			
			UserLogin userLogin=new UserLogin();
			String uuid=RandomString.make(4);
			userLogin.setCustomerId(customer.getId());
			userLogin.setDate(LocalDateTime.now());
			userLogin.setUuid(uuid);
			userLoginDao.save(userLogin);
			return userLogin;
			
		}else 
			throw new UserLoginException("Create Customer first...");
		
	}

	@Override
	public void logOut(String uuid) throws UserLoginException {
		
		UserLogin userLogin=getById(uuid);
		userLoginDao.delete(userLogin);
	}

	@Override
	public UserLogin getById(String uuid) throws UserLoginException {
		
		Optional<UserLogin> userLogin=userLoginDao.findById(uuid);
		if(userLogin.isPresent()) {
			
			return userLogin.get();
		}
		else
			throw new UserLoginException("Invalid UUID!!!! login first...");
		
	}

}
