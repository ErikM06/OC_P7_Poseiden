package com.nnk.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.interfaces.IUserService;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User getUserFromByUsername(String username)  {
		return userRepo.findByUsername(username);
	}

}
