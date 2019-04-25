package com.asl.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asl.dashboard.model.UserDTO;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDTO, String> {
	
	
	
	@Modifying
	@Query("update UserDTO u set u.password=:password where u.email=:email")
	public int updatePassword(@Param("email") String email,@Param("password") String password);
	
}
