package com.marcos.santos.springbootjwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marcos.santos.springbootjwt.UserData;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserDetailsServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserData user = findUser(userName);
		if(user == null) {
			throw new UsernameNotFoundException(userName);
		}
		return null;
	}

	private UserData findUser(String userName) {
		
		UserData user = new UserData();
		user.setUserName("admin");
		user.setPassword(bCryptPasswordEncoder.encode("nida"));
		
		return user;
	}
	
	public java.util.List<UserData> listUsers() {
		ArrayList<UserData> lst = new ArrayList<UserData>();
		lst.add(findUser("admin"));
		return lst;
		
	}
	
	
	
}
