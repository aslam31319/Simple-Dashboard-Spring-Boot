package com.asl.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asl.dashboard.model.EmpDTO;

@Repository
public interface EmployeRepository extends JpaRepository<EmpDTO, Integer> {

}
