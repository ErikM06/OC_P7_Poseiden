package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.UserDTO;
import com.nnk.springboot.domain.User;

public interface IUserService {
	
	User getUserFromByUsername(String username);
	
	User saveUser(UserDTO userDto);
	
	List<User> findAllUsers();
	
	User findUserById(Integer id);
	
	User updateUser (Integer id, UserDTO userDto);
	
	void deleteUser (Integer id);
}
