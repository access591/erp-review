package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="M_PACKING_DETAIL")
public class PackingDetail {
	
	@Id
	@Column(name="PACKING_CODE",length = 50)
	private String packingCode;
	
	@Column(name="PACKING_NAME",length = 50)
	private String packingName;
	
	@Column(name="UNIT_NAME",length = 50)
	private String unitName;
	
	@Column(name="QUANTITY",length = 50)
	private String qty;
	
	@Column(name="BARCODE",length = 500)
	private String barCode;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ITEM_CODE")
	private Item item;

	public PackingDetail() {
		super();
		
	}

	public String getPackingCode() {
		return packingCode;
	}

	public void setPackingCode(String packingCode) {
		this.packingCode = packingCode;
	}

	public String getPackingName() {
		return packingName;
	}

	public void setPackingName(String packingName) {
		this.packingName = packingName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	
	

}
