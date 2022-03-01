package com.nnk.springboot.interfaces;

import com.nnk.springboot.domain.User;

public interface IUserService {
	
	User getUserFromByUsername(String username);

}
