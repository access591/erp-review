package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.MyUser;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ITEM_OPENING")
public class ItemOpening {

	@Id
	@Column(name="ITEM_CODE",length = 50)
	private String itemCode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="OPENING_DATE" )
	private Date openingDate;
	
	@Column(name="OPENING_STOCK",length=50)
	private String openingStock;
	
	@Column(name="CURRENT_STOCK",length=50 )
	private String currentStock;
	
	@Column(name="CLOSING_STOCK",length=50 )
	private String closingStock;
	
	//company code 
	
	@ManyToOne(optional = false)
    @JoinColumn(name="CCODE")
	@JsonIgnore
    private Company company;
	
	
	// fy code 
	
	@ManyToOne(optional = false)
	@JoinColumn(name="FYCODE")
	@JsonIgnore
	private FinancialActiveYear financialActiveYear;
	
	//ucode 
	@ManyToOne(optional = false)
	@JoinColumn(name="UCODE")
	@JsonIgnore
	private MyUser myUser;
	

	@Column(name="U_DATE" )
	private Date uDate;
	
	@Column(name="OPENING_RATE",length=50 )
	private String openingRate;
	
	@Column(name="CLOSING_RATE",length=50 )
	private String closingRate;
	
	//party coded 
	
	
	@Column(name="CT_OPENING",length=50 )
	private String ctOpening;
	
	@Column(name="BOND_OPENING",length=50)
	private String bondOpening;

	
	
	public ItemOpening() {
		super();
		
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}


	


	public FinancialActiveYear getFinancialActiveYear() {
		return financialActiveYear;
	}


	public void setFinancialActiveYear(FinancialActiveYear financialActiveYear) {
		
		
		this.financialActiveYear = financialActiveYear;
	}

	public MyUser getMyUser() {
		return myUser;
	}

	public void setMyUser(MyUser myUser) {
		
		
		this.myUser = myUser;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	public String getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(String openingStock) {
		this.openingStock = openingStock;
	}

	public String getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(String currentStock) {
		this.currentStock = currentStock;
	}

	public String getClosingStock() {
		return closingStock;
	}

	public void setClosingStock(String closingStock) {
		this.closingStock = closingStock;
	}

	public String getOpeningRate() {
		return openingRate;
	}

	public void setOpeningRate(String openingRate) {
		this.openingRate = openingRate;
	}

	public String getClosingRate() {
		return closingRate;
	}

	public void setClosingRate(String closingRate) {
		this.closingRate = closingRate;
	}

	public String getCtOpening() {
		return ctOpening;
	}

	public void setCtOpening(String ctOpening) {
		this.ctOpening = ctOpening;
	}

	public String getBondOpening() {
		return bondOpening;
	}

	public void setBondOpening(String bondOpening) {
		this.bondOpening = bondOpening;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

	

	
	
	
	
}
