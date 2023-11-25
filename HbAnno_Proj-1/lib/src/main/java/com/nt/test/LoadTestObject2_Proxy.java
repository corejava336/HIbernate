package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.iproject;
import com.nt.entity.product;
import com.nt.util.util;

public class LoadTestObject2_Proxy 
{

	public static void main(String[] args) 
	{
		Session ses=null;
		ses=util.getSesion();
		iproject p =new product();
		try
		{
			p=ses.load(product.class,1);
			//System.out.println(p);
			System.out.println(Arrays.toString(p.getClass().getInterfaces()));
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
			System.out.println("record not found");
		}
		finally
		{
			util.closeSessionFactory();
			util.closeSession(ses);
		}
		
	}

}
