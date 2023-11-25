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

public class Select_Test_With_Between {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ses = util.getSesion();
		Criteria criteria = ses.createCriteria(Customer.class);
		try {
			Transaction tx = util.beginTransaction(ses);
			// prepare crtierion object
			Criterion cond1 = Restrictions.between("Age",20,80);
			Criterion cond2 = Restrictions.in("Address",List.of("gandhi"));
			Criterion cond3 = Restrictions.ilike("Company_name","o%");
			//create criterion object having adn clause b/w cond1 , cond2
			Criterion finalcond=Restrictions.or(Restrictions.and(cond1,cond2));
			criteria.add(finalcond);
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
