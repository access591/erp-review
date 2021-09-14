package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.ServiceCategory;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.ServiceCategoryMasterRepo;
import com.access.erp.service.ServiceCategoryMasterService;

@Service
public class ServiceCategoryMasterServiceImpl implements ServiceCategoryMasterService {

	@Autowired
	ServiceCategoryMasterRepo serviceCategoryRepo;
	@Autowired
	SeqMainRepo seqMainRepo;

	@Override
	public void addServiceCategory(ServiceCategory serviceCategory) {

		if (serviceCategory.getCategoryCode() == "" || serviceCategory.getCategoryCode() == null) {
			System.out.println("country code is : "+ serviceCategory.getCategoryCode());
			String maxCode = seqMainRepo.findByTranType("CAT");
			serviceCategory.setCategoryCode(maxCode);
		}

		serviceCategoryRepo.save(serviceCategory);

	}

	@Override
	public List<ServiceCategory> getAllServiceCategory() {

		return serviceCategoryRepo.findAll();
	}

	@Override
	public Optional<ServiceCategory> editServiceCategory(String serviceCateCode) {

		return serviceCategoryRepo.findById(serviceCateCode);
	}

	@Override
	public void deleteServiceCategory(String serviceCateCode) {
		serviceCategoryRepo.deleteById(serviceCateCode);

	}

}
