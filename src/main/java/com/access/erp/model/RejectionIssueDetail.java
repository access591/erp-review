package com.access.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ISSUE_DETAIL")
public class RejectionIssueDetail {

	@Id
	@Column(name="ISS_NO")
	private String issNo;
	
	@Column(name="ISS_DATE")
	private String Date1;
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name = "ISSUE_NO",nullable = true)
	private RejectionIssue rejectionIssue;
	
	
}
