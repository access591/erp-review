package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.MaterialRequisitionDetail;
import com.access.erp.model.MaterialRequisitionMaster;
import com.access.erp.repo.MaterialRequisitionMasterRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.MaterialRequisitionMasterService;

@Service
public class MaterialRequisitionMasterServiceImpl implements MaterialRequisitionMasterService{

	@Autowired MaterialRequisitionMasterRepo materialRequisitionMasterRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addMaterialRequisitionMaster(MaterialRequisitionMaster materialRequisitionMaster) {
		
		//category.getCategCode() == "" || category.getCategCode() == null
		
		if(materialRequisitionMaster.getRequisitionNo() == "" || materialRequisitionMaster.getRequisitionNo() == null) {
			
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("REQ", "20-21", "EB");
			materialRequisitionMaster.setRequisitionNo("EB-"+maxCode);
			
			
		}
		
		for(MaterialRequisitionDetail detail : materialRequisitionMaster.getMaterialRequisitionDetails()) {
			
			detail.setMaterialRequisitionMaster(materialRequisitionMaster);
		}
		
		
		materialRequisitionMasterRepo.save(materialRequisitionMaster);
		
	}

	@Override
	public List<MaterialRequisitionMaster> getAllMaterialRequisitionMaster() {
		
		return materialRequisitionMasterRepo.findAll();
	}

	@Override
	public Optional<MaterialRequisitionMaster> editMaterialRequisitionMaster(String matReqNo) {
		
		return materialRequisitionMasterRepo.findById(matReqNo);
	}

	@Override
	public void deleteMaterialRequisitionMaster(String matReqNo) {
		
		materialRequisitionMasterRepo.deleteById(matReqNo);
		
	}

}
