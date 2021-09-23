package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.UOM;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.UomRepo;
import com.access.erp.service.UOMService;


@Service
public class UOMServiceImpl implements UOMService{

	@Autowired UomRepo uomRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addUOM(UOM uom) {
		
		if (uom.getUomCode() == "" || uom.getUomCode() == null) {
			System.out.println("uom code is : "+ uom.getUomCode());
			String maxCode = seqMainRepo.findByTranType("UOM");
			uom.setUomCode(maxCode);
		}

		uomRepo.save(uom);
	}

	@Override
	public List<UOM> getAllUOM() {
		
		return uomRepo.findAll();
	}

	@Override
	public Optional<UOM> editUOM(String uomCode) {
		
		return uomRepo.findById(uomCode);
	}

	@Override
	public void deleteUOM(String uomCode) {
		uomRepo.deleteById(uomCode);
		
	}

}
