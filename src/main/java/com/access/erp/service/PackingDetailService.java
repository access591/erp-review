package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.PackingDetail;

public interface PackingDetailService {

	public void addPackingDetail(PackingDetail packingDetail);
	public List<PackingDetail> getAllPackingDetail();
	public Optional<PackingDetail> editPackingDetail(String packingCode);
	public void deletePackingDetail(String packingCode);
}
