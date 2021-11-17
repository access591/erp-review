package com.access.erp.utility;

import java.util.List;

import com.access.erp.model.GateEntry;
import com.access.erp.model.master.Item;

public class MrnUtility {
	
	private GateEntry gateEntry;
	private List<Item> itemList;
	
	
	public GateEntry getGateEntry() {
		return gateEntry;
	}
	public void setGateEntry(GateEntry gateEntry) {
		this.gateEntry = gateEntry;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	

}
