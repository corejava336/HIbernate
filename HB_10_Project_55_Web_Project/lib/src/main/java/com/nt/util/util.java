package com.nt.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class util {
	private static SessionFactory sf;
	private static ThreadLocal<Session> Tl = new ThreadLocal();
	static {
		Configuration cfg = null;
		try {
			cfg = new Configuration();
			cfg.configure();
			sf = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();

			// TODO: handle exception
		}
	}// static block

	public static Session getSesion() {
		Session ses = null;
		// get session from ThreadLocal
		ses = Tl.get();
		if (ses == null)
			if (sf != null) {
				ses = sf.openSession();
				Tl.set(ses);
			}
		return ses;

	}

	public static void closeSession() {
		Session ses = null;
		ses = Tl.get();
		if (ses != null) {
			ses.close();
			Tl.remove();
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sf != null) {
			return sf;
		} else
			throw new HibernateException("not created");
	}

	public static void closeSessionFactory() {
		if (sf != null) {
			sf.close();
		}
	}

	public static Transaction beginTransaction(Session ses) {
		if (ses != null) {
			ses.beginTransaction();
		}
		return null;
	}

	public static void commitTransaction(Session ses) {
		if (ses != null) {
			ses.getTransaction().commit();
		}
	}

	public static void rollbackTransaction(Session ses) {
		if (ses != null && ses.getTransaction().isActive()) {
			ses.getTransaction().rollback();
		}
	}

}// class block
