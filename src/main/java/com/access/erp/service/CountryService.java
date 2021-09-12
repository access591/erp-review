package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Country;

public interface CountryService {
	
	public void addCountry(Country country);
	public List<Country> getAllCountry();
	public Optional<Country> editCountry(String countryCode);
	public void deleteCountry(String countryCode);

}
