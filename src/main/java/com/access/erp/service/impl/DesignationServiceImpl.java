package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Designation;
import com.access.erp.repo.DesignationRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.DesignationService;


@Service
public class DesignationServiceImpl implements DesignationService{

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired DesignationRepo designationRepo;
	
	@Override
	public void addDesignation(Designation designation) {
		
		if (designation.getDesigCode() == "" || designation.getDesigCode() == null) {
			System.out.println("country code is : "+ designation.getDesigCode());
			String maxCode = seqMainRepo.findByTranType("DES");
			designation.setDesigCode(maxCode);
		}

		designationRepo.save(designation);
		
	}

	@Override
	public List<Designation> getAllDesignation() {
		
		return designationRepo.findAll();
	}

	@Override
	public Optional<Designation> editDesignation(String desigCode) {
		
		return designationRepo.findById(desigCode);
	}

	@Override
	public void deleteDesignation(String disigCode) {

		designationRepo.deleteById(disigCode);
		
	}

}
