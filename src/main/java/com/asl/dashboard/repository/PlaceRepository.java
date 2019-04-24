package com.asl.dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asl.dashboard.model.PlaceDTO;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceDTO, Integer> {

	@Query("select distinct P.country from PlaceDTO P")
	public List<String> find();

	@Query("select distinct P.state from PlaceDTO P where P.country= :country")
	public List<String> findState(@Param("country") String country);

	@Query("select distinct P.city from PlaceDTO P where P.state= :state")
	public List<String> findCity(@Param("state") String state);
}
