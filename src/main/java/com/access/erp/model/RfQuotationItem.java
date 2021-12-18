package com.access.erp.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.master.Item;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="RFQ_ITEM_DETAIL")
public class RfQuotationItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RFQ_ITEM_ID",length = 50)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ITEM_CODE")
	private Item item;
	
	//fk
	@Column(name="UOM",length = 50)
	private String uom;
	
	@Column(name="CITY",length = 50)
	private String city;
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="RFQ_DATE")
	private Date rfqDate;
	
	@Column(name="SR_NO",length =6)
	private String srNo;
	
	//12 , 3
	@Column(name="QTY",length = 16)
	private String qty;
	
	
	@Column(name="ITEM_SPEC",length = 100)
	private String itemSpec;
	
	@Column(name="TERM_CONDITION",length = 500)
	private String termCondition;
	
	@Column(name="REMARKS",length = 500)
	private String remarks;
	
	
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name = "INDENT_NO",nullable = true)
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OpenIndent openIndent;
	
	// indent date 
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "INDENT_DATE")
	private Date indentDate;
	
	
	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "RFQ_NO")
	@JsonIgnore
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getRfqDate() {
		return rfqDate;
	}

	public void setRfqDate(Date rfqDate) {
		this.rfqDate = rfqDate;
	}
	
	
	 public boolean equals(Object obj) {         
	        if(obj != null && (obj instanceof RfQuotationItem)) {
	        	RfQuotationItem other = (RfQuotationItem) obj;
	            return this.openIndent.equals(other.getOpenIndent());
	        }
	        return false;
	    }
	
	
	

}
