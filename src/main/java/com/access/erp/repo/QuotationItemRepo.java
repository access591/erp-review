package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.QuotationItem;


@Repository
public interface QuotationItemRepo extends JpaRepository<QuotationItem, Long>{

}
