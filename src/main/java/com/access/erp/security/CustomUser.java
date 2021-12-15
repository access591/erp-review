package com.access.erp.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Role;
import com.access.erp.model.master.UserRole;
import com.access.erp.repo.RoleRepo;
import com.access.erp.repo.UserRoleRepo;

@Component
public class CustomUser implements UserDetails {

	private MyUser myUser;
	private final static String ROLE = "ROLE_";
	@Autowired
	UserRoleRepo userRoleRepo;
	@Autowired
	RoleRepo roleRepo;

	CustomUser(MyUser myUser) {
		this.myUser = myUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		System.out.println("get athorites");
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();



		for (UserRole userRole : myUser.getListUserRole()) {

			System.out.println("user role id : " + userRole.getUserRoleId());

			Role role = userRole.getRole();
			System.out.println("Role Name ======> " + role.getRoleName());

			set.add(new SimpleGrantedAuthority(ROLE + role.getRoleName()));

		}
		return set;
	}

	@Override
	public String getPassword() {

		return myUser.getUserPassword();
	}

	@Override
	public String getUsername() {

		return myUser.getUserCode();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
