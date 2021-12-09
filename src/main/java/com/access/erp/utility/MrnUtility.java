package com.access.erp.utility;

import java.util.List;

import com.access.erp.model.GateEntry;
import com.access.erp.model.master.Item;

public class MrnUtility {
	
	private GateEntry gateEntry;
	private List<Item> itemList;
	
	// from po 
	private String poGst;
	private String currency;
	private String conversionValue;
	
	
	
	
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
	public String getPoGst() {
		return poGst;
	}
	public void setPoGst(String poGst) {
		this.poGst = poGst;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(String conversionValue) {
		this.conversionValue = conversionValue;
	}
	
	
	
	
	

}
