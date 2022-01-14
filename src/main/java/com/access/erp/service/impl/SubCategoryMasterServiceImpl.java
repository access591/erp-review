package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.SubCategory;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.SubCategoryMasterRepo;
import com.access.erp.service.SubCategoryMasterService;

@Service
public class SubCategoryMasterServiceImpl implements SubCategoryMasterService {

	@Autowired
	SubCategoryMasterRepo subCategoryRepo;
	@Autowired
	SeqMainRepo seqMainRepo;

	@Override
	public void addServiceCategory(SubCategory subCategory) {

		if (subCategory.getSubCategoryCode() == "" || subCategory.getSubCategoryCode() == null) {
			System.out.println("country code is : "+ subCategory.getSubCategoryCode());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("SUBC", "20-21", "EB");
			subCategory.setSubCategoryCode(maxCode);
		}

		subCategoryRepo.save(subCategory);

	}

	@Override
	public List<SubCategory> getAllServiceCategory() {

		return subCategoryRepo.findAll();
	}

	@Override
	public Optional<SubCategory> editSubCategory(String subCateCode) {

		return subCategoryRepo.findById(subCateCode);
	}

	@Override
	public void deleteSubCategory(String subCateCode) {
		subCategoryRepo.deleteById(subCateCode);

	}

}
