package com.nt.test;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Bank;
import com.nt.util.util;

public class Insert_Test {

	private static Serializable IdValue;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ses = null;
		ses = util.getSesion();
		Transaction tx = null;
		Bank p = new Bank();
		p.setBalance(7000);
		p.setName("Rani");
		p.setType("Savings");
		p.setDateOfOpen(LocalDateTime.now());
		boolean flag = false;
		try {
			tx = util.beginTransaction(ses);
			IdValue = ses.save(p);
			System.out.println("IdValue Generated--" + IdValue);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;

		} finally {
			if (flag) {
				util.commitTransaction(ses);
				System.out.println("Account Created on : " + p.getDateOfOpen());
				System.out.println("Account Updated on : " + p.getLastUpdated());

			} else {
				util.rollbackTransaction(ses);
			}
			util.closeSessionFactory();
		}
	}

}
