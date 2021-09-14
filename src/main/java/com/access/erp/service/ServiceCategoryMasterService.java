package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.ServiceCategory;

public interface ServiceCategoryMasterService {

	
	public void addServiceCategory(ServiceCategory serviceCategory);
	public List<ServiceCategory> getAllServiceCategory();
	public Optional<ServiceCategory> editServiceCategory(String serviceCateCode);
	public void deleteServiceCategory(String serviceCateCode);
	
}
