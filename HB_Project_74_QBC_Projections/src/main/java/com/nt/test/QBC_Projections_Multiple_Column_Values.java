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

public class QBC_Projections_Multiple_Column_Values 
{
    public static void main( String[] args )
    {
    	Session ses = util.getSesion();
		Criteria criteria = ses.createCriteria(Customer1.class);
		try {
			Transaction tx = util.beginTransaction(ses);
			// prepare crtierion object
			Projection p1 = Projections.max("Age");
			criteria.setProjection(p1);
			List<?> list = criteria.list();
			System.out.println("records count "+list.get(0));

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

