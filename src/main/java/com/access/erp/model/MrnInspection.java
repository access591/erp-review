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

import com.access.erp.model.master.Company;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.MyUser;


@Entity
@Table(name="INSPECTION")
public class MrnInspection {

	@Id
	@Column(name="INSP_NO",length = 15)
	private String inspNo;
	
	@Column(name="INSP_DATE")
	private Date inspDate;
	
	@Column(name="LOT_STATUS",length = 10)
	private String lotStatus;
	
	@ManyToOne
	@JoinColumn(name="MRN_NO")
	private MRN mrn;
	
	@Column(name="MRN_DATE")
	private Date mrnDate;
	
	@Column(name="ENTRY_TYPE",length = 5)
	private String entryType;
	
	@Column(name="ENTRY_MODE",length = 2)
	private String entryMode;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_CODE")
	private Employee employee;
	
	@Column(name="WORKER_CODE",length = 40)
	private String workerCode;
	
	@ManyToOne
	@JoinColumn(name="FYCODE")
	private FinancialActiveYear fy;
	
	@ManyToOne
	@JoinColumn(name="CCODE")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="UCODE")
	private MyUser myUser;
	
	@Column(name="UDATE")
	private Date uDate;
	
	@Column(name="INSPECTION_TYPE",length = 5)
	private String inspectionType;
	
	
	
	
	
	@Column(name="REP_IN_NO",length = 15)
	private String repInNo;
	
	@Column(name="REP_IN_DATE" )
	private Date repInDate;
	
	
	@OneToMany(mappedBy = "mrnInspection", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<MrnInspectionItemDetail> mrnInspectionItems = new ArrayList<>();

	public MrnInspection() {
		super();
		
	}

	public String getInspNo() {
		return inspNo;
	}

	public void setInspNo(String inspNo) {
		this.inspNo = inspNo;
	}

	public Date getInspDate() {
		return inspDate;
	}

	public void setInspDate(Date inspDate) {
		this.inspDate = inspDate;
	}

	public String getLotStatus() {
		return lotStatus;
	}

	public void setLotStatus(String lotStatus) {
		this.lotStatus = lotStatus;
	}

	public MRN getMrn() {
		return mrn;
	}

	public void setMrn(MRN mrn) {
		this.mrn = mrn;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public String getEntryMode() {
		return entryMode;
	}

	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getWorkerCode() {
		return workerCode;
	}

	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}

	public FinancialActiveYear getFy() {
		return fy;
	}

	public void setFy(FinancialActiveYear fy) {
		this.fy = fy;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public String getRepInNo() {
		return repInNo;
	}

	public void setRepInNo(String repInNo) {
		this.repInNo = repInNo;
	}

	public Date getRepInDate() {
		return repInDate;
	}

	public void setRepInDate(Date repInDate) {
		this.repInDate = repInDate;
	}
	
	
	
	
	
	
	
}