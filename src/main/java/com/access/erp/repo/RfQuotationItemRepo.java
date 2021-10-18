package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.RfQuotationItem;

@Repository
public interface RfQuotationItemRepo extends JpaRepository<RfQuotationItem, Long>{

}
