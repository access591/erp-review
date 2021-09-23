package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Item;
import com.access.erp.model.master.PackingDetail;
import com.access.erp.repo.ItemRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired ItemRepo itemRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addItem(Item item) {
		
		if (item.getItemCode() == "" || item.getItemCode()== null) {
			System.out.println("item code is : "+ item.getItemCode());
			String maxCode = seqMainRepo.findByTranType("ITM");
			item.setItemCode(maxCode);
			
			for(PackingDetail p : item.getPackingDetails()) {
				
				String maxCode1 = seqMainRepo.findByTranType("PAK");
				p.setPackingCode(maxCode1);
				//item.getPackingDetails().add(p);
			}
		}

		
		
		itemRepo.save(item);
		
	}

	@Override
	public List<Item> getAllItem() {
		
		return itemRepo.findAll();
	}

	@Override
	public Optional<Item> editItem(String itemCode) {
		
		return itemRepo.findById(itemCode);
	}

	@Override
	public void deleteItem(String itemCode) {
		itemRepo.deleteById(itemCode);
		
	}

}
