package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.RejectionIssueAssetDetail;

@Repository
public interface RejectionIssueAssetDetailRepo extends JpaRepository<RejectionIssueAssetDetail,Long> {

}
