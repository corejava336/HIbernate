package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.util.util;


public class Select_Test_Without_Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ses=util.getSesion();
		Transaction tx=null;
		List<Customer> list=null;
		try
		{
			if(!ses.getTransaction().isActive()) {
				util.beginTransaction(ses);
				Criteria criteria =ses.createCriteria(Customer.class);
				list=criteria.list();
				list.forEach(System.out::println);
				
			}
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		finally {
			// Closing the Hibernate session
			util.closeSession(ses);

			// Closing the Hibernate session factory
			util.closeSessionFactory();
		}
	}

}
