package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="M_UOM")
public class UOM {
	
	
	@Id
	@Column(name="UOM_CODE",length = 50)
	private String uomCode;
	
	@Column(name="UNIT",length = 100)
	private String unit;
	
	@Column(name="MEASUREMENT_SYSTEM",length = 50)
	private String measurementSystem;
	
	@Column(name="TUNGSTEN_UOM_CODE",length = 50)
	private String tungstenUomCode;
	
	@Column(name="TUNGSTEN_DESCRIPTION",length = 50)
	private String tungstenDescription;

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

	public String getTungstenUomCode() {
		return tungstenUomCode;
	}

	public void setTungstenUomCode(String tungstenUomCode) {
		this.tungstenUomCode = tungstenUomCode;
	}

	public String getTungstenDescription() {
		return tungstenDescription;
	}

	public void setTungstenDescription(String tungstenDescription) {
		this.tungstenDescription = tungstenDescription;
	}
	
	
	

}
