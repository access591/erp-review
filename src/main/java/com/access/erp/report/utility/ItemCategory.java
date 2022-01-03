package com.access.erp.report.utility;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.master.Category;
import com.access.erp.model.master.Item;

public class ItemCategory {

	private Item item;
	private Category category;
	private ItemOpening itemOpening;

	public ItemOpening getItemOpening() {
		return itemOpening;
	}

	public void setItemOpening(ItemOpening itemOpening) {
		this.itemOpening = itemOpening;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
