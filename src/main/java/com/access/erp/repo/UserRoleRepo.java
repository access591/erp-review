package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Role;
import com.access.erp.model.master.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long>{

	@Query("from UserRole r inner join fetch r.myUSer where r.myUSer.userCode = :id")
	public List<UserRole> findByMyUSer(@Param("id") String userCode);
	
	
	/*
	 * @Query("from Review r inner join fetch r.comments where r.reviewId = :id")
	 * User findByReviewId(@Param("id") int id);
	 */
	
	
	@Query("from UserRole ur where ur.role.roleName=:roleName and ur.myUSer.userCode=:userCode")
	public boolean isUserRoleExist(String roleName,String userCode);
	
	public UserRole findByMyUSerAndRole(MyUser myUser , Role role);
	
	public List<UserRole> findByMyUSerAndActive(MyUser myUser , String active);
}
