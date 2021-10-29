package com.access.erp.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.UserRole;
import com.access.erp.service.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean isUserRoleExist(String roleName, String userCode) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean result = false;
		UserRole userRole = null;
		
		try {
			tx = session.beginTransaction();
			Query<UserRole> query = session.createQuery("from UserRole ur where ur.role.roleName=:roleName and "
					+ "ur.myUSer.userCode=:userCode",UserRole.class);
			query.setParameter("roleName", roleName);
			query.setParameter("userCode", userCode);
			
			userRole = query.getSingleResult();
			
			result = true;
			
		}catch(Exception e) {
			result = false;
		}
		
		return result;
	}

}
