package com.asl.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asl.dashboard.model.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, String> {
	

}
