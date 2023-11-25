package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Customer1;
import com.nt.util.util;

public class QBC_Projections_for_single_Property 
{
    public static void main( String[] args )
    {
    	Session ses = util.getSesion();
		Criteria criteria = ses.createCriteria(Customer1.class);
		try {
			Transaction tx = util.beginTransaction(ses);
			// prepare crtierion object
			Projection c = Projections.property("name");
			criteria.setProjection(c);
			Criterion cond=Restrictions.eq("Company_name","harman Company");
			criteria.add(cond);
			List<String> list = criteria.list();
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

