package com.nt.entity;

import org.hibernate.Session;

import com.nt.dao.ProductDAO;
import com.nt.util.util;

public class ProductDAOimpl implements ProductDAO
{

	
	
	@Override
	public ProductDAO getproduct(int pid) {
		// TODO Auto-generated method stub
		Session ses=null;
		ses=util.getSesion();
		product p=null;
		p=ses.get(product.class, pid);
		return (ProductDAO) p;
	}



}
