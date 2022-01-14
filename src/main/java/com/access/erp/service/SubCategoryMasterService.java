package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.SubCategory;

public interface SubCategoryMasterService {

	
	public void addServiceCategory(SubCategory serviceCategory);
	public List<SubCategory> getAllServiceCategory();
	public Optional<SubCategory> editSubCategory(String subCateCode);
	public void deleteSubCategory(String subCateCode);
	
}
