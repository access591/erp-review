package com.access.erp.utility;

import com.access.erp.model.OpenIndentDetail;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.UOM;

public class ItemUom {
	
	private Item item;
	private UOM uom;
	private OpenIndentDetail openIndentDetail;
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public UOM getUom() {
		return uom;
	}
	public void setUom(UOM uom) {
		this.uom = uom;
	}
	public OpenIndentDetail getOpenIndentDetail() {
		return openIndentDetail;
	}
	public void setOpenIndentDetail(OpenIndentDetail openIndentDetail) {
		this.openIndentDetail = openIndentDetail;
	}
	
	

}
