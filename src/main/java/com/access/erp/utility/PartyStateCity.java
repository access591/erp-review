package com.access.erp.utility;

import com.access.erp.model.master.City;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.State;

public class PartyStateCity {
	
	private PartyMaster partyMaster;
	;private State state;
	private City city;
	
	public PartyMaster getPartyMaster() {
		return partyMaster;
	}
	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	

}
