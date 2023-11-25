package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.student_entity;
import com.nt.utility.util;

public final class LoadObjectTest1 {

	public static void main(String[] args) {
		
		SessionFactory sf=util.getSessionFactory();
		Session ses =sf.openSession();
		try(sf;ses )
		{//util.getSesion())
			
			student_entity st=ses.get(student_entity.class, 102);
			if(st==null)
			{
				System.out.println("not found");
				
			}
			else
			{
				System.out.println("found");
				System.out.println(st);
			}
			
		}
			
			
		
	}

}
