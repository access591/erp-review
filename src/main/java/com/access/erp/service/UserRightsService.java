package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.UserRights;

public interface UserRightsService {
	
	public void addUserRights(UserRights userRights);
	public List<UserRights> getAllUserRights();
	public Optional<UserRights> editUserRights(Long userCode);
	public void deleteUserRights(Long userCode);
	

}
