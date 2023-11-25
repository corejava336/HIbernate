package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Customer1;
import com.nt.util.util;

public class QBC_Projections_Pagination 
{
    public static void main( String[] args )
    {
    	Session ses = util.getSesion();
		Criteria criteria = ses.createCriteria(Customer1.class);
		try {
			Transaction tx = util.beginTransaction(ses);
			// prepare crtierion object
			criteria.setFirstResult(1);
			criteria.setMaxResults(5);
			List<Customer1> list = criteria.list();
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

