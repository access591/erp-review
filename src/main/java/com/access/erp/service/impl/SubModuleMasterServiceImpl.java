package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.SubModuleMaster;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.SubModuleRepo;
import com.access.erp.service.SubModuleMasterService;


@Service
public class SubModuleMasterServiceImpl implements SubModuleMasterService{

	@Autowired SubModuleRepo subModuleRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addSubModule(SubModuleMaster subModuleMaster) {
		
		if(subModuleMaster.getSubModuleCode() =="" || subModuleMaster.getSubModuleCode()==null) {
			System.out.println("if block ");
			String maxCode = seqMainRepo.findByTranType("SMO");
			subModuleMaster.setSubModuleCode(maxCode);
		}
		System.out.println("id is : "+ subModuleMaster.getSubModuleCode());
		subModuleRepo.save(subModuleMaster);
	}


	@Override
	public List<SubModuleMaster> getAllSubModule() {
		
		return subModuleRepo.findAll();
	}

	@Override
	public Optional<SubModuleMaster> editSubModule(String subModuleCode) {
		
		return subModuleRepo.findById(subModuleCode);
	}

	@Override
	public void deleteSubModuleMaster(String subModuleCode) {
		subModuleRepo.deleteById(subModuleCode);
		
	}

}
