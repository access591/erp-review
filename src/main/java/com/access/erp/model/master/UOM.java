package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="M_UOM")
public class UOM {
	
	
	@Id
	@Column(name="UOM_CODE",length = 8)
	private String uomCode;
	
	@Column(name="UNIT",length = 15)
	private String unit;
	
	@Column(name="MEASUREMENT_SYSTEM",length = 2)
	private String measurementSystem;
	
	

	public UOM() {
		super();
		
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMeasurementSystem() {
		return measurementSystem;
	}

	public void setMeasurementSystem(String measurementSystem) {
		this.measurementSystem = measurementSystem;
	}

	
	
	
	

}
