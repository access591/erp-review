package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.SubModuleMaster;

public interface SubModuleMasterService {
	
	public void addSubModule(SubModuleMaster subModule);
	public List<SubModuleMaster> getAllSubModule();
	public Optional<SubModuleMaster> editSubModule(String subModuleCode);
	public void deleteSubModuleMaster(String subModuleCode);

}
