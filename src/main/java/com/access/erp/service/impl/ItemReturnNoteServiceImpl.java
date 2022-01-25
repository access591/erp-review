package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.ItemReturnNote;
import com.access.erp.model.master.ItemReturnNoteDetail;
import com.access.erp.repo.ItemReturnNoteRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.ItemReturnNoteService;

@Service
public class ItemReturnNoteServiceImpl implements ItemReturnNoteService {

	
	@Autowired SeqMainRepo seqMainRepo;
	@Autowired ItemReturnNoteRepo itemReturnNoteRepo;
	
	
	
	
	
	@Override
	public void addItemReturnNote(ItemReturnNote itemreturnNote) {
		if(itemreturnNote.getReceiptNo() == "" | itemreturnNote.getReceiptNo() == null) {
			
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("RNO", "20-21", "EB");
			System.out.println("max code is : " + maxCode);

			itemreturnNote.setReceiptNo(maxCode);
			
		}
		
		 for(ItemReturnNoteDetail detail : itemreturnNote.getListItemReturnNoteDetail() ) {
		  detail.setItemReturnNote(itemreturnNote);
		 
		}
		itemReturnNoteRepo.save(itemreturnNote);
	}

	@Override
	public List<ItemReturnNote> getAllItemReturnNote() {
		System.out.println("retur note service ");
		
		List<ItemReturnNote> itemReturnNote = null;
		
		try {
			 itemReturnNote = itemReturnNoteRepo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemReturnNote;
	}

	@Override
	public Optional<ItemReturnNote> editItemReturnNote(String receiptNo) {
		// TODO Auto-generated method stub
		return itemReturnNoteRepo.findById(receiptNo);
	}

	@Override
	public void deleteItemReturnNote(String receiptNo) {
		itemReturnNoteRepo.deleteById(receiptNo);
	}

}
