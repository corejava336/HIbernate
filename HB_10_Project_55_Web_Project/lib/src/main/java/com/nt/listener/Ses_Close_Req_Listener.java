package com.nt.listener;

import com.nt.util.util;

@WebListener
public class Ses_Close_Req_Listener implements ServletRequestListener{
 @Override
 public void requestDestroyed(ServletRequestEvent sre)
 {
	 
	 System.out.println("sessionclsing servletrequest listener.requestDestryed()");
	 util.closeSession();
 }
}
