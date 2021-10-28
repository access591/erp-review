package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.PurchaseOrder;

public interface PurchaseOrderService {
	
	public void addPurchaseOrder(PurchaseOrder purchaseOrder);
	public List<PurchaseOrder> getAllPurchaseOrder();
	public Optional<PurchaseOrder> editPurchaseOrder(String poCode);
	public void deletePurchaseOrder(String poCode);

}
