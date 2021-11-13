package com.access.erp.model.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="M_PARTY")
public class PartyMaster {

	@Id
	@Column(name="PARTY_CODE",length=50)
	private String partyCode;
	
	@Column(name="PARTY_NAME",length=100)
	private String partyName;
	
	@Column(name="CUST_TYPE",length=8)
	private String custType;
	
	@Column(name="PTHRUCODE",length=50)
	private String pthruCode;
		
	@Column(name="REP_CODE",length=8)
	private String repCode;
		
	@Column(name="PIN_CODE",length=6)
	private String pinCode;
	
	@Column(name="PARTY_FAX",length=50)
	private String partyFax;
	
	@Column(name="PARTY_EMAIL",length=100)
	private String partyEmail;
	
	@Column(name="PARTY_ADDR1",length=200)
	private String partyAddr1;
	
	@Column(name="PARTY_ADDR2",length=50)
	private String partyAddr2;
		
	@Column(name="PARTY_ADDR3",length=50)
	private String partyAddr3;
	
		
	@Column(name="PARTY_WEBSITE",length=60)
	private String partyWebsite;
	
	@Column(name="CITY_CODE",length=8)
	private String cityCode;
	
	@Column(name="STATE_CODE",length=6)
	private String stateCode;
	
	@Column(name="COUNTRY_CODE",length=6)
	private String countryCode;
	
	
	
	
	@Column(name="REG_ADDR1",length=50)
	private String regAddr1;
	
	@Column(name="REG_ADDR2",length=50)
	private String regAddr2;
		
	@Column(name="REG_ADDR3",length=50)
	private String regAddr3;
	
	
	@Column(name="REG_ADDR_CITY_CODE",length=8)
	private String regAddrCityCode;
		
	@Column(name="REG_ADDR_STATE_CODE",length=8)
	private String regAddrStateCode;
	
	@Column(name="REG_ADDR_CNT_CODE",length=8)
	private String regAddrCntCode;
	
	
	
	
	@Column(name="LCL_ADDR1",length=50)
	private String lclAddr1;
	
	@Column(name="LCL_ADDR2",length=50)
	private String lclAddr2;
		
	@Column(name="LCL_ADDR3",length=50)
	private String lclAddr3;
	
	
	@Column(name="LCL_ADDR_CITY_CODE",length=10)
	private String lclAddrCityCode;
	
	@Column(name="LCL_ADDR_STATE_CODE",length=10)
	private String lclAddrStateCode;
		
	
	@Column(name="LCL_ADDR_CNT_CODE",length=10)
	private String lclAddrCntCode;
	
	
	
	@Column(name="GST_CUST_TYPE",length=5)
	private String gstCustType;
	
	@Column(name="PARTY_PANNO",length=20)
	private String partyPanno;
	
	
	@Column(name="GST_NO",length=15)
	private String gstNo;
	
	@Column(name="CREDIT_PERIOD",length=50)
	private String creditPeriod;
	
	@Column(name="CREDIT_AMOUNT",length=15)
	private String creditAmount;
	
	@Column(name="TAXPAYER_LEGAL_NAME",length=100)
	private String taxpayerLegalName;
		
	@Column(name="TAXPAYER_TRADE_NAME",length=100)
	private String taxpayerTradeName;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="FILLING_DATE")
	private String fillingDate;
	
	@Column(name="PARTY_TYP_CODE",length=50)
	private String partyTypCode;
		
	@Column(name="STATUS_CUST",length=50)
	private String statusCust;
	
	
	
	
	
	
	
		
	
	
	
	
	
		
	
		
	
		
	
	
	
		
	@Column(name="PARTY_CONP",length=40)
	private String partyConp;
		
	@Column(name="BILL_NAME",length=30)
	private String billName;
	
	@Column(name="BILL_ADDR1",length=30)
	private String billAddr1;
		
	@Column(name="BILL_ADDR2",length=30)
	private String billAddr2;
		
	@Column(name="BILL_ADDR3",length=8)
	private String billAddr3;
		
	@Column(name="BILL_CITY_CODE",length=8)
	private String billCityCode;
		
	@Column(name="BILL_STATE_CODE",length=8)
	private String billStateCode;
	
	@Column(name="BILL_COUNTRY_CODE",length=8)
	private String billCountryCode;
	
	@Column(name="BILL_CURRENCY_CODE",length=50)
	private String billCurrencyCode;
	
	@Column(name="PARTY_BANK",length=30)
	private String partyBank;
		
	@Column(name="PARTY_BK_BRANCH",length=50)
	private String partyBkBranch;
		
	@Column(name="PARTY_BK_ADDR1",length=50)
	private String partyBkAddr1;
		
	@Column(name="PARTY_BK_ADDR2",length=50)
	private String partyBkAddr2;
	
	@Column(name="PARTY_BK_ADDR3",length=30)
	private String partyBkAddr3;
		
	@Column(name="PARTY_BK_CITY_CODE",length=8)
	private String partyBkCityCode;
		
	@Column(name="PARTY_BK_STATE_CODE",length=8)
	private String partyBkStateCode;
		
	@Column(name="PARTY_BK_COUNTRY_CODE",length=8)
	private String partyBkCountryCode;
		
	@Column(name="SHP_METHOD_CODE",length=8)
	private String shpMethodCode;
	
	@Column(name="SHP_AGENT_CODE",length=8)
	private String shpAgentCode;
	
	@Column(name="VAT_NO",length=50)
	private String vatNo;
	
	@Column(name="TIN_NO",length=20)
	private String tinNo;
		
	
		
	@Column(name="PARTY_CSTNO",length=20)
	private String partyCstno;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="PARTY_CSTDATE")
	private Date partyCstDate;
	
	@Column(name="PARTY_SSTNO",length=50)
	private String partySstNo;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="PARTY_SSTDATE")
	private Date partySstDate;
		
	/*
	 * @Column(name="PARTY_CSTRATE",length=10) private int partyCstRate;
	 * 
	 * @Column(name="PARTY_STRATE",length=10) private int partyStrate;
	 * 
	 * @Column(name="PARTY_SCRATE",length=10) private int partyScrate;
	 */
	
	@Column(name="PARTY_ECCNO",length=15)
	private String partEccno;
	
	
	
	@Column(name="PARTY_BDISC",length=12)
	private String partyBdisc;
	
	@Column(name="PARTY_SPLDISC",length=12)
	private String partySplDisc;
		
	@Column(name="CD_CODE",length=50)
	private String cdCode;
		
	
	@Column(name="BLOCKED",length=5)
	private String blocked;
		
	@Column(name="PARTY_PHONE",length=50)
	private String partyPhone;
	
	@Column(name="BRANCH",length=50)
	private String branch;
		
	@Column(name="ECC_NO",length=100)
	private String eccNo;
		
	@Column(name="EXCISE_DIVISION",length=100)
	private String exciseDivision;
		
	@Column(name="COMMISSIONORATE",length=100)
	private String commissionrate;
		
	@Column(name="RANGE_SUPTT_OF_CENT_EXCISE",length=500)
	private String rangeSuptOfCentExcise;
	
	
	@Column(name="ADDRESS_SUPTT_CENT_EXCISE",length=500)
	private String addressSuptCentExcise;
	
	@Column(name="ADDR_ASST_DEPUTY_COMMRATE",length=50)
	private String addrAsstDeputyCommrate;
		
	@Column(name="CENTRAL_EXCISE_REGION_NO",length=5)
	private String centralExciseRegionNo;
		
	@Column(name="DEALER_TYPE",length=5)
	private String dealerType;
		
	@Column(name="CCODE",length=10)
	private String cCode;
	
	@Column(name="PARTY_TYPE",length=5)
	private String partType;
		
	
		
	@Column(name="MD_NAME",length=50)
	private String mdName;
	
	
	
		
	
	
		
	
		
	
	
	
	
		
	@Column(name="PARTY_CONTP_PH",length=20)
	private String partyContpPh;
	
	
	@Column(name="PARTY_BANK_ACC_NO",length=50)
	private String partyBankAccNo;
	
	@Column(name="BASE_CODE",length=20)
	private String baseCode;
		
	
	
	@Column(name="ZONE_CODE",length=10)
	private String zoneCode;
		
	@Column(name="COMMISSION_RATE",length=8)
	private String commissionRate;
		
	@Column(name="MNC_STATUS",length=5)
	private String mncState;
	
	@Column(name="DRUG_LICENCE_NO",length=30)
	private String drugLicenceNo;
		
	@Column(name="SUB_PARTY_TYPE",length=5)
	private String subPartyType;
		
	@Column(name="SWIFT_ADDRESS",length=50)
	private String swiftAddress;
		
	@Column(name="AGENT_CODE",length=20)
	private String agentCode;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TIN_DT")
	private Date tinDate;
		
	
	@Column(name="SUPP_APPROVAL_STATUS",length=5)
	private String suppApprovalStatus;
		
	@Column(name="FORM_CODE",length=5)
	private String fromCode;
	
	@Column(name="CUSTOMER_CODE",length=15)
	private String customerCode;
	
	@Column(name="PARTY_EXCISE_NAME",length=200)
	private String partyExciseName;
		
	@Column(name="PARTY_MOB_NO",length=20)
	private String partyMobNo;
		
	@Column(name="EXP_REF",length=20)
	private String expRef;
		
	@Column(name="INST_RS",length=15)
	private String instRs;
	
	@Column(name="INST_RATE",length=10)
	private String instRate;
		
	@Column(name="FILE_NO",length=100)
	private String fileNo;
		
	@Column(name="IMP_CODE",length=30)
	private String impCode;
		
	
	
	
	
	
	
	
	
	
	
	@Column(name="PAYMENT_TYPE",length=5)
	private String paymentType;
		
	
	@Column(name="IMPORTER",length=5)
	private String importer;
		
	@Column(name="TCS",length=8)
	private String tcs;
		
	@Column(name="SC_TCS",length=8)
	private String scTcs;
	
	@Column(name="EDU_TCS",length=8)
	private String eduTcs;
	
	
		
	@Column(name="HR_EDU_TCS",length=8)
	private String hrEduTcs;
		
	@Column(name="REGISTERED_YN",length=5)
	private String registerdYn;
		
	@Column(name="VENDOR_CODE",length=30)
	private String vendorCode;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="LST_DATE")
	private Date lstDate;
		
	@Column(name="LST_NO",length=50)
	private String lstNo;
		
	@Column(name="BRAND",length=100)
	private String brand;
		
	
	
	
	@Column(name="GST_REGISTERED",length=5)
	private String gstRegistered;
		
	@Column(name="REGISTER_ID",length=5)
	private String registerId;
	
	@OneToMany(mappedBy = "partyMaster", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	List<PartyBilling> listPartyBilling = new ArrayList<>();
	
	@OneToMany(mappedBy = "partyMaster", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	List<PartyConsignee> listPartyConsignee = new ArrayList<>();

	public PartyMaster() {
		super();
		
	}

	public String getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partName) {
		this.partyName = partName;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getPthruCode() {
		return pthruCode;
	}

	public void setPthruCode(String pthruCode) {
		this.pthruCode = pthruCode;
	}

	public String getRepCode() {
		return repCode;
	}

	public void setRepCode(String repCode) {
		this.repCode = repCode;
	}

	public String getPartyAddr1() {
		return partyAddr1;
	}

	public void setPartyAddr1(String partyAddr1) {
		this.partyAddr1 = partyAddr1;
	}

	public String getPartyAddr2() {
		return partyAddr2;
	}

	public void setPartyAddr2(String partyAddr2) {
		this.partyAddr2 = partyAddr2;
	}

	public String getPartyAddr3() {
		return partyAddr3;
	}

	public void setPartyAddr3(String partyAddr3) {
		this.partyAddr3 = partyAddr3;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPartyFax() {
		return partyFax;
	}

	public void setPartyFax(String partyFax) {
		this.partyFax = partyFax;
	}

	public String getPartyEmail() {
		return partyEmail;
	}

	public void setPartyEmail(String partyEmail) {
		this.partyEmail = partyEmail;
	}

	public String getPartyWebsite() {
		return partyWebsite;
	}

	public void setPartyWebsite(String partyWebsite) {
		this.partyWebsite = partyWebsite;
	}

	public String getPartyConp() {
		return partyConp;
	}

	public void setPartyConp(String partyConp) {
		this.partyConp = partyConp;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public String getBillAddr1() {
		return billAddr1;
	}

	public void setBillAddr1(String billAddr1) {
		this.billAddr1 = billAddr1;
	}

	public String getBillAddr2() {
		return billAddr2;
	}

	public void setBillAddr2(String billAddr2) {
		this.billAddr2 = billAddr2;
	}

	public String getBillAddr3() {
		return billAddr3;
	}

	public void setBillAddr3(String billAddr3) {
		this.billAddr3 = billAddr3;
	}

	public String getBillCityCode() {
		return billCityCode;
	}

	public void setBillCityCode(String billCityCode) {
		this.billCityCode = billCityCode;
	}

	public String getBillStateCode() {
		return billStateCode;
	}

	public void setBillStateCode(String billStateCode) {
		this.billStateCode = billStateCode;
	}

	public String getBillCountryCode() {
		return billCountryCode;
	}

	public void setBillCountryCode(String billCountryCode) {
		this.billCountryCode = billCountryCode;
	}

	public String getBillCurrencyCode() {
		return billCurrencyCode;
	}

	public void setBillCurrencyCode(String billCurrencyCode) {
		this.billCurrencyCode = billCurrencyCode;
	}

	public String getPartyBank() {
		return partyBank;
	}

	public void setPartyBank(String partyBank) {
		this.partyBank = partyBank;
	}

	public String getPartyBkBranch() {
		return partyBkBranch;
	}

	public void setPartyBkBranch(String partyBkBranch) {
		this.partyBkBranch = partyBkBranch;
	}

	public String getPartyBkAddr1() {
		return partyBkAddr1;
	}

	public void setPartyBkAddr1(String partyBkAddr1) {
		this.partyBkAddr1 = partyBkAddr1;
	}

	public String getPartyBkAddr2() {
		return partyBkAddr2;
	}

	public void setPartyBkAddr2(String partyBkAddr2) {
		this.partyBkAddr2 = partyBkAddr2;
	}

	public String getPartyBkAddr3() {
		return partyBkAddr3;
	}

	public void setPartyBkAddr3(String partyBkAddr3) {
		this.partyBkAddr3 = partyBkAddr3;
	}

	public String getPartyBkCityCode() {
		return partyBkCityCode;
	}

	public void setPartyBkCityCode(String partyBkCityCode) {
		this.partyBkCityCode = partyBkCityCode;
	}

	public String getPartyBkStateCode() {
		return partyBkStateCode;
	}

	public void setPartyBkStateCode(String partyBkStateCode) {
		this.partyBkStateCode = partyBkStateCode;
	}

	public String getPartyBkCountryCode() {
		return partyBkCountryCode;
	}

	public void setPartyBkCountryCode(String partyBkCountryCode) {
		this.partyBkCountryCode = partyBkCountryCode;
	}

	public String getShpMethodCode() {
		return shpMethodCode;
	}

	public void setShpMethodCode(String shpMethodCode) {
		this.shpMethodCode = shpMethodCode;
	}

	public String getShpAgentCode() {
		return shpAgentCode;
	}

	public void setShpAgentCode(String shpAgentCode) {
		this.shpAgentCode = shpAgentCode;
	}

	public String getVatNo() {
		return vatNo;
	}

	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getPartyPanno() {
		return partyPanno;
	}

	public void setPartyPanno(String partyPanno) {
		this.partyPanno = partyPanno;
	}

	public String getPartyCstno() {
		return partyCstno;
	}

	public void setPartyCstno(String partyCstno) {
		this.partyCstno = partyCstno;
	}

	

	public String getPartySstNo() {
		return partySstNo;
	}

	public void setPartySstNo(String partySstNo) {
		this.partySstNo = partySstNo;
	}


	public String getPartEccno() {
		return partEccno;
	}

	public void setPartEccno(String partEccno) {
		this.partEccno = partEccno;
	}

	public String getPartyBdisc() {
		return partyBdisc;
	}

	public void setPartyBdisc(String partyBdisc) {
		this.partyBdisc = partyBdisc;
	}

	public String getPartySplDisc() {
		return partySplDisc;
	}

	public void setPartySplDisc(String partySplDisc) {
		this.partySplDisc = partySplDisc;
	}

	public String getCdCode() {
		return cdCode;
	}

	public void setCdCode(String cdCode) {
		this.cdCode = cdCode;
	}

	public String getBlocked() {
		return blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	public String getPartyPhone() {
		return partyPhone;
	}

	public void setPartyPhone(String partyPhone) {
		this.partyPhone = partyPhone;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEccNo() {
		return eccNo;
	}

	public void setEccNo(String eccNo) {
		this.eccNo = eccNo;
	}

	public String getExciseDivision() {
		return exciseDivision;
	}

	public void setExciseDivision(String exciseDivision) {
		this.exciseDivision = exciseDivision;
	}

	public String getCommissionrate() {
		return commissionrate;
	}

	public void setCommissionrate(String commissionrate) {
		this.commissionrate = commissionrate;
	}

	public String getRangeSuptOfCentExcise() {
		return rangeSuptOfCentExcise;
	}

	public void setRangeSuptOfCentExcise(String rangeSuptOfCentExcise) {
		this.rangeSuptOfCentExcise = rangeSuptOfCentExcise;
	}

	public String getAddressSuptCentExcise() {
		return addressSuptCentExcise;
	}

	public void setAddressSuptCentExcise(String addressSuptCentExcise) {
		this.addressSuptCentExcise = addressSuptCentExcise;
	}

	public String getAddrAsstDeputyCommrate() {
		return addrAsstDeputyCommrate;
	}

	public void setAddrAsstDeputyCommrate(String addrAsstDeputyCommrate) {
		this.addrAsstDeputyCommrate = addrAsstDeputyCommrate;
	}

	public String getCentralExciseRegionNo() {
		return centralExciseRegionNo;
	}

	public void setCentralExciseRegionNo(String centralExciseRegionNo) {
		this.centralExciseRegionNo = centralExciseRegionNo;
	}

	public String getDealerType() {
		return dealerType;
	}

	public void setDealerType(String dealerType) {
		this.dealerType = dealerType;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getCreditPeriod() {
		return creditPeriod;
	}

	public void setCreditPeriod(String creditPeriod) {
		this.creditPeriod = creditPeriod;
	}

	public String getPartyTypCode() {
		return partyTypCode;
	}

	public void setPartyTypCode(String partyTypCode) {
		this.partyTypCode = partyTypCode;
	}

	public String getStatusCust() {
		return statusCust;
	}

	public void setStatusCust(String statusCust) {
		this.statusCust = statusCust;
	}

	public String getMdName() {
		return mdName;
	}

	public void setMdName(String mdName) {
		this.mdName = mdName;
	}

	public String getRegAddr1() {
		return regAddr1;
	}

	public void setRegAddr1(String regAddr1) {
		this.regAddr1 = regAddr1;
	}

	public String getRegAddr2() {
		return regAddr2;
	}

	public void setRegAddr2(String regAddr2) {
		this.regAddr2 = regAddr2;
	}

	public String getRegAddr3() {
		return regAddr3;
	}

	public void setRegAddr3(String regAddr3) {
		this.regAddr3 = regAddr3;
	}

	public String getRegAddrCityCode() {
		return regAddrCityCode;
	}

	public void setRegAddrCityCode(String regAddrCityCode) {
		this.regAddrCityCode = regAddrCityCode;
	}

	public String getRegAddrStateCode() {
		return regAddrStateCode;
	}

	public void setRegAddrStateCode(String regAddrStateCode) {
		this.regAddrStateCode = regAddrStateCode;
	}

	public String getRegAddrCntCode() {
		return regAddrCntCode;
	}

	public void setRegAddrCntCode(String regAddrCntCode) {
		this.regAddrCntCode = regAddrCntCode;
	}

	public String getLclAddr1() {
		return lclAddr1;
	}

	public void setLclAddr1(String lclAddr1) {
		this.lclAddr1 = lclAddr1;
	}

	public String getLclAddr2() {
		return lclAddr2;
	}

	public void setLclAddr2(String lclAddr2) {
		this.lclAddr2 = lclAddr2;
	}

	public String getLclAddr3() {
		return lclAddr3;
	}

	public void setLclAddr3(String lclAddr3) {
		this.lclAddr3 = lclAddr3;
	}

	public String getLclAddrCityCode() {
		return lclAddrCityCode;
	}

	public void setLclAddrCityCode(String lclAddrCityCode) {
		this.lclAddrCityCode = lclAddrCityCode;
	}

	public String getLclAddrStateCode() {
		return lclAddrStateCode;
	}

	public void setLclAddrStateCode(String lclAddrStateCode) {
		this.lclAddrStateCode = lclAddrStateCode;
	}

	public String getLclAddrCntCode() {
		return lclAddrCntCode;
	}

	public void setLclAddrCntCode(String lclAddrCntCode) {
		this.lclAddrCntCode = lclAddrCntCode;
	}

	public String getPartyContpPh() {
		return partyContpPh;
	}

	public void setPartyContpPh(String partyContpPh) {
		this.partyContpPh = partyContpPh;
	}

	public String getPartyBankAccNo() {
		return partyBankAccNo;
	}

	public void setPartyBankAccNo(String partyBankAccNo) {
		this.partyBankAccNo = partyBankAccNo;
	}

	public String getBaseCode() {
		return baseCode;
	}

	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}

	public String getMncState() {
		return mncState;
	}

	public void setMncState(String mncState) {
		this.mncState = mncState;
	}

	public String getDrugLicenceNo() {
		return drugLicenceNo;
	}

	public void setDrugLicenceNo(String drugLicenceNo) {
		this.drugLicenceNo = drugLicenceNo;
	}

	public String getSubPartyType() {
		return subPartyType;
	}

	public void setSubPartyType(String subPartyType) {
		this.subPartyType = subPartyType;
	}

	public String getSwiftAddress() {
		return swiftAddress;
	}

	public void setSwiftAddress(String swiftAddress) {
		this.swiftAddress = swiftAddress;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	

	public String getSuppApprovalStatus() {
		return suppApprovalStatus;
	}

	public void setSuppApprovalStatus(String suppApprovalStatus) {
		this.suppApprovalStatus = suppApprovalStatus;
	}

	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getPartyExciseName() {
		return partyExciseName;
	}

	public void setPartyExciseName(String partyExciseName) {
		this.partyExciseName = partyExciseName;
	}

	public String getPartyMobNo() {
		return partyMobNo;
	}

	public void setPartyMobNo(String partyMobNo) {
		this.partyMobNo = partyMobNo;
	}

	public String getExpRef() {
		return expRef;
	}

	public void setExpRef(String expRef) {
		this.expRef = expRef;
	}

	public String getInstRs() {
		return instRs;
	}

	public void setInstRs(String instRs) {
		this.instRs = instRs;
	}

	public String getInstRate() {
		return instRate;
	}

	public void setInstRate(String instRate) {
		this.instRate = instRate;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getImpCode() {
		return impCode;
	}

	public void setImpCode(String impCode) {
		this.impCode = impCode;
	}

	public String getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getImporter() {
		return importer;
	}

	public void setImporter(String importer) {
		this.importer = importer;
	}

	public String getTcs() {
		return tcs;
	}

	public void setTcs(String tcs) {
		this.tcs = tcs;
	}

	public String getScTcs() {
		return scTcs;
	}

	public void setScTcs(String scTcs) {
		this.scTcs = scTcs;
	}

	public String getEduTcs() {
		return eduTcs;
	}

	public void setEduTcs(String eduTcs) {
		this.eduTcs = eduTcs;
	}

	public String getHrEduTcs() {
		return hrEduTcs;
	}

	public void setHrEduTcs(String hrEduTcs) {
		this.hrEduTcs = hrEduTcs;
	}

	public String getRegisterdYn() {
		return registerdYn;
	}

	public void setRegisterdYn(String registerdYn) {
		this.registerdYn = registerdYn;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}


	public String getLstNo() {
		return lstNo;
	}

	public void setLstNo(String lstNo) {
		this.lstNo = lstNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getTaxpayerLegalName() {
		return taxpayerLegalName;
	}

	public void setTaxpayerLegalName(String taxpayerLegalName) {
		this.taxpayerLegalName = taxpayerLegalName;
	}

	public String getTaxpayerTradeName() {
		return taxpayerTradeName;
	}

	public void setTaxpayerTradeName(String taxpayerTradeName) {
		this.taxpayerTradeName = taxpayerTradeName;
	}

	public String getFillingDate() {
		return fillingDate;
	}

	public void setFillingDate(String fillingDate) {
		this.fillingDate = fillingDate;
	}

	public String getGstCustType() {
		return gstCustType;
	}

	public void setGstCustType(String gstCustType) {
		this.gstCustType = gstCustType;
	}

	public String getGstRegistered() {
		return gstRegistered;
	}

	public void setGstRegistered(String gstRegistered) {
		this.gstRegistered = gstRegistered;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public List<PartyBilling> getListPartyBilling() {
		return listPartyBilling;
	}

	public void setListPartyBilling(List<PartyBilling> listPartyBilling) {
		this.listPartyBilling = listPartyBilling;
	}

	public List<PartyConsignee> getListPartyConsignee() {
		return listPartyConsignee;
	}

	public void setListPartyConsignee(List<PartyConsignee> listPartyConsignee) {
		this.listPartyConsignee = listPartyConsignee;
	}

	public Date getPartyCstDate() {
		return partyCstDate;
	}

	public void setPartyCstDate(Date partyCstDate) {
		this.partyCstDate = partyCstDate;
	}

	public Date getPartySstDate() {
		return partySstDate;
	}

	public void setPartySstDate(Date partySstDate) {
		this.partySstDate = partySstDate;
	}

	public Date getTinDate() {
		return tinDate;
	}

	public void setTinDate(Date tinDate) {
		this.tinDate = tinDate;
	}

	public Date getLstDate() {
		return lstDate;
	}

	public void setLstDate(Date lstDate) {
		this.lstDate = lstDate;
	}
	
	
	
	
}
