package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Unit;

public interface UnitService {

	public void addUnit(Unit unit);
     public List<Unit>getAllUnit();
	public Optional<Unit>editUnit(String UnitCode);
	public void deleteUnit(String unitCode);
	
}
