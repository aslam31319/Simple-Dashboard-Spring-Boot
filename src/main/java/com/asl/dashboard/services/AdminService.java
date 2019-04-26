package com.asl.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asl.dashboard.model.UserDTO;
import com.asl.dashboard.repository.UserRepository;


@Service
public class AdminService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passEncoder;
	
	public void register(UserDTO dto) {
		dto.setPassword(passEncoder.encode(dto.getPassword()));
		dto.setRole("ROLE_ADMIN");
		userRepository.save(dto);

	}

}
