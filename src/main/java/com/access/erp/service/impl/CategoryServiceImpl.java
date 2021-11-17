package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Category;
import com.access.erp.repo.CategoryRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired CategoryRepo categoryRepo;
	
	
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addCategory(Category category) {
		
		if (category.getCategCode() == "" || category.getCategCode() == null) {
			System.out.println("category code is : "+ category.getCategCode());
			String maxCode = seqMainRepo.findByTranType("CAT");
			category.setCategCode(maxCode);
		}

		categoryRepo.save(category);
		
	}

	@Override
	public List<Category> getAllCategory() {
		
		return this.categoryRepo.findAll();
	}

	@Override
	public Optional<Category> editCategory(String CategoryCode) {

		return this.categoryRepo.findById(CategoryCode);
	}

	@Override
	public void deleteCategory(String CategoryCode) {
		this.categoryRepo.deleteById(CategoryCode);
		
	}

}
