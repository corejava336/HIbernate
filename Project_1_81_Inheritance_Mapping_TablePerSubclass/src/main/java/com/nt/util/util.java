package com.nt.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class util {
    private static SessionFactory sf;

    static {
        Configuration cfg = null;
        try {
            cfg = new Configuration();
            cfg.configure();
            sf = cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public static Session getSession() {
        Session ses = null;
        try {
            if (sf != null) {
                ses = sf.getCurrentSession();
                if (ses == null || !ses.isOpen()) {
                    ses = sf.openSession();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            // Handle session retrieval exception
        }
        return ses;
    }

    public static SessionFactory getSessionFactory() {
        if (sf != null) {
            return sf;
        } else {
            throw new HibernateException("SessionFactory not created");
        }
    }

    public static void closeSessionFactory() {
        if (sf != null && !sf.isClosed()) {
            sf.close();
        }
    }

    public static Transaction beginTransaction(Session session) {
        if (session != null && !session.getTransaction().isActive()) {
            return session.beginTransaction();
        }
        return null;
    }

    public static void commitTransaction(Session session) {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }
    }

    public static void rollbackTransaction(Session session) {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
    }
}
