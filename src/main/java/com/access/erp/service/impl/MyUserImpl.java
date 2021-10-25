package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.MyUser;
import com.access.erp.repo.MyUserRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.MyUserService;


@Service
public class MyUserImpl implements MyUserService{

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired MyUserRepo userRepo;
	
	@Override
	public void addMyUSer(MyUser myUser) {
		
		/*
		 * if (myUser.getUserCode() == "" || myUser.getUserCode() == null) {
		 * System.out.println("user code is : "+ myUser.getUserCode()); String maxCode =
		 * seqMainRepo.findByTranType(""); city.setCityCode(maxCode); }
		 */
		
		
		
		userRepo.save(myUser);
		
	}

	@Override
	public List<MyUser> getAllMyUser() {
		
		return  userRepo.findAll();
	}

	@Override
	public Optional<MyUser> editMyUser(String userCode) {
		return userRepo.findById(userCode);
	}

	@Override
	public void deleteMyUser(String userCode) {
		userRepo.deleteById(userCode);
		
	}

}
