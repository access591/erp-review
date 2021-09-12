package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.State;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.StateRepo;
import com.access.erp.service.StateService;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired StateRepo stateRepo;
	
	
	@Override
	public void addState(State state) {
		
		if (state.getStateCode() == "" || state.getStateCode() == null) {
			System.out.println("country code is : "+ state.getStateCode());
			String maxCode = seqMainRepo.findByTranType("STS");
			state.setStateCode(maxCode);
		}

		stateRepo.save(state);
		
	}

	@Override
	public List<State> getAllState() {
		
		return stateRepo.findAll();
	}

	@Override
	public Optional<State> editState(String stateCode) {
		
		return stateRepo.findById(stateCode);
	}

	@Override
	public void deleteState(String stateCode) {
		stateRepo.deleteById(stateCode);
		
	}

}
