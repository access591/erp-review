package com.access.erp.service;

import java.util.List;
import java.util.Optional;


import com.access.erp.model.master.Item;

public interface ItemService {
	
	public void addItem(Item item);
	public List<Item> getAllItem();
	public Optional<Item> editItem(String itemCode);
	public void deleteItem(String itemCode);

}
