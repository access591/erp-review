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

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.PartyMaster;


@Entity
@Table(name="FIFORATE_ITEM")
public class FifoRateItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = true)
    @JoinColumn(name="FYCODE",nullable = true)
	private FinancialActiveYear fyYear;
	
	@ManyToOne(optional = true)
    @JoinColumn(name="MRN_NO",nullable = true)
	private MRN mrn;
	
	@Column(name="MRN_DATE")
	private Date mrnDate;
	
	

	@ManyToOne(optional = true)
    @JoinColumn(name="ITEM_CODE",nullable = true)
	private Item item;
	
	@Column(name = "QTY", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qty;
	
	@Column(name = "RATE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double rate;
	
	@Column(name = "PEN_ITEMS", columnDefinition = "FLOAT(12,3)",nullable = true)
	private double penItems;
	
	@ManyToOne(optional = true)
    @JoinColumn(name="CCODE")
	private Company company;
	
	@ManyToOne(optional = true)
    @JoinColumn(name="PARTY_CODE",nullable = true)
	private PartyMaster partyMaster;
	
	@Column(name = "ITEM_NET_VAL", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double itemNetVal;
	
	@Column(name="HEAT_CODE",length = 16)
	private String heatCode;
	
	@Column(name="HEAT_NO",length = 16)
	private String heatNo;
	
	@Column(name="COL_CODE",length = 16)
	private String colCode;
	
	@Column(name = "AVG_RATE", columnDefinition = "FLOAT(12,2)",nullable = true)
	private double avgRate;
	
	@Column(name = "NO_OF_BARS", columnDefinition = "FLOAT(12,2)",nullable = true)
	private double noOfBars;

	public FinancialActiveYear getFyYear() {
		return fyYear;
	}

	public void setFyYear(FinancialActiveYear fyYear) {
		this.fyYear = fyYear;
	}

	public MRN getMrn() {
		return mrn;
	}

	public void setMrn(MRN mrn) {
		this.mrn = mrn;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getPenItems() {
		return penItems;
	}

	public void setPenItems(double penItems) {
		this.penItems = penItems;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public PartyMaster getPartyMaster() {
		return partyMaster;
	}

	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}

	public double getItemNetVal() {
		return itemNetVal;
	}

	public void setItemNetVal(double itemNetVal) {
		this.itemNetVal = itemNetVal;
	}

	public String getHeatCode() {
		return heatCode;
	}

	public void setHeatCode(String heatCode) {
		this.heatCode = heatCode;
	}

	public String getHeatNo() {
		return heatNo;
	}

	public void setHeatNo(String heatNo) {
		this.heatNo = heatNo;
	}

	public String getColCode() {
		return colCode;
	}

	public void setColCode(String colCode) {
		this.colCode = colCode;
	}

	public double getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(double avgRate) {
		this.avgRate = avgRate;
	}

	public double getNoOfBars() {
		return noOfBars;
	}

	public void setNoOfBars(double noOfBars) {
		this.noOfBars = noOfBars;
	}
	
	
	
	
	
	
	
}
