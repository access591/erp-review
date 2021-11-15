package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.access.erp.model.ItemOpening;
import com.access.erp.repo.ItemOpeningRepo;
import com.access.erp.service.ItemOpeningService;

@Repository
public class ItemOpeningServiceImpl implements ItemOpeningService{

	@Autowired ItemOpeningRepo itemOpeningRepo;
	
	@Override
	public void addItemOpening(ItemOpening itemOpening) {
		
		itemOpeningRepo.save(itemOpening);
		
	}

	@Override
	public List<ItemOpening> getAllItemOpening() {
		
		return itemOpeningRepo.findAll();
	}

	@Override
	public Optional<ItemOpening> editItemOpening(String itemOpeningCode) {
		
		return itemOpeningRepo.findById(itemOpeningCode);
	}

	@Override
	public void deleteItemOpening(String itemOpeningCode) {
		
		itemOpeningRepo.deleteById(itemOpeningCode);
		
	}

	
}
