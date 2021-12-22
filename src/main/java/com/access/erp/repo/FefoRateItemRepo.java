package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.FifoRateItem;

@Repository
public interface FefoRateItemRepo extends JpaRepository<FifoRateItem, Long>{

}
