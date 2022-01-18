package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.PartyMaster;

@Entity
@Table(name = "PURCHASE_RETURN_MASTER")
public class PurchaseReturn {

	@Id
	@Column(name = "PURCHASE_SR_NO", length = 15)
	private String purchasePrNo;

	@Column(name = "PR_DATE")
	private Date prDate;

	@ManyToOne(optional = true)
	@JoinColumn(name = "CCODE")
	private Company company;

	@Column(name = "DEBIT_YN")
	private String debityn;
	
	
	@Column(name ="DEBIT_NOTE_NO")
	private String debitNo;
	
	
	

	@ManyToOne(optional = false)
	@JoinColumn(name = "SUPPLIER_CODE")
	private PartyMaster partyMaster;

	@ManyToOne
	@JoinColumn(name = "MRN_No")
	private MRN mrnNo;

	@ManyToOne
	@JoinColumn(name = "FY_CODE")
	private FinancialYear fyyear;

	@ManyToOne
	@JoinColumn(name = "ISSUE_NO")
	private IssueSlip issueslip;

	public String getPurchasePrNo() {
		return purchasePrNo;
	}

	public void setPurchasePrNo(String purchasePrNo) {
		this.purchasePrNo = purchasePrNo;
	}

	public Date getPrDate() {
		return prDate;
	}

	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getDebityn() {
		return debityn;
	}

	public void setDebityn(String debityn) {
		this.debityn = debityn;
	}

	public String getDebitNo() {
		return debitNo;
	}

	public void setDebitNo(String debitNo) {
		this.debitNo = debitNo;
	}

	public PartyMaster getPartyMaster() {
		return partyMaster;
	}

	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}

	public MRN getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(MRN mrnNo) {
		this.mrnNo = mrnNo;
	}

	public FinancialYear getFyyear() {
		return fyyear;
	}

	public void setFyyear(FinancialYear fyyear) {
		this.fyyear = fyyear;
	}

	public IssueSlip getIssueslip() {
		return issueslip;
	}

	public void setIssueslip(IssueSlip issueslip) {
		this.issueslip = issueslip;
	}
	
	
	

}
