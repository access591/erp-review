package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Country;
import com.access.erp.repo.CountryRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	CountryRepo countryRepo;

	@Override
	public void addCountry(Country country) {

		if (country.getCountryCode() == "" || country.getCountryCode() == null) {
			System.out.println("country code is : "+ country.getCountryCode());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("CON", "20-21", "EB");
			country.setCountryCode(maxCode);
		}

		countryRepo.save(country);

	}

	@Override
	public List<Country> getAllCountry() {

		return countryRepo.findAll();
	}

	@Override
	public Optional<Country> editCountry(String countryCode) {

		return countryRepo.findById(countryCode);
	}

	@Override
	public void deleteCountry(String countryCode) {

		countryRepo.deleteById(countryCode);
	}

}
