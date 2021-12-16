package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Program;
import com.access.erp.model.master.UserRights;

@Repository
public interface UserRightRepo extends JpaRepository<UserRights, Long>{
	
	boolean existsByMyUserAndPrgCode(MyUser myuser , Program program);

}
