package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.employee;
import com.nt.entity.person;
import com.nt.entity.student;
import com.nt.util.util;

public class Inheritance_Mapping_Select {

	public static void main(String[] args) {
		Session ses = util.getSession();
		Transaction tx = null;

		try {
			if (!ses.getTransaction().isActive()) {
				util.beginTransaction(ses);
				Query<person> q = ses.createQuery("from person");
				List<person> l = q.getResultList();
				l.forEach(System.out::println);
				Query<student> q1 = ses.createQuery("from student");
				List<student> l2 = q1.getResultList();
				l2.forEach(System.out::println);
				Query<employee> q2 = ses.createQuery("from employee");
				List<employee> l3 = q2.getResultList();
				l3.forEach(System.out::println);
				Query q3 = ses.createQuery("from person");
				List l4 = q3.getResultList();
				l3.forEach(System.out::println);

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			util.commitTransaction(ses);
		}
	}
}
