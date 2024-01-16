package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.employee;
import com.nt.entity.person;
import com.nt.entity.student;
import com.nt.util.util;

public class Inheritance_Mapping_Insert {

	public static void main(String[] args) {
		Session ses = util.getSession();
		Transaction tx = null;
		boolean flag = false;
		person p = new person();
		employee e = new employee();
		student s = new student();
		p.setName("diasy");
		p.setAddress("Zepher");
		e.setName("rash");
		e.setAddress("sheild");
		e.setDeptno(1);
		e.setDesg("science");
		e.setSalary(23000000);
		s.setName("rash");
		s.setAddress("sheild");
		s.setAvg(1233);
		s.setCollege("jai");
		s.setBranch("cse");
		

		try {
			if (!ses.getTransaction().isActive()) {
				util.beginTransaction(ses);
				ses.save(p);
				ses.save(e);
				ses.save(s);
				flag = true;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				util.commitTransaction(ses);
				System.out.println("record inserted");
			} else {
				util.rollbackTransaction(ses);
				System.out.println("record inserted");

			}
			util.closeSessionFactory();
		}
	}
}
