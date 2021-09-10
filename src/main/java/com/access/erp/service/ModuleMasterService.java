package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.ModuleMaster;

public interface ModuleMasterService {
	
	public void addModule(ModuleMaster moduleMaster);
	public List<ModuleMaster> getAllModule();
	public Optional<ModuleMaster> editModule(String moduleCode);
	public void deleteModuleMaster(String moduleCode);

}
