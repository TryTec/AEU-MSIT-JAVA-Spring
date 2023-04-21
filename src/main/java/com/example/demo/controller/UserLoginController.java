/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserLogin;
import com.example.demo.service.UserLoginService;

/**
 * @author Try
 *
 */
@RestController
@RequestMapping("/api")
public class UserLoginController {
	@Autowired
	UserLoginService userLoginService;
	
	@RequestMapping(value = "/createUserLogin", method = RequestMethod.POST)
	public UserLogin createUserLogin(@RequestBody UserLogin model) {
		return userLoginService.createUserLogin(model);
	}
	
	@RequestMapping(value = "/getUserLogin", method = RequestMethod.GET)
	public List<UserLogin> getUserLogin(){
		return userLoginService.getUserLogin();
	}
	
	@RequestMapping(value = "/updateUserLogin/{userId}", method = RequestMethod.PUT)
	public UserLogin updateUserLogin(@PathVariable(value = "userId") Long id, @RequestBody UserLogin model) {
		return userLoginService.updateUserLogin(id, model);
	}
	
	@RequestMapping(value = "/deleteUserLogin/{userId}", method = RequestMethod.DELETE)
	public void deleteUserLogin(@PathVariable(value = "userId") Long id) {
		userLoginService.deleteUserLogin(id);
	}
}
