package com.access.erp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Item;


@Entity
@Table(name="RFQ_ITEM_DETAIL")
public class RfQuotationItem {
	
	@Id
	@Column(name="RFQ_ITEM_ID",length = 50)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ITEM_CODE")
	private Item item;
	
	@Column(name="UOM",length = 50)
	private String uom;
	
	@Column(name="SR_NO",length = 50)
	private String srNo;
	
	@Column(name="QTY",length = 50)
	private String qty;
	
	
	@Column(name="ITEM_SPEC",length = 50)
	private String itemSpec;
	
	@Column(name="TERM_CONDITION",length = 50)
	private String termCondition;
	
	@Column(name="REMARKS",length = 50)
	private String remarks;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "INDENT_NUMBER")
	private OpenIndent openIndent;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "RFQ_NUM")
	private RfQuotation rfQuotations;

	public RfQuotationItem() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public String getTermCondition() {
		return termCondition;
	}

	public void setTermCondition(String termCondition) {
		this.termCondition = termCondition;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public RfQuotation getRfQuotations() {
		return rfQuotations;
	}

	public void setRfQuotations(RfQuotation rfQuotations) {
		this.rfQuotations = rfQuotations;
	}

	public OpenIndent getOpenIndent() {
		return openIndent;
	}

	public void setOpenIndent(OpenIndent openIndent) {
		this.openIndent = openIndent;
	}
	
	
	
	
	
	

}
