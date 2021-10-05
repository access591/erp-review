package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Category;

public interface CategoryService {
	
	public void addCategory(Category category);
	public List<Category> getAllCategory();
	public Optional<Category> editCategory(String CategoryCode);
	public void deleteCategory(String CategoryCode);

}
