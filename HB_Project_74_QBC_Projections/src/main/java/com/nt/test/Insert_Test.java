package com.nt.test;

import com.nt.entity.Customer1;
import com.nt.util.util;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Insert_Test {
	public static void main(String[] args) {
		// Creating a new customer object with values
		Customer1 customer = new Customer1();
		customer.setName("sreya");
		customer.setAge(55);
		customer.setCompany_name("harman Company");
		customer.setAddress("Gandhiji Street");

		// Getting a Hibernate session
		Session session = util.getSesion();

		// Starting a transaction
		Transaction transaction = util.beginTransaction(session);

		try {
			// Saving the customer object to the database
			session.save(customer);

			// Committing the transaction
			util.commitTransaction(session);
			System.out.println("Customer inserted successfully!" +customer);
		} catch (Exception e) {
			// Rolling back the transaction in case of an exception
			util.rollbackTransaction(session);
			e.printStackTrace();
		} finally {
			// Closing the Hibernate session
			util.closeSession(session);

			// Closing the Hibernate session factory
			util.closeSessionFactory();
		}
	}
}
