package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.MaterialRequisitionDetail;

public interface MaterialRequisitionDetailService {
	
	public void addMaterialRequisitionDetail(MaterialRequisitionDetail materialRequisitionDetail);
	public List<MaterialRequisitionDetail> getAllMaterialRequisitionDetail();
	public Optional<MaterialRequisitionDetail> editMaterialRequisitionDetail(String matReqNo);
	public void deleteMaterialRequisitionDetail(String matReqNo);


}
