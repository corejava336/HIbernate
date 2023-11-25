package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Person_Info;
import com.nt.util.util;

public class Insert_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Session ses=null;
ses=util.getSesion();
Transaction tx=null;
Person_Info p = new Person_Info();
p.setPname("raja");
p.setPaddrs("madhu madhu");
p.setDob(new Date(90,11,23));
p.setDoj(new java.util.Date());
p.setDom(new Date(118,10,12));
boolean flag = false;
try
{
tx=util.beginTransaction(ses);
ses.save(p);
flag=true;
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
util.closeSession(ses);
util.closeSessionFactory();
}
}

}
