package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Customer;
import com.nt.util.util;

public class Select_Test_With_Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ses = util.getSesion();
		Criteria criteria = ses.createCriteria(Customer.class);
		try {
			Transaction tx = util.beginTransaction(ses);
			// prepare crtierion object
			Criterion cond1 = Restrictions.ge("Age", 20);
			Criterion cond2 = Restrictions.le("Age", 80);
			// add criterion object to criteria object
			Order order=Order.asc("Age");
			Order order1=Order.desc("name");
			criteria.addOrder(order);
			criteria.addOrder(order1);
			criteria.add(cond1);
			criteria.add(cond2);
			List<Customer> list = criteria.list();
			list.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			// Closing the Hibernate session
			util.closeSession(ses);

			// Closing the Hibernate session factory
			util.closeSessionFactory();
		}
	}

}
