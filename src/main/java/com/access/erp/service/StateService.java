package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Country;
import com.access.erp.model.master.State;

public interface StateService {
	
	public void addState(State country);
	public List<State> getAllState();
	public Optional<State> editState(String stateCode);
	public void deleteState(String stateCode);

	List<State> findByCountry(Country country);
}
