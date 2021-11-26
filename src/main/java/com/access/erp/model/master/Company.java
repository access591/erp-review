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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "M_COMPANY")
public class Company {

	@Id
	@Column(name = "CCODE", length = 2)
	private String compCode;

	@Column(name = "CNAME", length = 75)
	private String compName;
	
	@Column(name = "DIR_NAME", length = 75)
	private String dirName;
	
	@Column(name = "PARENT_CODE", length = 2)
	private String parentCode;
	
	@Column(name = "CLOGO", length = 500)
	private String compLogo;

	@Column(name = "CALCULATE_ESI", length = 2)
	private String calculateEsi;
	
	@Column(name = "ESI_NO", length = 50)
	private String esiNo;
	
	@Column(name = "COMP_TYPE", length = 2)
	private String compType;
	
	@Column(name = "ACCOUNT_TAX_SALE", length = 9)
	private String acountTaxSale;

	@Column(name = "ACCOUNT_TAX_PURCHASE", length = 9)
	private String accountTaxPurchase;
	
	@Column(name = "DEDUCTION_FROM_EMP", length = 10)
	private String deductionFromEmp;
	
	@Column(name = "PF_NO", length = 20)
	private String PfNumber;

	@Column(name = "ADDR1", length = 55)
	private String cAddr1;

	@Column(name = "ADDR2", length = 55)
	private String cAddr2;
	
	@Column(name = "C_ROAD_STREET_LANE", length = 100)
	private String cStreet;

	@Column(name = "FAX", length = 45)
	private String cFax;

	@Column(name = "EMAIL", length = 75)
	private String cEmail;
	
	@Column(name = "C_WEBSITE", length = 75)
	private String cWebsite;

	@Column(name = "PHONE", length = 45)
	private String cPhone1;
	
	@Column(name = "C_PHONE2", length = 45)
	private String cPhone2;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "C_STATE_CODE",nullable = true)
	@JsonIgnore
	private State cState;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "CITY",nullable = true)
	@JsonIgnore
	private City cCity;
	
	@Column(name = "PIN", length = 6)
	private String cPin;
	

	@Column(name = "TYPE", length = 2)
	private String type;
	
	@Column(name = "R_NAME", length = 75)
	private String rName;
	
	@Column(name = "R_TYPE_DEDUCTOR", length = 80)
	private String rTypeOfDeductor;
	
	@Column(name = "R_BRANCH", length = 75)
	private String rBranch;

	@Column(name = "R_EXCISE_DIVISION", length = 100)
	private String rExciseDivision;
	
	@Column(name = "R_DESIG", length = 20)
	private String rDesig;

	@Column(name = "R_FLAT_NO", length = 25)
	private String rFlatNum;

	@Column(name = "R_BUILDING", length = 25)
	private String rBuildingNo;

	@Column(name = "STREET", length = 25)
	private String rStreet;

	@ManyToOne(optional = true)
	@JoinColumn(name = "R_STATE",nullable = true)
	@JsonIgnore
	private State rState;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "R_CITY",nullable = true)
	@JsonIgnore
	private City rCity;

	@Column(name = "R_LOCATION", length = 50)
	private String rLocation;

	@Column(name = "R_PIN", length = 6)
	private String rPin;

	@Column(name = "R_STD", length = 5)
	private String rStd;

	@Column(name = "R_TEL", length = 10)
	private Long rTel;

	@Column(name = "R_EMAIL", length = 75)
	private String rEmail;
	
	
	@Column(name = "PARENT_CCODE", length = 30)
	private String parentCCode;
	
	

	

	
	@Column(name = "T_GST_NO", length = 30)
	private String tGstNo;
	
	@Column(name = "TAX_PAYERLEGALNAME", length = 100)
	private String taxPayerLegalName;

	@Column(name = "TAX_PAYER_TRADE_NAME", length = 100)
	private String taxPayerTradeName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "T_FILLING_DATE")
	private Date tFillingDate;
	
	@Column(name = "PAN_NO", length = 10)
	private String panNumber;
	
	
	
	
	
	
	
	@Column(name = "TD_GST_NUMBER", length = 50)
	private String tdGstNumber;
	
	@Column(name = "TD_TAX_PAYERLEGALNAME", length = 100)
	private String tdTaxPayerLegalName;

	@Column(name = "TD_TAX_PAYER_TRADE_NAME", length = 100)
	private String tdTaxPayerTradeName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "TD_FILLING_DATE")
	private Date tdFillingDate;
	
	
//	 extra collumn 
	
	@Column(name = "CST_NO", length = 25)
	private String cstNumber;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CST_DT")
	private Date cstDate;

	@Column(name = "VAT_NO", length = 20)
	private String vatNumber;

	

	@Column(name = "IMPORT_LICENSE_NO", length = 50)
	private String importLicenseNumber;

	@Column(name = "B17_BOND_NUMBER", length = 10)
	private String b17BondNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "B17_BOND_DATE")
	private Date b17BondDate;
	
	@Column(name = "RCMC_NO", length = 25)
	private String rcmcNo;

	@Column(name = "EXP_PERFORMANCE", length = 50)
	private String expPerformance;
	
	@Column(name = "EXP_CERTIFICATE_NO", length = 25)
	private String expCertiificateNo;
	
	
	
	@Column(name = "ECC_NO", length = 50)
	private String eccNumber;

	

	@Column(name = "COMMISSIONORATE", length = 100)
	private String commissionRate;

	@Column(name = "RANGE_SUPTT_OF_CENT_EXCISE", length = 100)
	private String rangSupttOfCentExcise;

	@Column(name = "ADDRESS_SUPTT_CENT_EXCISE", length = 500)
	private String addressSupttCentExcise;

	@Column(name = "ADDR_ASST_DEPUTY_COMMRATE", length = 500)
	private String addressAsstDeputyCommRate;

	@Column(name = "CENTRAL_EXCISE_REGION_NO", length = 50)
	private String centralExciseRegionNo;

	

	

	@Column(name = "TIN", length = 20)
	private String tin;

	/*
	 * @Column(name = "CITY_CODE", length = 50) private String cityCode;
	 */



	@Column(name = "STD", length = 5)
	private String std;

	
	

	@Column(name = "ESI_C_E", length = 2)
	private String esiCe;

	

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "SERVICE_TAX_DATE")
	private Date serviceTaxDate;

	@Column(name = "SERVICE_TAX_NO", length = 50)
	private String serviceTaxNo;

	

	@Column(name = "DRUG_LICENCE_NO", length = 25)
	private String drugLicenceNo;

	@Column(name = "STD2", length = 5)
	private String std2;

	

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

	
	
	@Column(name = "NOTIFICATION_NO", length = 30)
	private String notificationNo;

	@Column(name = "NOTIFICATION_NO1", length = 30)
	private String notificationNo1;

	

	

	@Column(name = "CIN_NO", length = 25)
	private String cinNo;

	@Column(name = "REGN_NO", length = 50)
	private String regnNO;

	

	

	

	/*
	 * @Column(name = "BANK_IFSC_CODE", length = 50) private String bankIfscCode;
	 * 
	 * @Column(name = "BANK_NAME", length = 100) private String bankName;
	 * 
	 * @Column(name = "BANK_ADDRESS", length = 220) private String bankAddress;
	 * 
	 * @Column(name = "BANK_ACC_NO", length = 50) private String bankAccNo;
	 * 
	 * @Column(name = "I_BAN", length = 50) private String Iban;
	 * 
	 * @Column(name = "FSSAI_CODE", length = 50) private String fssaiCode;
	 */

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SELECT)
	private List<InsuranceDetail> insuranceDetail;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SELECT)
	private List<SiteOffice> siteOffice;

	public Company() {
		super();
		
		System.out.println("==========>  IN COMPANY MASTER <==============");

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

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getCompLogo() {
		return compLogo;
	}

	public void setCompLogo(String compLogo) {
		this.compLogo = compLogo;
	}

	public String getCalculateEsi() {
		return calculateEsi;
	}

	public void setCalculateEsi(String calculateEsi) {
		this.calculateEsi = calculateEsi;
	}

	public String getEsiNo() {
		return esiNo;
	}

	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public String getAcountTaxSale() {
		return acountTaxSale;
	}

	public void setAcountTaxSale(String acountTaxSale) {
		this.acountTaxSale = acountTaxSale;
	}

	public String getAccountTaxPurchase() {
		return accountTaxPurchase;
	}

	public void setAccountTaxPurchase(String accountTaxPurchase) {
		this.accountTaxPurchase = accountTaxPurchase;
	}

	public String getDeductionFromEmp() {
		return deductionFromEmp;
	}

	public void setDeductionFromEmp(String deductionFromEmp) {
		this.deductionFromEmp = deductionFromEmp;
	}

	public String getPfNumber() {
		return PfNumber;
	}

	public void setPfNumber(String pfNumber) {
		PfNumber = pfNumber;
	}

	public String getcAddr1() {
		return cAddr1;
	}

	public void setcAddr1(String cAddr1) {
		this.cAddr1 = cAddr1;
	}

	public String getcAddr2() {
		return cAddr2;
	}

	public void setcAddr2(String cAddr2) {
		this.cAddr2 = cAddr2;
	}

	public String getcStreet() {
		return cStreet;
	}

	public void setcStreet(String cStreet) {
		this.cStreet = cStreet;
	}

	public String getcFax() {
		return cFax;
	}

	public void setcFax(String cFax) {
		this.cFax = cFax;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcWebsite() {
		return cWebsite;
	}

	public void setcWebsite(String cWebsite) {
		this.cWebsite = cWebsite;
	}

	public String getcPhone1() {
		return cPhone1;
	}

	public void setcPhone1(String cPhone1) {
		this.cPhone1 = cPhone1;
	}

	public String getcPhone2() {
		return cPhone2;
	}

	public void setcPhone2(String cPhone2) {
		this.cPhone2 = cPhone2;
	}

	public State getcState() {
		return cState;
	}

	public void setcState(State cState) {
		this.cState = cState;
	}

	public City getcCity() {
		return cCity;
	}

	public void setcCity(City cCity) {
		this.cCity = cCity;
	}

	public String getcPin() {
		return cPin;
	}

	public void setcPin(String cPin) {
		this.cPin = cPin;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrTypeOfDeductor() {
		return rTypeOfDeductor;
	}

	public void setrTypeOfDeductor(String rTypeOfDeductor) {
		this.rTypeOfDeductor = rTypeOfDeductor;
	}

	public String getrBranch() {
		return rBranch;
	}

	public void setrBranch(String rBranch) {
		this.rBranch = rBranch;
	}

	public String getrExciseDivision() {
		return rExciseDivision;
	}

	public void setrExciseDivision(String rExciseDivision) {
		this.rExciseDivision = rExciseDivision;
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

	public State getrState() {
		return rState;
	}

	public void setrState(State rState) {
		this.rState = rState;
	}

	public City getrCity() {
		return rCity;
	}

	public void setrCity(City rCity) {
		this.rCity = rCity;
	}

	public String getrLocation() {
		return rLocation;
	}

	public void setrLocation(String rLocation) {
		this.rLocation = rLocation;
	}

	public String getrPin() {
		return rPin;
	}

	public void setrPin(String rPin) {
		this.rPin = rPin;
	}

	public String getrStd() {
		return rStd;
	}

	public void setrStd(String rStd) {
		this.rStd = rStd;
	}

	public Long getrTel() {
		return rTel;
	}

	public void setrTel(Long rTel) {
		this.rTel = rTel;
	}

	public String getrEmail() {
		return rEmail;
	}

	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}

	public String getParentCCode() {
		return parentCCode;
	}

	public void setParentCCode(String parentCCode) {
		this.parentCCode = parentCCode;
	}


	public String gettGstNo() {
		return tGstNo;
	}

	public void settGstNo(String tGstNo) {
		this.tGstNo = tGstNo;
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

	public Date gettFillingDate() {
		return tFillingDate;
	}

	public void settFillingDate(Date tFillingDate) {
		this.tFillingDate = tFillingDate;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getTdGstNumber() {
		return tdGstNumber;
	}

	public void setTdGstNumber(String tdGstNumber) {
		this.tdGstNumber = tdGstNumber;
	}

	public String getTdTaxPayerLegalName() {
		return tdTaxPayerLegalName;
	}

	public void setTdTaxPayerLegalName(String tdTaxPayerLegalName) {
		this.tdTaxPayerLegalName = tdTaxPayerLegalName;
	}

	public String getTdTaxPayerTradeName() {
		return tdTaxPayerTradeName;
	}

	public void setTdTaxPayerTradeName(String tdTaxPayerTradeName) {
		this.tdTaxPayerTradeName = tdTaxPayerTradeName;
	}

	public Date getTdFillingDate() {
		return tdFillingDate;
	}

	public void setTdFillingDate(Date tdFillingDate) {
		this.tdFillingDate = tdFillingDate;
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

	public String getRcmcNo() {
		return rcmcNo;
	}

	public void setRcmcNo(String rcmcNo) {
		this.rcmcNo = rcmcNo;
	}

	public String getExpPerformance() {
		return expPerformance;
	}

	public void setExpPerformance(String expPerformance) {
		this.expPerformance = expPerformance;
	}

	public String getExpCertiificateNo() {
		return expCertiificateNo;
	}

	public void setExpCertiificateNo(String expCertiificateNo) {
		this.expCertiificateNo = expCertiificateNo;
	}

	public String getEccNumber() {
		return eccNumber;
	}

	public void setEccNumber(String eccNumber) {
		this.eccNumber = eccNumber;
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

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getEsiCe() {
		return esiCe;
	}

	public void setEsiCe(String esiCe) {
		this.esiCe = esiCe;
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

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
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

	public void setSiteOffice(List<SiteOffice> siteOffice) {
		this.siteOffice = siteOffice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegnNO() {
		return regnNO;
	}

	public void setRegnNO(String regnNO) {
		this.regnNO = regnNO;
	}
	
	


}
