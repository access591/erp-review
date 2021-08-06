package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name = "EMPLOYEE_MASTER")*/
public class Employee {
	
	
	@Id
	@Column(name = "EMP_CODE", length = 50)
	private String empCode;
	
	@Column(name = "DEPT_CODE", length = 50)
	private String deptCode;
	
	@Column(name = "EMP_NAME", length = 100)
	private String empName;
	
	@Column(name = "EMP_TYPE", length = 20)
	private char empType;
	
	@Column(name = "BIRTH_PLACE", length = 50)
	private String birthPlace;
	
	@Column(name = "SEC", length = 20)
	private String sex;
	
	@Column(name = "MARITAL_STATUS", length = 20)
	private char maritalStatus;
	
	@Column(name = "HEIGHT", length = 50)
	private int height;
	
	@Column(name = "ID_MARK", length = 50)
	private String idMark;
	
	@Column(name = "DESIG_CODE", length = 50)
	private String desigCode;
	
	@Column(name = "CASTE", length = 50)
	private String caste;
	
	@Column(name = "PERM_ADD1", length = 150)
	private String permAdd1;
	
	@Column(name = "PERM_ADD2", length = 150)
	private String permAdd2;
	
	@Column(name = "PERM_CITY", length = 100)
	private String permCity;
	
	@Column(name = "PERM_STATE", length = 100)
	private String permState;
	
	@Column(name = "PERM_PIN", length = 20)
	private int permPin;
	
	@Column(name = "LOCAL_ADD1", length = 150)
	private String localAdd1;
	
	@Column(name = "LOCAL_ADD2", length = 150)
	private String localAdd2;
	
	@Column(name = "LOCAL_CITY", length = 100)
	private String localCity;
	
	@Column(name = "LOCAL_STATE", length = 100)
	private String localState;
	
	@Column(name = "LOCAL_PIN", length = 20)
	private int localPin;
	
	@Column(name = "LOCAL_PHONE", length = 50)
	private String localPhone;
	
	@Column(name = "ACTIVE", length = 10)
	private String active;
	
	@Column(name = "STATUS_DATE")
	private Date statusDate;
	
	@Column(name = "MOBILE_PHONE", length = 50)
	private String mobilePhone;
	
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;
	
	@Column(name = "DATE_OF_JOINING")
	private Date doj;
	
	@Column(name = "IT_PAN_NUMBER", length = 50)
	private String itPanNumber;
	
	@Column(name = "COM_CODE", length = 50)
	private String compCode;
	
	@Column(name = "EMP_IMG", length = 150)
	private String empImage;
	
	@Column(name = "CARD_NUMBER", length = 100)
	private String cardNumber;
	
	@Column(name = "BLOOD_GROUP", length = 20)
	private String bloodGroup;
	
	@Column(name = "EMAIL", length = 50)
	private String email;
	
	@Column(name = "HOBBIES", length = 150)
	private String hobbies;
	
	@Column(name = "BIRTH_STATE", length = 50)
	private String birthstate;
	
	@Column(name = "CLUB", length = 50)
	private String club;
	
	@Column(name = "PROFINST", length = 50)
	private String profInst;
	
	@Column(name = "INS_COMP_CODE", length = 50)
	private String insCompCode;
	
	@Column(name = "PRE_DISEASE", length = 50)
	private String preDisease;
	
	@Column(name = "INS_MEDI", length = 50)
	private String insMedi;
	
	@Column(name = "INS_GPA", length = 50)
	private String insGpa;
	
	@Column(name = "LOC_TYPE", length = 50)
	private String locType;
	
	@Column(name = "LOCATION", length = 50)
	private String location;
	
	@Column(name = "SITE_COMP_CODE", length = 50)
	private String siteCompCode;
	
	@Column(name = "REMARKS", length = 50)
	private String remarks;
	
	@Column(name = "LTA_RATE", length = 50)
	private String ltaRate;
	
	@Column(name = "WEEKLY_WORK_DAYS", length = 20)
	private String weeklyWorkDays;
	
	@Column(name = "ACT_LEAVING_DATE")
	private Date actLeavingDate;
	
	@Column(name = "RESIG_dATE")
	private Date resigDate;
	
	@Column(name = "ESTF_WRK", length = 50)
	private String estfWrk;
	
	@Column(name = "EMP_CAT", length = 50)
	private String empCat;
	
	@Column(name = "E_CATEGORY", length = 50)
	private String eCategory;
	
	@Column(name = "REG_CODE", length = 50)
	private String regCode;
	
	@Column(name = "REST_DAY1", length = 20)
	private int restDay1;
	
	@Column(name = "REST_DAY2", length = 20)
	private int restDay2;
	
	@Column(name = "EMAIL_PASS", length = 50)
	private String emailPass;
	
	@Column(name = "GRADE_CODE", length = 50)
	private String gradeCode;
	
	@Column(name = "RETIREMENT_DATE")
	private Date retirementDate;
	
	@Column(name = "UAN_NUMBER", length = 50)
	private String uanNumber;
	
	@Column(name = "EFFECT_DATE")
	private Date effectDate;
	
	@Column(name = "DL_NUMBER", length = 100)
	private String dlNumber;
	
	@Column(name = "D_VALID_DATE")
	private Date dlValidDate;
	
	@Column(name = "PASSPORT_VALID_DATE")
	private Date passportValidDate;
	
	@Column(name = "AADHAR_CARD_NUMBER", length = 80)
	private String adharCardNumber;
	
	@Column(name = "LAST_WORK_DAY", length = 20)
	private Date lastWorkDay;
	
	@Column(name = "SKILS_TYPE", length = 50)
	private String skilsType;
	
	@Column(name = "TECH_TYPE", length = 50)
	private String techType;
	
	@Column(name = "OFFER_LEFT_DATE")
	private Date offerLeftDate;
	
	@Column(name = "OFFER_LEFT_NUMBER", length = 50)
	private String offerLeftNumber;

}
