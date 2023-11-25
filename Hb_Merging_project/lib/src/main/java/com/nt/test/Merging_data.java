package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.bank;
import com.nt.utility.util;

public class Merging_data 
{
public static void main(String[] args)
{
	Object m1 = null;
Session ses=null;
bank ac=null;
ses=util.getSesion();
ac=new bank();
Transaction tx=null;
boolean flag=true;
ac.setId(104);
ac.setName("hfi");
try
{
	util.beginTransaction(ses);
	m1=ses.merge(ac);
	flag=true;
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
System.out.println("object updated");
System.out.println(ac);

}
else 
{
	util.rollbackTransaction(ses);
	System.out.println("object not updated");

}

util.closeSession(ses);
util.getSessionFactory();
}
}

}
