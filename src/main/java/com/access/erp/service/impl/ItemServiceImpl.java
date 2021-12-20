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
		
		String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("ITM", "20-21", "EB");
		 
		if (item.getItemCode() == "" || item.getItemCode()== null) {
			
			  System.out.println("item code is : "+ item.getItemCode()); 
			 
			  System.out.println("item max code is : " + maxCode);
			  
			  System.out.println("category code is : " +  item.getCategory().getCategCode() );
			 
			  System.out.println("generate item code : " + "EB" + item.getCategory().getCategCode().substring(3) + maxCode.substring(3));
			
			item.setItemCode("EB" + item.getCategory().getCategCode().substring(3) + maxCode.substring(3));
			
			
		}

		if(item.getPackingDetails().get(0).getPackingName()!=null) {
			
			
			System.out.println("item packing size is more then zero ");
			
			for(PackingDetail p : item.getPackingDetails()) {
				
				System.out.println(" in packing detail loop ");
				if(p.getPackingCode() == "" || p.getPackingCode() == null) {
					
					System.out.println("in packing loop if block ");
					String maxCode1 = seqMainRepo.findByTranTypeAndFyCodeAndCCode("PAC", "20-21", "EB");
					System.out.println("max code 1 is : " + maxCode1);
					
					p.setPackingCode(maxCode);
					
				}
				
			//	item.getPackingDetails().add(p);
				p.setItem(item);
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
