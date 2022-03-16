package com.nnk.springboot.services;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.interfaces.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	/*
	 * problemes de comprehension, le private final empêche le changement de la
	 * methode pour pouvoir respecter l'accessibilité de la class?
	 */
	@Autowired
	private final IUserService userService;

	private UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userService.getUserFromByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username + "/s not found");
		}
		logger.info("loading User by username: {} ", username.toString(), user.getPassword().toString());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}

}
