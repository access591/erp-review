package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.MyUser;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,String >{

	public MyUser findByUserCode(String userCode);
	
	List<MyUser> findByActive(String active);
}
