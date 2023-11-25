package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import com.nt.entity.Customer1;
import com.nt.util.util;

public class JPA_Criteria_DELETE_Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session ses=null;
		ses=util.getSesion();
		Transaction tx=null;
		CriteriaBuilder builder=ses.getCriteriaBuilder();
		//executing update QBC logic
		CriteriaDelete<Customer1> ctDelete=builder.createCriteriaDelete(Customer1.class);
		Root<Customer1> root =ctDelete.from(Customer1.class);//update project
		ctDelete.where(builder.between(root.get("Age"),60, 100));//performs Delete operation
		Query<Integer> query=ses.createQuery(ctDelete); //prepare query object
		int count=0;
		boolean flag=false;
		try
		{
			if(!ses.getTransaction().isActive())
				tx=util.beginTransaction(ses);
				count=query.executeUpdate();
				//execute JPA QBC
				flag=true;
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}finally {
			// Closing the Hibernate session
			if(flag)
			{
				util.commitTransaction(ses);
				System.out.println("records updated "+count);
			}
			else
			{
				util.rollbackTransaction(ses);
				System.out.println("records not updated");
			}
			util.closeSession(ses);

			// Closing the Hibernate session factory
			util.closeSessionFactory();
		}
	}

}
