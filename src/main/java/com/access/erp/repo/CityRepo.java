package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.master.City;

public interface CityRepo extends JpaRepository<City, String>{

}
