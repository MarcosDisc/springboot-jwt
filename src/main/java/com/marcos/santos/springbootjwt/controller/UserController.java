 package com.marcos.santos.springbootjwt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.santos.springbootjwt.UserData;
import com.marcos.santos.springbootjwt.service.UserDetailsServiceImpl;

@RestController
public class UserController {

	
	private final UserDetailsServiceImpl userDetailsService;
	
	public UserController(UserDetailsServiceImpl userDetailsService) {
		//super();
		this.userDetailsService = userDetailsService;
	}




	@RequestMapping("/all-users")
	public List<UserData> listAllUsers() {
		
		return userDetailsService.listUsers();
		
	}
	
	
}
