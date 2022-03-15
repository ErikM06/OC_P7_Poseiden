package com.nnk.springboot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.interfaces.IUserService;

 @Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	

	/*
	 * problemes de comprehension, le private final empêche le changement de la methode
	 * pour pouvoir respecter l'accessibilité de la class?
	 */
	private final IUserService userService;

	
	@Autowired
	private UserDetailsServiceImpl (UserService userService) {
		this.userService = userService;
	}
	
	Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserFromByUsername(username);
		logger.info("loading User by username: {} ", username.toString());
		if (user == null) {
			throw new UsernameNotFoundException(username +"/s not found");
		}
		return user;
	} 

}
