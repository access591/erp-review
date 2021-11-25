package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Program;
import com.access.erp.model.master.Role;
import com.access.erp.model.master.UserRights;
import com.access.erp.model.master.UserRole;
import com.access.erp.repo.MyUserRepo;
import com.access.erp.repo.ProgramRepo;
import com.access.erp.repo.RoleRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.UserRightRepo;
import com.access.erp.repo.UserRoleRepo;
import com.access.erp.service.ProgramService;
import com.access.erp.service.RoleService;
import com.access.erp.service.UserRightsService;
import com.access.erp.service.UserRoleService;

// for user role 

@Service
public class UserRightsServiceImpl implements UserRightsService {

	@Autowired
	UserRightRepo userRightRepo;
	@Autowired
	UserRoleRepo userRoleRepo;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	ProgramService programService;
	@Autowired RoleService roleService;
	@Autowired MyUserRepo userRepo;
	@Autowired RoleRepo roleRepo;
	

	@Override
	public void addUserRights(UserRights userRights) {

		userRightRepo.save(userRights);

		// 1. save user role
		// 2. check role exists or not if not then save
		// 3. check user role exists if not then save it

		Program program = userRights.getPrgCode();
		MyUser user = userRights.getMyUser();
		
		addOrUpdateRole(program.getProgramCode(),user.getUserCode());

	}

	@Override
	public List<UserRights> getAllUserRights() {
		
		return userRightRepo.findAll();
	}

	@Override
	public Optional<UserRights> editUserRights(Long userCode) {
		
		return userRightRepo.findById(userCode);
	}

	@Override
	public void deleteUserRights(Long userCode) {
		
		userRightRepo.deleteById(userCode);
	}

	public void addOrUpdateRole(String prgCode, String userCode) {

		Program program = programService.editProgram(prgCode).get();
		System.out.println("get program code +=====" + prgCode);

		String rolename;
		MyUser u = userRepo.findByUserCode(userCode);		
		if (program != null) {
			rolename = program.getProgramHrefName().replaceAll("\\s", "").toUpperCase().substring(2);
			System.out.println("role name " + rolename);

			Role r = roleService.isRoleExistOrNot(rolename); // null == data not found (role is not exists)

			

			if (r != null) {

				UserRole userRole = new UserRole();

				userRole.setRole(r);
				userRole.setMyUSer(u);

				// to check role already assign or not
				//System.out.println("value of is userRole exists");
				boolean isExists = userRoleService.isUserRoleExist(rolename, userCode);
																										// alredy exists

				if (!isExists) {
					System.out.println(" file is not exists ");
					userRoleRepo.save(userRole);
				}else {
					System.out.println("exists...");
				}
				System.out.println("close");

			}

			else {
				Role role = new Role();
				role.setRoleName(rolename);
				role.setProgram(program);
				roleRepo.save(role);
				Role r2 = roleService.isRoleExistOrNot(rolename);

				
				UserRole userRole = new UserRole();
				userRole.setRole(r2);
				userRole.setMyUSer(u);
				//userRoleService.addUserRole(userRole);
				
				userRoleRepo.save(userRole);
			}
		}

	}

}
