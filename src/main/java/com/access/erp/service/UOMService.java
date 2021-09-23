package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.UOM;

public interface UOMService {
	
	public void addUOM(UOM uom);
	public List<UOM> getAllUOM();
	public Optional<UOM> editUOM(String uomCode);
	public void deleteUOM(String uomCode);

}
