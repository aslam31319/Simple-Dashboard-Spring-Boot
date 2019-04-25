package com.asl.dashboard.services;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asl.dashboard.model.MailDTO;
import com.asl.dashboard.model.UserDTO;
import com.asl.dashboard.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passEncoder;

	@Autowired
	private MailService mailService;

	@Autowired
	private MailDTO mail;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDTO user = userRepository.getOne(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid Email id");
		}
		UserDetails userDetails = User.withUsername(user.getEmail()).password(user.getPassword())
				.roles(user.getRole().substring(5)).build();
		return userDetails;
	}

	public void register(UserDTO user) {
		user.setPassword(passEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		user.setUserId(Math.round((Math.random() * 999)));
		userRepository.save(user);

	}

	public boolean forgotPass(String email) {

		String token = UUID.randomUUID().toString();
		token = token.substring(0, 7);

		if (userRepository.getOne(email) == null) {
			return false;
		} else {
			String password = passEncoder.encode(token);

			userRepository.updatePassword(email, password);

			mail.setMailTo(email);
			mail.setSubject("No Reply");
			mail.setBody(
					"This is a System generated message Please do not try to reply for this mail. "
					+ "\n This message is contains confidential information like password "
					+ "please do not share it whith any one.\n Your Email id is: "+ email 
					+ " \n\n Your Password is :" + token
					);
			
			Thread t1=new Thread(() -> mailService.sendSimpleMail(mail));
			t1.start(); 
			
			
			logger.warn((t1.getState()).toString());

			return true;
		}
	}

	public boolean changePassword(String email, String currentPassword, String newPassword) {

		UserDTO dto = userRepository.getOne(email);

		if (passEncoder.matches(currentPassword, dto.getPassword())) {

			userRepository.updatePassword(email, passEncoder.encode(newPassword));
			return true;

		} else {

			return false;
		}
	}

}
