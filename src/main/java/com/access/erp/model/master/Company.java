package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




/*@Entity
@Table(name="COMPANY_MASTER")*/
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



	
}
