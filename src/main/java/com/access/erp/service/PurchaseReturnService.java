package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.PurchaseReturn;

public interface PurchaseReturnService {

public void addPurchaseReturn(PurchaseReturn purchaseReturn);
public List<PurchaseReturn>getAllPurchaseReturn();
public Optional<PurchaseReturn>	editPurchaseReturn(String purchasePrNo);
public void deletePurchaseReturn(String purchasePrNo);
	
	
	
}
