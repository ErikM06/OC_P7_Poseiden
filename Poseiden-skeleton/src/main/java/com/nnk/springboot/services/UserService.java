package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.UserDTO;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.interfaces.IUserService;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.util.UserMapper;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserMapper mapper;
	
	@Override
	public User getUserFromByUsername(String username)  {
		return userRepo.findByUsername(username);
	}

	@Override
	public User saveUser(UserDTO userDto) {
		User user = mapper.mapToUser(userDto);
		// encoder.encode(userToSave.getPassword());
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.getById(id);
	}

	@Override
	public User updateUser(Integer id, UserDTO userDto) {
		User user = userRepo.getById(id);
		mapper.updateUserWithUserDto(userDto, user);
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}
	
	
	
	

}
