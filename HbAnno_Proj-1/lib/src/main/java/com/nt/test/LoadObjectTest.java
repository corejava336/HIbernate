package com.nt.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.product;
import com.nt.util.util;

public class LoadObjectTest 
{
	public static void main(String[] args)
	{
		Session ses=null;
		ses=util.getSesion();
		Transaction tx=null;
		product p =null;///HbAnno_Proj-1-lib/src/main/java/com/nt/entity/product.java
		boolean flag = false;
		p= new product();
		p.setPid(1);
		p.setPname("name");
		p.setPrice(123);
		p.setQty(111);
		try
		{
			tx=util.beginTransaction(ses);
			flag=true;
			Serializable idvalue = ses.save(p);
			System.out.println(idvalue);
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
			flag=false;
		}finally
		{
			if(flag)
			{
				util.commitTransaction(ses);
			}
			else
			{
				util.rollbackTransaction(ses);
			}
		util.closeSessionFactory();
		util.closeSession(ses);
		
		}
		
	}

}
