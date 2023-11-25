package com.nt.listener;

import com.nt.util.util;

@WebListener
public class SessionFactoryClosingContextListener {
@Override
public void contextDestroyed(ServletContext sce)
{
	System.out.println("sessionFactory is closed");
util.closeSessionFactory();	
}
}
