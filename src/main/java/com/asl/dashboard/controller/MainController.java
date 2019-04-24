package com.asl.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
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

}
