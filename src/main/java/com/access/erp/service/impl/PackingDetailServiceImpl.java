package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.PackingDetail;
import com.access.erp.repo.PackingDetailRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.PackingDetailService;


@Service
public class PackingDetailServiceImpl implements PackingDetailService {

	
	@Autowired PackingDetailRepo packingDetailRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addPackingDetail(PackingDetail packingDetail) {
		
		if (packingDetail.getPackingCode() == "" || packingDetail.getPackingCode() == null) {
			System.out.println("packing detail code is : "+ packingDetail.getPackingCode());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("PAK", "20-21", "EB");
			packingDetail.setPackingCode(maxCode);
		}

		packingDetailRepo.save(packingDetail);
		
	}

	@Override
	public List<PackingDetail> getAllPackingDetail() {
		
		return packingDetailRepo.findAll();
	}

	@Override
	public Optional<PackingDetail> editPackingDetail(String packingCode) {
		
		return packingDetailRepo.findById(packingCode);
	}

	@Override
	public void deletePackingDetail(String packingCode) {
		packingDetailRepo.deleteById(packingCode);
		
	}

}
