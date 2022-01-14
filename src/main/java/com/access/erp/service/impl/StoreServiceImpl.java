package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Store;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.StoreRepo;
import com.access.erp.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	
	@Autowired StoreRepo storeRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	
	@Override
	public void addStore(Store store) {
		if (store.getStoreCode() == "" || store.getStoreCode() == null) {
			System.out.println("country code is : "+ store.getStoreCode());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("STR", "20-21", "EB");
			store.setStoreCode(maxCode);
		}

		storeRepo.save(store);
		
	}

	@Override
	public List<Store> getAllStore() {
		
		return storeRepo.findAll();
	}

	@Override
	public Optional<Store> editStore(String storeCode) {
		
		return storeRepo.findById(storeCode);
	}

	@Override
	public void deleteStore(String storeCode) {
		storeRepo.deleteById(storeCode);		
	}

	@Override
	public List<Store> findByActive() {
		// TODO Auto-generated method stub
		return this.storeRepo.findByActive("Y");
	}

}
