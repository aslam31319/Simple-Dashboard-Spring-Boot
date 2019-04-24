package com.asl.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asl.dashboard.model.PlaceDTO;
import com.asl.dashboard.repository.PlaceRepository;

@Service
public class PlaceService {

	
	
	@Autowired
	private PlaceRepository placeRepository;

	public boolean isAddPlace(PlaceDTO dto) {
		placeRepository.save(dto);
		return true;
	}

	public boolean isAddListPlace(List<PlaceDTO> dto) {
		dto.forEach(placeRepository::save);
		return true;
	}

	public List<String> getCountry() {
		
		return placeRepository.find();
	}

	public List<String> getState(String country) {

		return placeRepository.findState(country);
	}
	
	public List<String> getCity(String state) {
		return placeRepository.findCity(state);
	}

	public List<PlaceDTO> getAllPlace() {
		return placeRepository.findAll();
	}
}
