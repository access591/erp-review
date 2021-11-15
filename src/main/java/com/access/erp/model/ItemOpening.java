package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.MyUser;


@Entity
@Table(name="ITEM_OPENING")
public class ItemOpening {

	@Id
	@Column(name="ITEM_CODE",length = 15)
	private String itemCode;
	
	@Column(name="OPENING_DATE" )
	private Date openingDate;
	
	@Column(name="OPENING_STOCK",precision=12, scale=3)
	private int openingStock;
	
	@Column(name="CURRENT_STOCK",precision=12, scale=3 )
	private int currentStock;
	
	@Column(name="CLOSING_STOCK",precision=12, scale=3 )
	private int closingStock;
	
	//company code 
	
	@ManyToOne(optional = false)
    @JoinColumn(name="CCODE")
    private Company universcompanyity;
	
	
	// fy code 
	
	@ManyToOne(optional = false)
	@JoinColumn(name="FYCODE")
	private FinancialActiveYear financialActiveYear;
	
	//ucode 
	@ManyToOne(optional = false)
	@JoinColumn(name="UCODE")
	private MyUser myUser;
	
	
	@Column(name="U_DATE" )
	private Date uDate;
	
	@Column(name="OPENING_RATE",precision=14, scale=3 )
	private int openingRate;
	
	@Column(name="CLOSING_RATE",precision=14, scale=3 )
	private int closingRate;
	
	//party coded 
	
	
	@Column(name="CT_OPENING",precision=12, scale=3 )
	private int ctOpening;
	
	@Column(name="BOND_OPENING",precision=12, scale=3)
	private int bondOpening;

	
	
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

	public int getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public int getClosingStock() {
		return closingStock;
	}

	public void setClosingStock(int closingStock) {
		this.closingStock = closingStock;
	}

	public Company getUniverscompanyity() {
		return universcompanyity;
	}

	public void setUniverscompanyity(Company universcompanyity) {
		this.universcompanyity = universcompanyity;
	}

	public FinancialActiveYear getFinancialActiveYear() {
		return financialActiveYear;
	}

	public int getClosingRate() {
		return closingRate;
	}

	public void setClosingRate(int closingRate) {
		this.closingRate = closingRate;
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

	public int getOpeningRate() {
		return openingRate;
	}

	public void setOpeningRate(int openingRate) {
		this.openingRate = openingRate;
	}

	public int getCtOpening() {
		return ctOpening;
	}

	public void setCtOpening(int ctOpening) {
		this.ctOpening = ctOpening;
	}

	public int getBondOpening() {
		return bondOpening;
	}

	public void setBondOpening(int bondOpening) {
		this.bondOpening = bondOpening;
	}

	
	
	
	
}
