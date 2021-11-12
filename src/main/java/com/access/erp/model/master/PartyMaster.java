package com.access.erp.model.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_PARTY")
public class PartyMaster {

	@Id
	private Long Id;
}
