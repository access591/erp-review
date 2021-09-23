package com.access.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WorkOrderService")
public class WorkOrderS {

	@Id
	@Column(name="ID")
	public Long id;
}
