package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.interfaces.IUserService;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User getUserFromByUsername(String username)  {
		return userRepo.findByUsername(username);
	}

	@Override
	public User saveUserWithEncodedPassword(User user) {
		User userToSave = user;
		encoder.encode(userToSave.getPassword());
		return userRepo.save(userToSave);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	

}
