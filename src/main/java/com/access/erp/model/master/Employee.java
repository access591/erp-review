package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_MASTER")
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
	
	@ManyToOne
	@JoinColumn(name = "DESIG_CODE")
	private Designation designation;
	
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
	
	@OneToOne(mappedBy = "employee" ,cascade = CascadeType.ALL)
	private MyUser myUser;

	public Employee() {
		super();
		
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public char getEmpType() {
		return empType;
	}

	public void setEmpType(char empType) {
		this.empType = empType;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public char getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getIdMark() {
		return idMark;
	}

	public void setIdMark(String idMark) {
		this.idMark = idMark;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getPermAdd1() {
		return permAdd1;
	}

	public void setPermAdd1(String permAdd1) {
		this.permAdd1 = permAdd1;
	}

	public String getPermAdd2() {
		return permAdd2;
	}

	public void setPermAdd2(String permAdd2) {
		this.permAdd2 = permAdd2;
	}

	public String getPermCity() {
		return permCity;
	}

	public void setPermCity(String permCity) {
		this.permCity = permCity;
	}

	public String getPermState() {
		return permState;
	}

	public void setPermState(String permState) {
		this.permState = permState;
	}

	public int getPermPin() {
		return permPin;
	}

	public void setPermPin(int permPin) {
		this.permPin = permPin;
	}

	public String getLocalAdd1() {
		return localAdd1;
	}

	public void setLocalAdd1(String localAdd1) {
		this.localAdd1 = localAdd1;
	}

	public String getLocalAdd2() {
		return localAdd2;
	}

	public void setLocalAdd2(String localAdd2) {
		this.localAdd2 = localAdd2;
	}

	public String getLocalCity() {
		return localCity;
	}

	public void setLocalCity(String localCity) {
		this.localCity = localCity;
	}

	public String getLocalState() {
		return localState;
	}

	public void setLocalState(String localState) {
		this.localState = localState;
	}

	public int getLocalPin() {
		return localPin;
	}

	public void setLocalPin(int localPin) {
		this.localPin = localPin;
	}

	public String getLocalPhone() {
		return localPhone;
	}

	public void setLocalPhone(String localPhone) {
		this.localPhone = localPhone;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getItPanNumber() {
		return itPanNumber;
	}

	public void setItPanNumber(String itPanNumber) {
		this.itPanNumber = itPanNumber;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getEmpImage() {
		return empImage;
	}

	public void setEmpImage(String empImage) {
		this.empImage = empImage;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getBirthstate() {
		return birthstate;
	}

	public void setBirthstate(String birthstate) {
		this.birthstate = birthstate;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getProfInst() {
		return profInst;
	}

	public void setProfInst(String profInst) {
		this.profInst = profInst;
	}

	public String getInsCompCode() {
		return insCompCode;
	}

	public void setInsCompCode(String insCompCode) {
		this.insCompCode = insCompCode;
	}

	public String getPreDisease() {
		return preDisease;
	}

	public void setPreDisease(String preDisease) {
		this.preDisease = preDisease;
	}

	public String getInsMedi() {
		return insMedi;
	}

	public void setInsMedi(String insMedi) {
		this.insMedi = insMedi;
	}

	public String getInsGpa() {
		return insGpa;
	}

	public void setInsGpa(String insGpa) {
		this.insGpa = insGpa;
	}

	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSiteCompCode() {
		return siteCompCode;
	}

	public void setSiteCompCode(String siteCompCode) {
		this.siteCompCode = siteCompCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLtaRate() {
		return ltaRate;
	}

	public void setLtaRate(String ltaRate) {
		this.ltaRate = ltaRate;
	}

	public String getWeeklyWorkDays() {
		return weeklyWorkDays;
	}

	public void setWeeklyWorkDays(String weeklyWorkDays) {
		this.weeklyWorkDays = weeklyWorkDays;
	}

	public Date getActLeavingDate() {
		return actLeavingDate;
	}

	public void setActLeavingDate(Date actLeavingDate) {
		this.actLeavingDate = actLeavingDate;
	}

	public Date getResigDate() {
		return resigDate;
	}

	public void setResigDate(Date resigDate) {
		this.resigDate = resigDate;
	}

	public String getEstfWrk() {
		return estfWrk;
	}

	public void setEstfWrk(String estfWrk) {
		this.estfWrk = estfWrk;
	}

	public String getEmpCat() {
		return empCat;
	}

	public void setEmpCat(String empCat) {
		this.empCat = empCat;
	}

	public String geteCategory() {
		return eCategory;
	}

	public void seteCategory(String eCategory) {
		this.eCategory = eCategory;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public int getRestDay1() {
		return restDay1;
	}

	public void setRestDay1(int restDay1) {
		this.restDay1 = restDay1;
	}

	public int getRestDay2() {
		return restDay2;
	}

	public void setRestDay2(int restDay2) {
		this.restDay2 = restDay2;
	}

	public String getEmailPass() {
		return emailPass;
	}

	public void setEmailPass(String emailPass) {
		this.emailPass = emailPass;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public Date getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	public String getUanNumber() {
		return uanNumber;
	}

	public void setUanNumber(String uanNumber) {
		this.uanNumber = uanNumber;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public String getDlNumber() {
		return dlNumber;
	}

	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}

	public Date getDlValidDate() {
		return dlValidDate;
	}

	public void setDlValidDate(Date dlValidDate) {
		this.dlValidDate = dlValidDate;
	}

	public Date getPassportValidDate() {
		return passportValidDate;
	}

	public void setPassportValidDate(Date passportValidDate) {
		this.passportValidDate = passportValidDate;
	}

	public String getAdharCardNumber() {
		return adharCardNumber;
	}

	public void setAdharCardNumber(String adharCardNumber) {
		this.adharCardNumber = adharCardNumber;
	}

	public Date getLastWorkDay() {
		return lastWorkDay;
	}

	public void setLastWorkDay(Date lastWorkDay) {
		this.lastWorkDay = lastWorkDay;
	}

	public String getSkilsType() {
		return skilsType;
	}

	public void setSkilsType(String skilsType) {
		this.skilsType = skilsType;
	}

	public String getTechType() {
		return techType;
	}

	public void setTechType(String techType) {
		this.techType = techType;
	}

	public Date getOfferLeftDate() {
		return offerLeftDate;
	}

	public void setOfferLeftDate(Date offerLeftDate) {
		this.offerLeftDate = offerLeftDate;
	}

	public String getOfferLeftNumber() {
		return offerLeftNumber;
	}

	public void setOfferLeftNumber(String offerLeftNumber) {
		this.offerLeftNumber = offerLeftNumber;
	}
	
	
	
	

}
