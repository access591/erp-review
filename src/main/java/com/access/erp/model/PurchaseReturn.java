package com.access.erp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.PartyMaster;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PURCHASE_RETURN_MASTER")
public class PurchaseReturn {

	@Id
	@Column(name = "PURCHASE_SR_NO", length = 15)
	private String purchasePrNo;

	@Column(name = "PR_DATE")
	private Date prDate;
	
	@ManyToOne
	@JoinColumn(name = "MRN_No")
	private MRN mrnNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "GATE_ENTRY_DATE")
	private Date mrnDate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "SUPPLIER_CODE")
	private PartyMaster partyMaster;


	@Column(name="ISSUE_NO")
	private String issueNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern ="yyyy-MM-dd")
	@Column(name="ISSUE_DATE")
	private Date issueDate;
	
	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	@ManyToOne(optional = true)
	@JoinColumn(name = "CCODE")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "FY_CODE")
	private FinancialYear fyyear;


	@Column(name = "DEBIT_YN")
	private String debityn;
	
	
	@Column(name ="DEBIT_NOTE_NO")
	private String debitNo;
	
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "purchaseReturn", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
	List<PurchaseReturnDetail> listPurchaseReturnDetail = new ArrayList<>();


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


	public MRN getMrnNo() {
		return mrnNo;
	}


	public void setMrnNo(MRN mrnNo) {
		this.mrnNo = mrnNo;
	}


	public Date getMrnDate() {
		return mrnDate;
	}


	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}


	public PartyMaster getPartyMaster() {
		return partyMaster;
	}


	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}


	public String getIssueNo() {
		return issueNo;
	}


	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public FinancialYear getFyyear() {
		return fyyear;
	}


	public void setFyyear(FinancialYear fyyear) {
		this.fyyear = fyyear;
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


	public List<PurchaseReturnDetail> getListPurchaseReturnDetail() {
		return listPurchaseReturnDetail;
	}


	public void setListPurchaseReturnDetail(List<PurchaseReturnDetail> listPurchaseReturnDetail) {
		this.listPurchaseReturnDetail = listPurchaseReturnDetail;
	}
	
	
	

}
