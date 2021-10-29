package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.UserRights;

public interface UserRightsService {
	
	public void addUserRights(UserRights userRights);
	public List<MyUser> getAllUserRights();
	public Optional<MyUser> editUserRights(String userCode);
	public void deleteUserRights(String userCode);
	

}
