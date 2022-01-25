package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.ItemReturnNote;

public interface ItemReturnNoteService {

	public void addItemReturnNote(ItemReturnNote itemreturnNote);
	public List<ItemReturnNote>getAllItemReturnNote();
	public Optional<ItemReturnNote> editItemReturnNote(String receiptNo);
	public void deleteItemReturnNote(String receiptNo);
	
	
	
	
	
	
	
	
	
	
}
