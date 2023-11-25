package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import com.nt.entity.Customer1;
import com.nt.util.util;

public class JPA_Criteria_Selecting_All_Records_Without_Condition_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session ses=null;
		ses=util.getSesion();
		Transaction tx=null;
		CriteriaBuilder builder=null;
		try
		{
			if(!ses.getTransaction().isActive())
				tx=util.beginTransaction(ses);
				builder =ses.getCriteriaBuilder();
				javax.persistence.criteria.CriteriaQuery<Customer1> ctquery= builder.createQuery(Customer1.class);
				//Create root pbj specifying all col names (entity class ) or specific cols
				Root<Customer1> root =ctquery.from(Customer1.class);
				ctquery.select(root);
				Query query=ses.createQuery(ctquery);
				//execute JPA QBC
				List<Customer1> list=query.getResultList();
				list.forEach(System.out::println);
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}finally {
			// Closing the Hibernate session
			util.closeSession(ses);

			// Closing the Hibernate session factory
			util.closeSessionFactory();
		}
	}

}
