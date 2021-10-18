package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;

public interface OpenIndentDetailService {

	public void addOpenIndentDetail(OpenIndentDetail openIndetntDetail);
	public List<OpenIndentDetail> getAllOpenIndentDetail();
	public Optional<OpenIndentDetail> editOpenIndentDetail(Long inDetailCode);
	public void deleteOpenIndentDetail(Long OpenIndentDetail);
	
	public List<OpenIndentDetail> findOpenIndentDetailByOpenIndent(OpenIndent openIndent);
}
