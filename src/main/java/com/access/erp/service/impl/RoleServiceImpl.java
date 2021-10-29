package com.access.erp.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Role;
import com.access.erp.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Role isRoleExistOrNot(String roleName) {

		System.out.println("role Name : " + roleName);

		// roleName = roleName.replaceAll("\\s", "").toUpperCase();
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Role role = null;
		try {
			tx = session.beginTransaction();
			Query<Role> query = session.createQuery("from Role r where r.roleName=:roleName", Role.class);
			query.setParameter("roleName", roleName);
			role = query.getSingleResult();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}

}
