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
	@Autowired SeqMainRepo seqMainRepo1;
	
	@Override
	public void addItem(Item item) {
		
		 String maxCode = seqMainRepo.findByTranType("ITM");
		 
		if (item.getItemCode() == "" || item.getItemCode()== null) {
			
			  System.out.println("item code is : "+ item.getItemCode()); 
			 
			  System.out.println("item max code is : " + maxCode);
			 
			
			
			item.setItemCode("EB"+item.getCategory().getCategCode()+maxCode.substring(2));
			
			
		}

		for(PackingDetail p : item.getPackingDetails()) {
			
			if(p.getPackingCode() == "" || p.getPackingCode() == null) {
				
				String maxCode1 = seqMainRepo.findByTranType("PAC");
				System.out.println("max code 1 is : " + maxCode1);
				
				p.setPackingCode(maxCode);
				
			}
			
			//item.getPackingDetails().add(p);
			p.setItem(item);
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
