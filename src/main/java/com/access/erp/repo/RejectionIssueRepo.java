package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.RejectionIssue;



@Repository
public interface RejectionIssueRepo extends JpaRepository<RejectionIssue,String> {

	
	
	
}
