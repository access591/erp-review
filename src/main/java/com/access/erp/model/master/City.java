package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City {
	
	@Id
	@Column(name = "CITY_CODE", length = 50)
	private int cityCode;
	
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	
	@Column(name = "STATE_CODE", length = 50)
	private String stateCode;
	
	@Column(name = "REGION_CODE", length = 50)
	private String regionCode;
	
	@Column(name = "DISTRICT", length = 100)
	private String district;
	
	@Column(name = "CITY_TYPE", length = 4)
	private String cityType;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}
	
	
	
	

}
