package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.master.Country;
import com.access.erp.model.master.State;

public interface StateRepo extends JpaRepository<State, String>{
	
	List<State> findByCountry(Country country);

}
