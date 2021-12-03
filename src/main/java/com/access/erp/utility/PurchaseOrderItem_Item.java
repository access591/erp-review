package com.access.erp.utility;

import com.access.erp.model.PurchaseOrderItem;
import com.access.erp.model.master.Item;

public class PurchaseOrderItem_Item {
	
	private PurchaseOrderItem purchaseOrderItem;
	private Item item;
	
	public PurchaseOrderItem getPurchaseOrderItem() {
		return purchaseOrderItem;
	}
	public void setPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
