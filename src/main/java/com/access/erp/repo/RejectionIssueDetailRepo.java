package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.RejectionIssueDetail;

@Repository
public interface RejectionIssueDetailRepo extends JpaRepository <RejectionIssueDetail,Long>{

}
