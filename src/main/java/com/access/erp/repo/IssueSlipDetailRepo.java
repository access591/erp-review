package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.IssueSlipDetail;

@Repository 
public interface IssueSlipDetailRepo extends JpaRepository<IssueSlipDetail, Long>{

}
