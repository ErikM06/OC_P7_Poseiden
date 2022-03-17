package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.domain.User;

public interface IUserService {
	
	User getUserFromByUsername(String username);
	
	User saveUserWithEncodedPassword(User user);
	
	List<User> findAllUsers();
}
