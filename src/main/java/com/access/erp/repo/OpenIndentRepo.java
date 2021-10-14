package com.access.erp.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.access.erp.model.OpenIndent;

@Repository
public interface OpenIndentRepo extends JpaRepository<OpenIndent, String>{

	@Transactional
	@Modifying
	@Query("update OpenIndent op set op.approvalStatus1=:approvalStatus1 where op.indentNumber=:indentNumber")
	public void levelOneApproval(@Param("indentNumber") String indentNumber,@Param("approvalStatus1") String approvalStatus1);
	
	@Transactional
	@Modifying
	@Query("update OpenIndent op set op.approvalStatus1=:approvalStatus1 where op.indentNumber=:indentNumber")
	public void levelTwoApproval(@Param("indentNumber") String indentNumber,@Param("approvalStatus1") String approvalStatus1);
	
	@Transactional
	@Modifying
	@Query("update OpenIndent op set op.approvalStatus1=:approvalStatus1 where op.indentNumber=:indentNumber")
	public void levelThreeApproval(@Param("indentNumber") String indentNumber,@Param("approvalStatus1") String approvalStatus1);
	
	
}
