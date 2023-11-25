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

public class JPA_Criteria_Scalar_Aggregate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session ses = null;
		ses = util.getSesion();
		Transaction tx = null;
		CriteriaBuilder builder = null;
		try {
			if (!ses.getTransaction().isActive())
				tx = util.beginTransaction(ses);
			builder = ses.getCriteriaBuilder();
			javax.persistence.criteria.CriteriaQuery<Long> ctquery = builder.createQuery(Long.class);
			// Create root pbj specifying all col names (entity class ) or specific cols
			Root<Customer1> root = ctquery.from(Customer1.class);
			ctquery.multiselect(builder.count(root.get("id")));
			Query<Long> query = ses.createQuery(ctquery);
			// execute JPA QBC
			Long count = query.uniqueResult();
			System.out.println(count);
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
