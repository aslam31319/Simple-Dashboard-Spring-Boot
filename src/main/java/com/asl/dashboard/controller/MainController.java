package com.asl.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asl.dashboard.model.UserDTO;
import com.asl.dashboard.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/user")
	public String user() {
		return "home";
	}

	@RequestMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String registerForm() {
		return "register";
	}
	
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserDTO user) {
		userService.register(user);
		return "login";
	}
	
	

}
