package com.eApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eApp.entity.UserLogin;

public interface UserLoginDao extends JpaRepository<UserLogin, String>{

}
