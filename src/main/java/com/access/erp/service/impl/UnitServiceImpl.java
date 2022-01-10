package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Unit;
import com.access.erp.repo.UnitRepo;
import com.access.erp.service.UnitService;


@Service
public class UnitServiceImpl implements UnitService{

	
	@Autowired UnitRepo unitRepo;
	
	
	
	
	
	
	@Override
	public void addUnit(Unit unit) {
		unitRepo.save(unit);
		
	}

	@Override
	public List<Unit> getAllUnit() {
		
		return this.unitRepo.findAll();
	}

	@Override
	public Optional<Unit> editUnit(String UnitCode) {
		
		return this.unitRepo.findById(UnitCode);
	}

	@Override
	public void deleteUnit(String unitCode) {
		this.unitRepo.deleteById(unitCode);
		
	}

}
