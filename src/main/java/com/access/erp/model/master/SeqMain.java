package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.access.erp.repo.SeqMainRepo;

@Entity
@Table(name="SEQ_MAIN")
public class SeqMain {
	
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="TRAN_TYPE")
	private String tranType;
	
	@Column(name="TRAN_CODE")
	private String tranCode;

	
	
	public SeqMain() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}
	
	
	

}
