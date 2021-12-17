package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.master.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	
	public Role findByRoleId(Long roleId);
	
	public Role findByRoleName(String roleName);

}
