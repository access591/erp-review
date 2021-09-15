package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="")
public class OpenIndentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "IN_ITEM_CODE", length = 50)
	private String indItemCode;
	
	@Column(name = "IN_QTY", length = 50)
	private String indQty;
	
	@Column(name = "QTY_IN_STOCK", length = 50)
	private int qtyInStock;
	
	@Column(name = "IN_REQ_DATE", length = 50)
	private Date indReqDate;
	
	@Column(name = "IN_PURPOSE", length = 50)
	private String indPurpose;
	
	@Column(name = "PUR_STATUS_ITEM_WISE", length = 50)
	private String purStatusItemWise;
	
	@Column(name = "ITEM_RATE", length = 50)
	private int itemRate;
	
	@Column(name = "TOTAL_VALUE", length = 50)
	private int totalValue;
	
	@Column(name = "CURRENCY_CODE", length = 50)
	private String currencyCode;
	
	@Column(name = "CONVERSION_VALUE", length = 50)
	private int conversionvalue;
	
	@Column(name = "QTY_SO", length = 50)
	private int qtySo;
	
	@Column(name = "QTY_PROCURED", length = 50)
	private int qtyProcured;
	
	@Column(name = "AVAIL_QTY", length = 50)
	private int availQty;
	
	@Column(name = "IN_APP_STATUS", length = 50)
	private String indAppStatus;
	
	@Column(name = "STATUS", length = 50)
	private String status;
	
	@Column(name = "APPROVED_QTY", length = 50)
	private int approvedQty;
	
	@Column(name = "PIPELINE_QTY", length = 50)
	private int pipelineQty;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="INDENT_NUMBER")
	private OpenIndent openIndent;
	
	@Column(name = "INDENT_DATE", length = 50)
	private Date indentDate;
	
	@Column(name = "IND_SEQ", length = 50) 
	private int indSeq;

	public OpenIndentDetail() {
		super();
		
	}

	public String getIndItemCode() {
		return indItemCode;
	}

	public void setIndItemCode(String indItemCode) {
		this.indItemCode = indItemCode;
	}

	public String getIndQty() {
		return indQty;
	}

	public void setIndQty(String indQty) {
		this.indQty = indQty;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public Date getIndReqDate() {
		return indReqDate;
	}

	public void setIndReqDate(Date indReqDate) {
		this.indReqDate = indReqDate;
	}

	public String getIndPurpose() {
		return indPurpose;
	}

	public void setIndPurpose(String indPurpose) {
		this.indPurpose = indPurpose;
	}

	public String getPurStatusItemWise() {
		return purStatusItemWise;
	}

	public void setPurStatusItemWise(String purStatusItemWise) {
		this.purStatusItemWise = purStatusItemWise;
	}

	public int getItemRate() {
		return itemRate;
	}

	public void setItemRate(int itemRate) {
		this.itemRate = itemRate;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public int getConversionvalue() {
		return conversionvalue;
	}

	public void setConversionvalue(int conversionvalue) {
		this.conversionvalue = conversionvalue;
	}

	public int getQtySo() {
		return qtySo;
	}

	public void setQtySo(int qtySo) {
		this.qtySo = qtySo;
	}

	public int getQtyProcured() {
		return qtyProcured;
	}

	public void setQtyProcured(int qtyProcured) {
		this.qtyProcured = qtyProcured;
	}

	public int getAvailQty() {
		return availQty;
	}

	public void setAvailQty(int availQty) {
		this.availQty = availQty;
	}

	public String getIndAppStatus() {
		return indAppStatus;
	}

	public void setIndAppStatus(String indAppStatus) {
		this.indAppStatus = indAppStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getApprovedQty() {
		return approvedQty;
	}

	public void setApprovedQty(int approvedQty) {
		this.approvedQty = approvedQty;
	}

	public int getPipelineQty() {
		return pipelineQty;
	}

	public void setPipelineQty(int pipelineQty) {
		this.pipelineQty = pipelineQty;
	}

	public OpenIndent getOpenIndent() {
		return openIndent;
	}

	public void setOpenIndent(OpenIndent openIndent) {
		this.openIndent = openIndent;
	}

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public int getIndSeq() {
		return indSeq;
	}

	public void setIndSeq(int indSeq) {
		this.indSeq = indSeq;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
}
