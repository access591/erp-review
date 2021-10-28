package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.PurchaseOrder;
import com.access.erp.model.PurchaseOrderItem;
import com.access.erp.repo.PurchaseOrderRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{

	@Autowired PurchaseOrderRepo purchaseOrderRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		
		if (purchaseOrder.getPoNumber() == "" || purchaseOrder.getPoNumber() == null) {
			System.out.println("po code is : "+ purchaseOrder.getPoNumber() );
			String maxCode = seqMainRepo.findByTranType("CAT");
			purchaseOrder.setPoNumber(maxCode);
		}
		
		for(PurchaseOrderItem orderItem : purchaseOrder.getListPurchaseOrderItem()) {
			
			orderItem.setPurchaseOrder(purchaseOrder);
		}
		
		purchaseOrderRepo.save(purchaseOrder);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {
		
		return purchaseOrderRepo.findAll();
	}

	@Override
	public Optional<PurchaseOrder> editPurchaseOrder(String poCode) {
		
		return purchaseOrderRepo.findById(poCode);
	}

	@Override
	public void deletePurchaseOrder(String poCode) {
		purchaseOrderRepo.deleteById(poCode);
		
	}

}
