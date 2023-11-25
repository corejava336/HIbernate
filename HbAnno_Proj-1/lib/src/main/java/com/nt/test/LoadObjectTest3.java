package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.product;
import com.nt.util.util;

public class LoadObjectTest3 
{
	public static void main(String[] args) 
	{
		Session ses=null;
		product p=null;
		ses=util.getSesion();
		try
		{
			p=ses.get(product.class,1);
			System.out.println(p);
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		finally
		{
			util.closeSession(ses);
			util.getSessionFactory();
		}
	}
	
	

}
