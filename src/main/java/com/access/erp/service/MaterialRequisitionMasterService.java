package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.MaterialRequisitionMaster;

public interface MaterialRequisitionMasterService {
	
	public void addMaterialRequisitionMaster(MaterialRequisitionMaster materialRequisitionMaster);
	public List<MaterialRequisitionMaster> getAllMaterialRequisitionMaster();
	public Optional<MaterialRequisitionMaster> editMaterialRequisitionMaster(String matReqNo);
	public void deleteMaterialRequisitionMaster(String matReqNo);

	public void materialRequisitionApproval(String reqNum,String approvalStatus);
}
