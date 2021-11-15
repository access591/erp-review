package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class GateEntry {
	
	
	@Id
	@Column(name="GATE_SR_NO",length = )
	private String gateSrNo;
	
	@Column(name="GATE_ENTRY_DATE",length = )
	private Date gateEntryDate;
	
	@Column(name="ORDER_NO",length = )
	private String orderNo;
	
	@Column(name="TIME_IN",length = )
	private Date timeIn;
	
	//supplier code
	
	@Column(name="VEHICLE_NUMBER",length = )
	private String vehicleNumber;
	
	@Column(name="BILL_NUMBER",length = )
	private String billNumber;
	
	@Column(name="BILL_DATE",length = )
	private Date billDate;
	
	@Column(name="GOODS_CATEGORY",length = )
	private String goodsCategory;
	
	@Column(name="REMARKS",length = )
	private String remarks;
	
	//ccode
	
	//fycode
	
	@Column(name="U_DATE",length = )
	private Date uDate;
	
	@Column(name="RETURN_GATE_PASS_NO",length = )
	private String returnGatePassNo ;
	
	@Column(name="NAME_TRANS",length = )
	private String nameTrans;
	
	@Column(name="GR_NUMBER",length = )
	private String grNumber;
	
	@Column(name="GR_DATE",length = )
	private Date grDate ;
	
	@Column(name="BILL_TYPE",length = )
	private String billType;
	
	@Column(name="REP_OUT_NO",length = )
	private String repOutNo;
	
	//tr_code
	
	@Column(name="GATE_PASS_DATE",length = )
	private Date gatePassdate;
	
	@Column(name="ENTRY_TYPE",length = )
	private String entryType ;
	
	@Column(name="PAY_ABLE_TO",length = )
	private String payableTo ;
	
	@Column(name="LABOUR_CHARGES",length = )
	private String labourCharges ;
	
	@Column(name="FRIEGHT_CHARGES",length = )
	private String freightCharges;
	
	@Column(name="JVNO",length = )
	private String jvno;
	
	@Column(name="JV_DATE",length = )
	private String jvDate;
	
	@Column(name="BILL_AMOUNT",length = )
	private int billAmount;
	
	@Column(name="TRANS_MODE",length = )
	private String transMode;
	
	@Column(name="SCHEDULE_NO",length = )
	private String secheduleNo;
	
	@Column(name="SCHEDULE_DATE",length = )
	private Date secheduledate;
	
	@Column(name="SHIFT",length = )
	private String shift;
	
	@Column(name="T_DATE",length = )
	private Date tDate;
	
	@Column(name="REGISTER_NUMBER",length = )
	private String registerNumber;
	
	@Column(name="REGISTER_DATE",length = )
	private Date registerDate;
	
	@Column(name="PITTY_INDENT_DATE",length = )
	private Date pittyIndentDate;
	
	@Column(name="PITTY_INDENT",length = )
	private String pittyIndent;
	
	@Column(name="WARRANTY_NO",length = )
	private String warrantyNo;
	
	@Column(name="WARRANTY_DATE",length = )
	private String warrantyDate;
	
	@Column(name="BAR_CODE",length = )
	private String barCode;
	
	
	
}
