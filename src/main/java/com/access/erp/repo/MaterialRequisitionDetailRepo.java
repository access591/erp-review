package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.MaterialRequisitionDetail;
import com.access.erp.model.MaterialRequisitionMaster;
import com.access.erp.model.master.Item;

@Repository
public interface MaterialRequisitionDetailRepo extends JpaRepository<MaterialRequisitionDetail, String>{
	
	public MaterialRequisitionDetail findByItemAndMaterialRequisitionMaster(Item item,MaterialRequisitionMaster requisitionMaster);

}
