package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Mobile_Customer;
import com.nt.util.util;

public class Insert_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Session ses=null;
ses=util.getSesion();
Transaction tx=null;
Mobile_Customer p = new Mobile_Customer();
p.setCallerTune("Adipursh");
p.setCname("Raja");
p.setMobileNo(987651234);
p.setVersionCount(null);
boolean flag = false;
try
{
tx=util.beginTransaction(ses);
int IdValue=(int) ses.save(p);
System.out.println("IdValue Generated" +IdValue );
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
