/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserLogin;
import com.example.demo.repository.UserLoginRepository;

/**
 * @author Try
 *
 */
@Service
public class UserLoginService {
	@Autowired
	UserLoginRepository userLoginRepository;
	
	//Create
	public UserLogin createUserLogin(UserLogin model) {
		return userLoginRepository.save(model);
	}
	
	//Read
	public List<UserLogin> getUserLogin(){
		return userLoginRepository.findAll();
	}
	
	//Update
	public UserLogin updateUserLogin(Long id, UserLogin model) {
		UserLogin userLogin = userLoginRepository.getById(id);
		userLogin.setPassword(model.getPassword());
		userLogin.setRoleId(model.getRoleId());
		userLogin.setIsActive(model.getIsActive());
		return userLoginRepository.save(userLogin);
	}
	
	//Delete
	public void deleteUserLogin(Long id) {
		userLoginRepository.deleteById(id);
	}
}
