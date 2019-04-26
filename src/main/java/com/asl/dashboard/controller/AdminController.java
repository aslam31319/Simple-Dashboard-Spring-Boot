package com.asl.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asl.dashboard.model.UserDTO;
import com.asl.dashboard.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public String home() {
		return "admin/home";
	}
	@GetMapping("/addAdmin")
	public String addAdmiFormn() {
		return "admin/addAdmin";
	}
	@PostMapping("/addAdmin")
	public String addAdmin(@ModelAttribute UserDTO dto ,Model model) {
		
		model.addAttribute("result","Admin Added");
		adminService.register(dto);
		return "admin/home";
	}
}
