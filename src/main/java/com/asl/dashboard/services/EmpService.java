package com.asl.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asl.dashboard.model.EmpDTO;
import com.asl.dashboard.repository.EmployeRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmployeRepository empRepository;
	
	public List<EmpDTO> getAllEmp() {
		return empRepository.findAll();
	}

}
