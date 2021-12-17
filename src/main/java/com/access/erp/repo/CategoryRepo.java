package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String>{
	
	List<Category> findByActive(String active);

}
