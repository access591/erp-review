package com.access.erp.utility;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.MaterialRequisitionDetail;

public class RequisitionDetailItemOpening {

	private MaterialRequisitionDetail materialRequisitionDetail;
	private ItemOpening itemOpening;
	
	public MaterialRequisitionDetail getMaterialRequisitionDetail() {
		return materialRequisitionDetail;
	}
	public void setMaterialRequisitionDetail(MaterialRequisitionDetail materialRequisitionDetail) {
		this.materialRequisitionDetail = materialRequisitionDetail;
	}
	public ItemOpening getItemOpening() {
		return itemOpening;
	}
	public void setItemOpening(ItemOpening itemOpening) {
		this.itemOpening = itemOpening;
	}
	
	
}
