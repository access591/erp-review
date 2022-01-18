package com.access.erp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
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
		
		System.out.println("purchase order service impl : " + purchaseOrder.getPoNumber());
		if (purchaseOrder.getPoNumber().isEmpty() || purchaseOrder.getPoNumber() == "" || purchaseOrder.getPoNumber() == null) {
			System.out.println("po code is : "+ purchaseOrder.getPoNumber() );
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("PUR", "20-21", "EB");
			purchaseOrder.setPoNumber("EB"+maxCode);
		}
		
		for(PurchaseOrderItem orderItem : purchaseOrder.getListPurchaseOrderItem()) {
			
			
			//orderItem.setSgstValue(orderItem.getSgstValue());
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

	@Override
	public void purchaseOrderApproval(String poNumber, String approvalStatus) {
		
		PurchaseOrder purchaseOrder = editPurchaseOrder(poNumber).get();
		
		if(approvalStatus.equals("Y")) {
			System.out.println("approval status is : Y");
			purchaseOrder.setApprovalDate(new Date());
		}
		else if(approvalStatus.equals("N")) {
			System.out.println("approval status is : N");
			purchaseOrder.setCancelDate(new Date());
		}
	
		
		purchaseOrder.setApprovalStatus(approvalStatus);
		
		
		addPurchaseOrder(purchaseOrder); 
		
	}

	@Override
	public List<PurchaseOrder> getApprovedPurchaseorder() {
		
		String approvalStatus = "Y";
		
		
		return purchaseOrderRepo.findByApprovalStatus("Y");
	}

}
