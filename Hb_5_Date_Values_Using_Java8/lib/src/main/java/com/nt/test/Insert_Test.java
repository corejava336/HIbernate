package com.nt.test;

import java.sql.Date;
import java.time.LocalDateTime;

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
p.setDob(LocalDateTime.of(90,11,23,12,5,45));
p.setDoj(LocalDateTime.now());
p.setDom(LocalDateTime.of(118,10,12,2,3));
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
