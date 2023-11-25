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

public class QBC_Projections_Multiple_Properties 
{
    public static void main( String[] args )
    {
    	Session ses = util.getSesion();
		Criteria criteria = ses.createCriteria(Customer1.class);
		try {
			Transaction tx = util.beginTransaction(ses);
			// prepare crtierion object
			Projection p1 = Projections.property("name");
			Projection p2 = Projections.property("id");
//add projections to projectionList
			ProjectionList plist = Projections.projectionList();
			plist.add(p1);plist.add(p2);
			criteria.setProjection(plist);
			Criterion cond=Restrictions.eq("Company_name","harman Company");
			criteria.add(cond);
			List<Object[]> list = criteria.list();
			list.forEach(row->{
				System.out.println(row[0]+"----"+row[1]);
			});

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

