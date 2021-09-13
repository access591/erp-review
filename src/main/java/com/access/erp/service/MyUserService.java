package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.MyUser;

public interface MyUserService {
	
	public void addMyUSer(MyUser myUser);
	public List<MyUser> getAllMyUser();
	public Optional<MyUser> editMyUser(String userCode);
	public void deleteMyUser(String userCode);

}
