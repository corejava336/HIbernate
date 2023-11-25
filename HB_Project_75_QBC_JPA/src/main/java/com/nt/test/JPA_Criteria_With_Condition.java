package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
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

public class JPA_Criteria_With_Condition {

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
				ParameterExpression<Integer> param1=builder.parameter(Integer.class);
				ParameterExpression<Integer> param2=builder.parameter(Integer.class);
				//create predicate objects
				Predicate pdc1=builder.ge(root.get("Age"),param1);//id>=?
				Predicate pdc2=builder.le(root.get("Age"), param2);//id<=?
				Predicate finalcond=builder.and(pdc1,pdc2);//id>=? and id<=?
				//add preicate objects to criteria query objects as were clause conditions
				ctquery.where(finalcond);
				//set query paramter values
				//create order objects
				javax.persistence.criteria.Order order =builder.desc(root.get("id"));
				//add order obj criteria query obj
				ctquery.orderBy(order);
				Query query=ses.createQuery(ctquery);
				//set param values
				query.setParameter(param1,20);
				query.setParameter(param2,100);

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
