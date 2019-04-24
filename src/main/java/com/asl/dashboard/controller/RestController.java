package com.asl.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asl.dashboard.model.EmpDTO;
import com.asl.dashboard.model.PlaceDTO;
import com.asl.dashboard.services.EmpService;
import com.asl.dashboard.services.PlaceService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api")
public class RestController {

	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private EmpService empService;

	// Feching all data
	@GetMapping("/place/all")
	public List<PlaceDTO> getAllPlace() {

		return placeService.getAllPlace();
	}

	// Get Rest for getting all country
	@GetMapping("/place")
	public List<String> getCountry() {

		return placeService.getCountry();
	}

	// Get Rest for getting State for provided Country
	@GetMapping("/place/{country}")
	public List<String> getState(@PathVariable(value = "country") String country) {

		return placeService.getState(country);
	}

	// Get Rest for getting City for provided State
	@GetMapping("/place/{country}/{state}")
	public List<String> getCity(@PathVariable(value = "country") String country,
			@PathVariable(value = "state") String state) {

		return placeService.getCity(state);
	}

	// Adding Place information to DB

	// Post Rest for adding single place
	@PostMapping(path = "/place/add/{country}", consumes = "application/json")
	public String addPlace(@RequestBody PlaceDTO dto, @PathVariable String country) {

		if (placeService.isAddPlace(dto)) {
			return "Added New Place";
		} else {
			System.out.println("faild");
			return "Faild to Add";
		}

	}

	// Post Rest for adding list of place
	@PostMapping(path = "/place/add", consumes = "application/json")
	public String addListpalce(@RequestBody List<PlaceDTO> dto) {

		if (placeService.isAddListPlace(dto)) {
			return "Added New List of Place";
		} else {
			System.out.println("faild");
			return "Faild to Add";
		}

	}
	
	@GetMapping("getAllEmploy")
	public List<EmpDTO> getAllEmp() {
		return empService.getAllEmp();
	}
}
