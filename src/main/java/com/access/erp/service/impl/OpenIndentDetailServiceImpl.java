package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;
import com.access.erp.repo.OpenIndentDetailRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.OpenIndentDetailService;


@Service
public class OpenIndentDetailServiceImpl implements OpenIndentDetailService{

	@Autowired OpenIndentDetailRepo indentDetailRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	
	@Override
	public void addOpenIndentDetail(OpenIndentDetail openIndetntDetail) {
		
	}

	@Override
	public List<OpenIndentDetail> getAllOpenIndentDetail() {
		
		return indentDetailRepo.findAll();
	}

	
	@Override
	public Optional<OpenIndentDetail> editOpenIndentDetail(Long inDetailCode) {
		
		return indentDetailRepo.findById(inDetailCode);
	}

	@Override
	public void deleteOpenIndentDetail(Long OpenIndentDetail) {
		indentDetailRepo.deleteById(OpenIndentDetail);
		
	}

	@Override
	public List<OpenIndentDetail> findOpenIndentDetailByOpenIndent(OpenIndent openIndent) {
		
		return this.indentDetailRepo.findByOpenIndent(openIndent);
	}

}
