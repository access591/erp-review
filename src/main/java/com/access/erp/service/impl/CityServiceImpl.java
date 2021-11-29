package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.City;
import com.access.erp.model.master.State;
import com.access.erp.repo.CityRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired SeqMainRepo seqMainRepo;
	@Autowired CityRepo cityRepo;
	
	@Override
	public void addCity(City city) {
		
		
		// TRAN_TYPE=V_PRG_TYPE AND FYCODE =V_FYCODE AND CCODE =V_CCODE
		
		if (city.getCityCode() == "" || city.getCityCode() == null) {
			System.out.println("country code is : "+ city.getCityCode());
			//String maxCode = seqMainRepo.findByTranType("CT");
			
			String maxCode1 = seqMainRepo.findByTranTypeAndFyCodeAndCCode("CT", "20-21", "EB");
			city.setCityCode(maxCode1);
		}

		cityRepo.save(city);
		
	}

	@Override
	public List<City> getAllCity() {
		
		return cityRepo.findAll();
	}

	@Override
	public Optional<City> editCity(String cityCode) {
		
		return cityRepo.findById(cityCode);
	}

	@Override
	public void deleteCity(String cityCode) {
		
		cityRepo.deleteById(cityCode);
	}

	@Override
	public List<City> findByState(State state) {
		
		return cityRepo.findByState(state);
	}

}
