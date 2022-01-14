package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Store;

public interface StoreService {

	public void addStore(Store store);
	public List<Store> getAllStore();
	public Optional<Store> editStore(String storeCode);
	public void deleteStore(String storeCode);
	
	public List<Store> findByActive();
	
}
