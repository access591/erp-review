package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Item;


@Entity
@Table(name="GATE_PASS_DETAIL")
public class GatePassDetail {
	
	@Id
	@Column(name="",length = 10)
	private Long gatePassDetailId;
	
	@Column(name="GATE_PASS_SRNO",length = 4)
	private int gatePassSrNO;

	@ManyToOne
	@JoinColumn(name="ITEM_CODE")
	private Item item;

	@Column(name="MACHINE_CODE",length = 6)
	private String machineCode;

	@Column(name="DESCRIPTION",length = 100)
	private String description;

	@Column(name="QTY",length = 12)
	private int qty;

	@Column(name="RECEIVING_DATE")
	private Date receivingDate;

	@Column(name="APPRX_ITEM_RATE",length = 14)
	private int apprexItemDate;

	@Column(name="DET_REMARKS",length = 500)
	private String detRemarks;

	@Column(name="STATUS",length = 2)
	private String status;

	@Column(name="SR_NO_CLAIM_UNDER",length = 20)
	private String srNoClaimUnder;

	@Column(name="SR_NO_SEND_FOR_REP",length = 20)
	private String srNoSendForRep;
	
	@ManyToOne
	@JoinColumn(name = "GATE_PASS_NO")
	private GatePass gatePass;
	
	@Column(name="GATE_PASS_DATE")
	private Date gatePassDate;

	public GatePassDetail() {
		super();
		
	}

	public Long getGatePassDetailId() {
		return gatePassDetailId;
	}

	public void setGatePassDetailId(Long gatePassDetailId) {
		this.gatePassDetailId = gatePassDetailId;
	}

	public int getGatePassSrNO() {
		return gatePassSrNO;
	}

	public void setGatePassSrNO(int gatePassSrNO) {
		this.gatePassSrNO = gatePassSrNO;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
	}

	public int getApprexItemDate() {
		return apprexItemDate;
	}

	public void setApprexItemDate(int apprexItemDate) {
		this.apprexItemDate = apprexItemDate;
	}

	public String getDetRemarks() {
		return detRemarks;
	}

	public void setDetRemarks(String detRemarks) {
		this.detRemarks = detRemarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSrNoClaimUnder() {
		return srNoClaimUnder;
	}

	public void setSrNoClaimUnder(String srNoClaimUnder) {
		this.srNoClaimUnder = srNoClaimUnder;
	}

	public String getSrNoSendForRep() {
		return srNoSendForRep;
	}

	public void setSrNoSendForRep(String srNoSendForRep) {
		this.srNoSendForRep = srNoSendForRep;
	}

	public GatePass getGatePass() {
		return gatePass;
	}

	public void setGatePass(GatePass gatePass) {
		this.gatePass = gatePass;
	}

	public Date getGatePassDate() {
		return gatePassDate;
	}

	public void setGatePassDate(Date gatePassDate) {
		this.gatePassDate = gatePassDate;
	}
	
	
	
	

	


}
