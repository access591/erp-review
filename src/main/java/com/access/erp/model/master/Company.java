package com.access.erp.model.master;

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "COMPANY_MASTER")
public class Company {

	@Id
	@Column(name = "COMP_CODE", length = 30)
	private String compCode;

	@Column(name = "COMP_NAME", length = 100)
	private String compName;

	@Column(name = "ADDRESS1", length = 100)
	private String addr1;

	@Column(name = "ADDRESS2", length = 100)
	private String addr2;

	@Column(name = "FAX", length = 80)
	private String fax;

	@Column(name = "EMAIL", length = 75)
	private String email;

	@Column(name = "PHONE", length = 45)
	private String phone;

	@Column(name = "CST_NUMBER", length = 25)
	private String cstNumber;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CST_DATE")
	private Date cstDate;

	@Column(name = "VAT_NUMBER", length = 50)
	private String vatNumber;

	@Column(name = "PF_NUMBER", length = 50)
	private String pfNumber;

	@Column(name = "PAN_NUMBER", length = 50)
	private String panNumber;

	@Column(name = "IMPORT_LICENSE_NUMBER", length = 50)
	private String importLicenseNumber;

	@Column(name = "B17_BOND_NUMBER", length = 40)
	private String b17BondNumber;

	@Column(name = "B17_BOND_DATE")
	private Date b17BondDate;

	@Column(name = "BRANCH", length = 75)
	private String branch;

	@Column(name = "ECC_NUMBER", length = 50)
	private String eccNumber;

	@Column(name = "EXCISE_DIVISION", length = 100)
	private String exciseDivision;

	@Column(name = "COMMISSIONORATE", length = 100)
	private String commissionRate;

	@Column(name = "RANGE_SUPTT_OF_CENT_EXCISE", length = 100)
	private String rangSupttOfCentExcise;

	@Column(name = "ADDRESS_SUPTT_CENT_EXCISE", length = 500)
	private String addressSupttCentExcise;

	@Column(name = "ADDR_ASST_DEPUTY_COMMRATE", length = 500)
	private String addressAsstDeputyCommRate;

	@Column(name = "CENTRAL_EXCISE_REGION_NO", length = 500)
	private String centralExciseRegionNo;

	@Column(name = "COMP_LOGO", length = 500)
	private String compLogo;

	@Column(name = "PARENT_CODE", length = 50)
	private String parentCode;

	@Column(name = "CALCULATE_ESI", length = 10)
	private String calculateEsi;

	@Column(name = "TIN", length = 20)
	private String tin;

	/*
	 * @Column(name = "CITY_CODE", length = 50) private String cityCode;
	 */

	@ManyToOne(optional = false)
	@JoinColumn(name = "CITY_CODE")
	private City city;
	
	
	@Column(name = "TAN", length = 20)
	private String tan;

	@Column(name = "DIR_NAME", length = 75)
	private String dirName;

	@Column(name = "TYPE", length = 10)
	private String type;

	@Column(name = "FLAT_NO", length = 30)
	private String flatNo;

	@Column(name = "BUILDING", length = 30)
	private String building;

	@Column(name = "STREET", length = 30)
	private String street;

	@Column(name = "DISTRICT", length = 30)
	private String district;

	@ManyToOne(optional = false)
	@JoinColumn(name = "STATE_CODE")
	private State state;

	@Column(name = "PIN", length = 8)
	private int pin;

	@Column(name = "STD", length = 10)
	private String std;

	@Column(name = "R_NAME", length = 80)
	private String rName;

	@Column(name = "R_DESIG", length = 30)
	private String rDesig;

	@Column(name = "R_FLAT_NO", length = 30)
	private String rFlatNum;

	@Column(name = "R_BUILDING_NO", length = 30)
	private String rBuildingNo;

	@Column(name = "R_STREET", length = 30)
	private String rStreet;

	@Column(name = "R_STATE", length = 30)
	private String rState;

	@Column(name = "R_CITY", length = 30)
	private String rCity;

	@Column(name = "R_DISTRICT", length = 30)
	private String rDistrict;

	@Column(name = "R_PIN", length = 6)
	private int rPin;

	@Column(name = "R_STD", length = 10)
	private String rStd;

	@Column(name = "R_TEL", length = 15)
	private int rTel;

	@Column(name = "R_EMAIL", length = 30)
	private String rEmail;

	@Column(name = "COMP_TYPE", length = 50)
	private String compType;

	@Column(name = "ESI_C_E", length = 4)
	private String esiCe;

	@Column(name = "ESI_NO", length = 50)
	private String esiNo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "SERVICE_TAX_DATE")
	private Date serviceTaxDate;

	@Column(name = "SERVICE_TAX_NO", length = 50)
	private String serviceTaxNo;

	@Column(name = "ACCOUNT_TAX_SALE", length = 10)
	private String ccountTaxSale;

	@Column(name = "ACCOUNT_TAX_PURCHASE", length = 10)
	private String accountTaxPurchase;

	@Column(name = "DRUG_LICENCE_NO", length = 25)
	private String drugLicenceNo;

	@Column(name = "STD2", length = 10)
	private String std2;

	@Column(name = "PHONE2", length = 45)
	private String phone2;

	@Column(name = "PLA_NO", length = 20)
	private String plaNo;

	@Column(name = "TDS_EXCISE_DIVISION", length = 100)
	private String tdsExciseDivision;

	@Column(name = "TDS_BRANCH", length = 75)
	private String tdsBranch;

	@Column(name = "IEC_CODE_NO", length = 20)
	private String iecCodeNo;

	@Column(name = "EXP_REF", length = 20)
	private String expRef;

	@Column(name = "EXCISE_DIVISION_ADD", length = 100)
	private String exciseDivisionAdd;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "TIN_DATE")
	private Date tinDate;

	@Column(name = "WEBSITE", length = 50)
	private String website;

	@Column(name = "NOTIFICATION_NO", length = 30)
	private String notificationNo;

	@Column(name = "NOTIFICATION_NO1", length = 30)
	private String notificationNo1;

	@Column(name = "RCMC_NO", length = 30)
	private String rcmcNo;

	@Column(name = "EXP_CERTIFICATE_NO", length = 30)
	private String expCertiificateNo;

	@Column(name = "CIN_NO", length = 30)
	private String cinNo;

	@Column(name = "GST_NO", length = 30)
	private String gstNo;

	@Column(name = "TAX_PAYERLEGALNAME", length = 100)
	private String taxPayerLegalName;

	@Column(name = "TAX_PAYER_TRADE_NAME", length = 100)
	private String taxPayerTradeName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<InsuranceDetail> insuranceDetail;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SiteOffice> siteOffice;

	public Company() {
		super();

	}

	public String getCompCode() {
		return compCode;
	}

	public List<InsuranceDetail> getInsuranceDetail() {
		return insuranceDetail;
	}

	public void setInsuranceDetail(List<InsuranceDetail> insuranceDetail) {
		this.insuranceDetail = insuranceDetail;
	}

	public List<SiteOffice> getSiteOffice() {
		return siteOffice;
	}

	public void setSitOffice(List<SiteOffice> siteOffice) {
		this.siteOffice = siteOffice;
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

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
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

	public String getB17BondNumber() {
		return b17BondNumber;
	}

	public void setB17BondNumber(String b17BondNumber) {
		this.b17BondNumber = b17BondNumber;
	}

	public Date getB17BondDate() {
		return b17BondDate;
	}

	public void setB17BondDate(Date b17BondDate) {
		this.b17BondDate = b17BondDate;
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

	public String getExciseDivision() {
		return exciseDivision;
	}

	public void setExciseDivision(String exciseDivision) {
		this.exciseDivision = exciseDivision;
	}

	public String getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}

	public String getRangSupttOfCentExcise() {
		return rangSupttOfCentExcise;
	}

	public void setRangSupttOfCentExcise(String rangSupttOfCentExcise) {
		this.rangSupttOfCentExcise = rangSupttOfCentExcise;
	}

	public String getAddressSupttCentExcise() {
		return addressSupttCentExcise;
	}

	public void setAddressSupttCentExcise(String addressSupttCentExcise) {
		this.addressSupttCentExcise = addressSupttCentExcise;
	}

	public String getAddressAsstDeputyCommRate() {
		return addressAsstDeputyCommRate;
	}

	public void setAddressAsstDeputyCommRate(String addressAsstDeputyCommRate) {
		this.addressAsstDeputyCommRate = addressAsstDeputyCommRate;
	}

	public String getCentralExciseRegionNo() {
		return centralExciseRegionNo;
	}

	public void setCentralExciseRegionNo(String centralExciseRegionNo) {
		this.centralExciseRegionNo = centralExciseRegionNo;
	}

	public String getCompLogo() {
		return compLogo;
	}

	public void setCompLogo(String compLogo) {
		this.compLogo = compLogo;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getCalculateEsi() {
		return calculateEsi;
	}

	public void setCalculateEsi(String calculateEsi) {
		this.calculateEsi = calculateEsi;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	

	public String getTan() {
		return tan;
	}

	public void setTan(String tan) {
		this.tan = tan;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setSiteOffice(List<SiteOffice> siteOffice) {
		this.siteOffice = siteOffice;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrDesig() {
		return rDesig;
	}

	public void setrDesig(String rDesig) {
		this.rDesig = rDesig;
	}

	public String getrFlatNum() {
		return rFlatNum;
	}

	public void setrFlatNum(String rFlatNum) {
		this.rFlatNum = rFlatNum;
	}

	public String getrBuildingNo() {
		return rBuildingNo;
	}

	public void setrBuildingNo(String rBuildingNo) {
		this.rBuildingNo = rBuildingNo;
	}

	public String getrStreet() {
		return rStreet;
	}

	public void setrStreet(String rStreet) {
		this.rStreet = rStreet;
	}

	public String getrState() {
		return rState;
	}

	public void setrState(String rState) {
		this.rState = rState;
	}

	public String getrCity() {
		return rCity;
	}

	public void setrCity(String rCity) {
		this.rCity = rCity;
	}

	public String getrDistrict() {
		return rDistrict;
	}

	public void setrDistrict(String rDistrict) {
		this.rDistrict = rDistrict;
	}

	public int getrPin() {
		return rPin;
	}

	public void setrPin(int rPin) {
		this.rPin = rPin;
	}

	public String getrStd() {
		return rStd;
	}

	public void setrStd(String rStd) {
		this.rStd = rStd;
	}

	public int getrTel() {
		return rTel;
	}

	public void setrTel(int rTel) {
		this.rTel = rTel;
	}

	public String getrEmail() {
		return rEmail;
	}

	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public String getEsiCe() {
		return esiCe;
	}

	public void setEsiCe(String esiCe) {
		this.esiCe = esiCe;
	}

	public String getEsiNo() {
		return esiNo;
	}

	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}

	public Date getServiceTaxDate() {
		return serviceTaxDate;
	}

	public void setServiceTaxDate(Date serviceTaxDate) {
		this.serviceTaxDate = serviceTaxDate;
	}

	public String getServiceTaxNo() {
		return serviceTaxNo;
	}

	public void setServiceTaxNo(String serviceTaxNo) {
		this.serviceTaxNo = serviceTaxNo;
	}

	public String getCcountTaxSale() {
		return ccountTaxSale;
	}

	public void setCcountTaxSale(String ccountTaxSale) {
		this.ccountTaxSale = ccountTaxSale;
	}

	public String getAccountTaxPurchase() {
		return accountTaxPurchase;
	}

	public void setAccountTaxPurchase(String accountTaxPurchase) {
		this.accountTaxPurchase = accountTaxPurchase;
	}

	public String getDrugLicenceNo() {
		return drugLicenceNo;
	}

	public void setDrugLicenceNo(String drugLicenceNo) {
		this.drugLicenceNo = drugLicenceNo;
	}

	public String getStd2() {
		return std2;
	}

	public void setStd2(String std2) {
		this.std2 = std2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPlaNo() {
		return plaNo;
	}

	public void setPlaNo(String plaNo) {
		this.plaNo = plaNo;
	}

	public String getTdsExciseDivision() {
		return tdsExciseDivision;
	}

	public void setTdsExciseDivision(String tdsExciseDivision) {
		this.tdsExciseDivision = tdsExciseDivision;
	}

	public String getTdsBranch() {
		return tdsBranch;
	}

	public void setTdsBranch(String tdsBranch) {
		this.tdsBranch = tdsBranch;
	}

	public String getIecCodeNo() {
		return iecCodeNo;
	}

	public void setIecCodeNo(String iecCodeNo) {
		this.iecCodeNo = iecCodeNo;
	}

	public String getExpRef() {
		return expRef;
	}

	public void setExpRef(String expRef) {
		this.expRef = expRef;
	}

	public String getExciseDivisionAdd() {
		return exciseDivisionAdd;
	}

	public void setExciseDivisionAdd(String exciseDivisionAdd) {
		this.exciseDivisionAdd = exciseDivisionAdd;
	}

	public Date getTinDate() {
		return tinDate;
	}

	public void setTinDate(Date tinDate) {
		this.tinDate = tinDate;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getNotificationNo() {
		return notificationNo;
	}

	public void setNotificationNo(String notificationNo) {
		this.notificationNo = notificationNo;
	}

	public String getNotificationNo1() {
		return notificationNo1;
	}

	public void setNotificationNo1(String notificationNo1) {
		this.notificationNo1 = notificationNo1;
	}

	public String getRcmcNo() {
		return rcmcNo;
	}

	public void setRcmcNo(String rcmcNo) {
		this.rcmcNo = rcmcNo;
	}

	public String getExpCertiificateNo() {
		return expCertiificateNo;
	}

	public void setExpCertiificateNo(String expCertiificateNo) {
		this.expCertiificateNo = expCertiificateNo;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
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
