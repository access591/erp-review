package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.SubCategory;

@Repository
public interface SubCategoryMasterRepo extends JpaRepository<SubCategory, String>{

}
