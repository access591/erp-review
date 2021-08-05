package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="COMPANY_MASTER")
public class Company {
	
	@Id
	@Column(name = "COMP_CODE", length = 4)
	private String compCode;
	
	@Column(name = "COMP_NAME", length = 100)
	private String compName;
	
	@Column(name = "ADDRESS1", length = 100)
	private String addr1;
	
	@Column(name = "ADDRESS2", length = 100)
	private String addr2;
	
	@Column(name = "CITY_CODE", length = 40)
	private String city;
	
	@Column(name = "FAX", length = 80)
	private String fax;
	
	@Column(name = "EMAIL", length = 75)
	private String email;
	
	@Column(name = "PHONE", length = 45)
	private String phone;
	
	@Column(name = "CST_NUMBER", length = 25)
	private String cstNumber;
	
	@Column(name = "CST_DATE")
	private Date cstDate;
	
	@Column(name = "PF_NUMBER", length = 50)
	private String pfNumber;
	
	@Column(name = "PAN_NUMBER", length = 50)
	private String panNumber;
	
	@Column(name = "IMPORT_LICENSE_NUMBER", length = 50)
	private String importLicenseNumber;
	
	@Column(name = "BRANCH", length = 75)
	private String branch;
	
	@Column(name = "ECC_NUMBER", length = 50)
	private String eccNumber;
	
	@Column(name = "COMP_LOGO", length = 250)
	private String compLogo;
	
	@Column(name = "GST_NUMBER", length = 50)
	private String gstNumber;
	
	@Column(name = "TAX_PAYERLEGALNAME", length = 100)
	private String taxPayerLegalName;
	
	@Column(name = "TAX_PAYER_TRADE_NAME", length = 100)
	private String taxPayerTradeName;
	
	@Column(name = "FILLING_DATE")
	private Date fillingDate;
	
	@Column(name = "BANK_IFSC_CODE", length = 50)
	private String bankIfscCode;
	
	@Column(name = "BANK_NAME", length = 100)
	private String bankName;
	
	@Column(name = "BANK_ADDRESS", length = 220)
	private String bankAddress;
	
	@Column(name = "BANK_ACC_NO", length = 50)
	private String bankAccNo;
	
	@Column(name = "I_BAN", length = 50)
	private String Iban;
	
	@Column(name = "FSSAI_CODE", length = 50)
	private String fssaiCode;

	
	
	public Company() {
		super();
		
	}



	public String getCompCode() {
		return compCode;
	}



	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}



	public String getCompName() {
		return compName;
	}



	public void setCompName(String compName) {
		this.compName = compName;
	}



	public String getAddr1() {
		return addr1;
	}



	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}



	public String getAddr2() {
		return addr2;
	}



	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getFax() {
		return fax;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getCstNumber() {
		return cstNumber;
	}



	public void setCstNumber(String cstNumber) {
		this.cstNumber = cstNumber;
	}



	public Date getCstDate() {
		return cstDate;
	}



	public void setCstDate(Date cstDate) {
		this.cstDate = cstDate;
	}



	public String getPfNumber() {
		return pfNumber;
	}



	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}



	public String getPanNumber() {
		return panNumber;
	}



	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}



	public String getImportLicenseNumber() {
		return importLicenseNumber;
	}



	public void setImportLicenseNumber(String importLicenseNumber) {
		this.importLicenseNumber = importLicenseNumber;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getEccNumber() {
		return eccNumber;
	}



	public void setEccNumber(String eccNumber) {
		this.eccNumber = eccNumber;
	}



	public String getCompLogo() {
		return compLogo;
	}



	public void setCompLogo(String compLogo) {
		this.compLogo = compLogo;
	}



	public String getGstNumber() {
		return gstNumber;
	}



	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}



	public String getTaxPayerLegalName() {
		return taxPayerLegalName;
	}



	public void setTaxPayerLegalName(String taxPayerLegalName) {
		this.taxPayerLegalName = taxPayerLegalName;
	}



	public String getTaxPayerTradeName() {
		return taxPayerTradeName;
	}



	public void setTaxPayerTradeName(String taxPayerTradeName) {
		this.taxPayerTradeName = taxPayerTradeName;
	}



	public Date getFillingDate() {
		return fillingDate;
	}



	public void setFillingDate(Date fillingDate) {
		this.fillingDate = fillingDate;
	}



	public String getBankIfscCode() {
		return bankIfscCode;
	}



	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getBankAddress() {
		return bankAddress;
	}



	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}



	public String getBankAccNo() {
		return bankAccNo;
	}



	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}



	public String getIban() {
		return Iban;
	}



	public void setIban(String iban) {
		Iban = iban;
	}



	public String getFssaiCode() {
		return fssaiCode;
	}



	public void setFssaiCode(String fssaiCode) {
		this.fssaiCode = fssaiCode;
	}
	
	
	
	
	
	
	
	
	
	

}
