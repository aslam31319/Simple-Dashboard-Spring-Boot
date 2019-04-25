package com.asl.dashboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asl.dashboard.model.MailDTO;
import com.asl.dashboard.model.UserDTO;
import com.asl.dashboard.services.FileService;
import com.asl.dashboard.services.MailService;
import com.asl.dashboard.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/user")
	public String user(Model model) {
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("email",email);
		return "home";
	}

	@RequestMapping("/login")
	public String loginForm() {
		return "login";
	}
	@GetMapping("/login-error")
	public String loginError(Model model) {
		
		model.addAttribute("result","Invalid user details");
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
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("email") String email,
			@RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword) {
		
		userService.changePassword(email, currentPassword, newPassword);
		return "login";
	}
	
	
	@GetMapping("/changePassword")
	public String changePwdForm() {
		return "changePassword";
	}
	
	
	// forgot password
	@PostMapping("forgot")
	public String forgotPassword(@RequestParam("recemail") String email, Model model) {

		if (userService.forgotPass(email)) {
			model.addAttribute("result", "Please check your Email for details");
			return "login";
		} else {

			model.addAttribute("result", "No user found");
			return "register";
		}

	}
	
	@GetMapping("download")
	public void generate(HttpServletRequest req, HttpServletResponse resp, @RequestParam("fileEXT") String fileEXT) {

		fileService.download(req, resp,fileEXT);

	}
	
	@PostMapping("sendEmailWithFile")
	public @ResponseBody String sentEmailWithFile(HttpServletRequest req, @ModelAttribute MailDTO mail) {
		
		mail.setMailTo(SecurityContextHolder.getContext().getAuthentication().getName());
		System.err.println(mail.getMailTo());
		System.err.println(mail.getFileEXT());
		mail.setSubject("Attachment");
		mail.setBody("This is your attachment");

		mailService.sendMimeMail(mail, req);
		return "mailsent";
	}

}
