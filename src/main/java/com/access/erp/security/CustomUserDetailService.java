package com.access.erp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.UserRole;
import com.access.erp.repo.MyUserRepo;
import com.access.erp.repo.UserRoleRepo;

@Component
public class CustomUserDetailService implements UserDetailsService{

	@Autowired MyUserRepo userRepo;
	
	@Autowired UserRoleRepo userRoleRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("find user :" + username);
		MyUser user = userRepo.findByUserCode(username);
		
		//System.out.println("user name is : " + user.getUserCode());
		
		if(user == null) {
			System.out.println("user is not found");
			throw new UsernameNotFoundException("No User is available in this User Code ");
		}
		
		for(UserRole userRole : user.getListUserRole()) {
			System.out.println("user role id : " + userRole.getUserRoleId());
		}
		return new CustomUser(user);
	}

}
