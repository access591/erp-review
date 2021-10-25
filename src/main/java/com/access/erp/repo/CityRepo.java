package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.master.City;
import com.access.erp.model.master.State;

public interface CityRepo extends JpaRepository<City, String>{
	
	public List<City> findByState(State state);

}
