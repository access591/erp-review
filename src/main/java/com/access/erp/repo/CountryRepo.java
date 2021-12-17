package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.master.Country;

public interface CountryRepo extends JpaRepository<Country, String>{
	
	List<Country> findByActive(String active);

}
