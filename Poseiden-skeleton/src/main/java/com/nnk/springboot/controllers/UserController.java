package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.DTOs.UserDTO;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.interfaces.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping("/user/list")
	public String home(Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "user/list";
	}

	@GetMapping("/user/add")
	public String addUser(Model model) {
		model.addAttribute("userDto", new UserDTO());
		return "user/add";
	}
	//paul password : BlablaazdadDAD0159()%
	@PostMapping("/user/validate")
	public String validate(@ModelAttribute("userDto") @Valid UserDTO userDto, BindingResult result, Model model) {
		if (!result.hasErrors()) {	
			userDto.setPassword(encoder.encode(userDto.getPassword())); 
			userService.saveUser(userDto);
			return "redirect:/user/list";
		}
		return "user/add";
	}

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("userDto", new UserDTO());
		return "user/update";
	}

	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @ModelAttribute("userDto") @Valid UserDTO userDto,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/update";
		}
		userService.updateUser(id, userDto);
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		try {

			userService.deleteUser(id);
		} catch (IllegalArgumentException e) {
			model.addAttribute("IllegalArgument", "User with id :/s" + id + "/s not found!");
		}
		return "redirect:/user/list";
	}
}
