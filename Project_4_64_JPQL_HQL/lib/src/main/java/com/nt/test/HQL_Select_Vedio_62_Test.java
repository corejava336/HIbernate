package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Bank;
import com.nt.util.util;

public class HQL_Select_Vedio_62_Test {

    public static void main(String[] args) {
        Session ses = null;
        Transaction tx = null;
        List<Bank> list = null;
        Query<Bank> query =null;
        try {
            ses = util.getSession();
            tx = util.beginTransaction(ses);

            // Use the correct package name for the entity class in the HQL query
            query = ses.createQuery("FROM com.nt.entity.Bank"); 

            list = query.getResultList();
            list.forEach(i -> {
                System.out.println(i);
            });

            // Commit the transaction
            util.commitTransaction(ses);
        } catch (HibernateException he) {
            he.printStackTrace();
            if (tx != null) {
                // Rollback the transaction in case of an exception
                util.rollbackTransaction(ses);
            }
        } finally {
            // Close the Hibernate session
            util.closeSessionFactory();
        }
    }
}
