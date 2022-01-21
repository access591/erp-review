package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.PurchaseOrder;

public interface PurchaseOrderService {
	
	public void addPurchaseOrder(PurchaseOrder purchaseOrder);
	public List<PurchaseOrder> getAllPurchaseOrder();
	public Optional<PurchaseOrder> editPurchaseOrder(String poCode);
	public void deletePurchaseOrder(String poCode);
	
	public void purchaseOrderApproval(String poNumber, String approvalStatus);
	
	public List<PurchaseOrder> getApprovedPurchaseorder(String status);
	
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);
	
	public List<PurchaseOrder> findAllOrderBy();
	
	

}
