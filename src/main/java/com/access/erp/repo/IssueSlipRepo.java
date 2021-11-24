package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.IssueSlip;

@Repository
public interface IssueSlipRepo extends JpaRepository<IssueSlip, String>{

}
