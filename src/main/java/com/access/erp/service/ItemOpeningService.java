package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.ItemOpening;

public interface ItemOpeningService {
	
	public void addItemOpening(ItemOpening itemOpening);
	public List<ItemOpening> getAllItemOpening();
	public Optional<ItemOpening> editItemOpening(String itemOpeningCode);
	public void deleteItemOpening(String itemOpeningCode);

}
