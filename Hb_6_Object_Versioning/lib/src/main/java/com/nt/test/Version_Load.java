package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Mobile_Customer;
import com.nt.util.util;

public class Version_Load {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Session ses=null;
ses=util.getSesion();
Transaction tx=null;
Mobile_Customer p = new Mobile_Customer();
p=ses.load(Mobile_Customer.class, 1);
boolean flag=false;
try
{
	tx=util.beginTransaction(ses);
	p=ses.load(Mobile_Customer.class, 1);
if(p!=null)
{
	System.out.println("object found " +p);
	p.setCallerTune("lahaaaaaaaaaaaari");
	flag=true;
}
else
{
System.out.println("object not found "+p);	
}
}
catch(HibernateException he)
{
he.printStackTrace();
flag=false;

}
finally
{
	if(flag)
	{
	util.commitTransaction(ses);
	}
	else
	{
	util.rollbackTransaction(ses);	
	}
util.closeSession(ses);
util.closeSessionFactory();
}
}

}
