package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Bank;
import com.nt.util.util;

public class Modification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Session ses=null;
ses=util.getSesion();
Transaction tx=null;
Bank p= new Bank();
p=ses.load(Bank.class, 1);
boolean flag=false;
try
{
	tx=util.beginTransaction(ses);
	p=ses.load(Bank.class, 1);
if(p!=null)
{
	System.out.println("object found " +p);
p.setBalance(p.getBalance()+1000);
	flag=true;
	System.out.println("Before Updating "+p.getBalance()+" "+p.getLastUpdated()+" "+p.getDateOfOpen());
	System.out.println("After Updating "+p.getBalance()+" "+p.getLastUpdated()+" "+p.getDateOfOpen());
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
