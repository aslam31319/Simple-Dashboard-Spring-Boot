package com.asl.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asl.dashboard.model.UserDTO;
import com.asl.dashboard.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passEncoder;

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
		user.setUserId(Math.round((Math.random()*999)));
		userRepository.save(user);

	}

}
