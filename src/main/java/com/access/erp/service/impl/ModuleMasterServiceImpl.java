package com.access.erp.service.impl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.repo.ModuleMasterRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.ModuleMasterService;


@Service
public class ModuleMasterServiceImpl implements ModuleMasterService{

	@Autowired ModuleMasterRepo moduleMasterRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	
	
	@Override
	public void addModule(ModuleMaster moduleMaster) {
		
		System.out.println("actve status : "+ moduleMaster.getModuleCode());
		
		if(moduleMaster.getModuleCode()=="" || moduleMaster.getModuleCode()==null) {
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("MOD", "20-21", "EB");
			moduleMaster.setModuleCode(maxCode);
			
			
		}
		
		moduleMasterRepo.save(moduleMaster);
	}

	@Override
	public List<ModuleMaster> getAllModule() {
		
		return moduleMasterRepo.findAll();
	}

	@Override
	public Optional<ModuleMaster> editModule(String moduleCode) {
		
		return moduleMasterRepo.findById(moduleCode);
	}

	@Override
	public void deleteModuleMaster(String moduleCode) {
		moduleMasterRepo.deleteById(moduleCode);;
	}

}
