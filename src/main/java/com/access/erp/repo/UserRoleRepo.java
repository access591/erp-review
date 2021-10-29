package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.access.erp.model.master.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long>{

	
	
	@Query("from UserRole ur where ur.role.roleName=:roleName and ur.myUSer.userCode=:userCode")
	public boolean isUserRoleExist(String roleName,String userCode);
}
