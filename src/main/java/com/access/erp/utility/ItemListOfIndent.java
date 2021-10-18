package com.access.erp.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.access.erp.model.master.Item;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemListOfIndent {
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date indentDate;
	private List<Item> listItem = new ArrayList<>();
	
	
	public Date getIndentDate() {
		return indentDate;
	}
	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}
	public List<Item> getListItem() {
		return listItem;
	}
	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}
	
	
	

}
