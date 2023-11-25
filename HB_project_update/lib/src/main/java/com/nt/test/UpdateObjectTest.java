package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.bank;
import com.nt.utility.util;

public class UpdateObjectTest 
{
public static void main(String[] args)
{
	
Session ses=null;
bank ac=null;
ses=util.getSesion();
ac=new bank();
Transaction tx=null;
boolean flag=true;
ac.setId(101);
//ac.setName("hi");
try
{
	util.beginTransaction(ses);
	ses.update(ac);
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
