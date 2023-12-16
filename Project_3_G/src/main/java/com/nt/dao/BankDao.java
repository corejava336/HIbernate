package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.bank;
import com.nt.util.util;

import jakarta.servlet.http.HttpSession;

public class BankDao {

	public boolean login(String name, String password) {
		Session ses = util.getSession();
		try {
			// Check if a transaction is already active
			if (ses.getTransaction().isActive()) {
				String q = "FROM bank WHERE name = :name AND password = :password";
				Query<bank> query = ses.createQuery(q, bank.class);
				query.setParameter("name", name);
				query.setParameter("password", password);
				bank user = query.uniqueResult();
				boolean r = (user != null);
				if (r) {
					System.out.println("Record found");
				} else {
					System.out.println("Record not found");
				}
				ses.getTransaction().commit(); // Commit only if successful
				return r;
			}
			return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (ses != null && ses.getTransaction().isActive()) {
				ses.getTransaction().rollback(); // Rollback in case of exception
			}
			return false;
		}
	}

	public boolean signup(String name, String password, bank bankEntity) {
		Session ses = util.getSession();
		bankEntity.setName(name);
		bankEntity.setPassword(password);

		try {
			util.beginTransaction(ses);
			ses.save(bankEntity); // Save the entity
			util.commitTransaction(ses);
			System.out.println("Record created");
			return true;
		} catch (Exception e) {
			util.rollbackTransaction(ses);
			e.printStackTrace();
			System.out.println("Record not created");
			return false;
		}
	}

}
