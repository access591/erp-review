
package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.MRN;
import com.access.erp.repo.MRMRepo;
import com.access.erp.service.MRMService;

@Service
public class MrmServiceImpl implements MRMService {

	@Autowired MRMRepo mrmRepo;
	
	@Override
	public void addMrm(MRN mrm) {

		
	}

	@Override
	public List<MRN> getAllMrm() {
		return this.mrmRepo.findAll();
	}

	@Override
	public Optional<MRN> editMrm(String mrmCode) {
		return this.mrmRepo.findById(mrmCode);
	}

	@Override
	public void deleteMrm(String mrmCode) {
		this.mrmRepo.deleteById(mrmCode);
	}

}
