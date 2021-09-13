package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.City;

public interface CityService{

	
	public void addCity(City city);
	public List<City> getAllCity();
	public Optional<City> editCity(String cityCode);
	public void deleteCity(String cityCode);
	
}
