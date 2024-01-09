package com.nt.test;

import com.nt.dao.TransferDataDao;
import com.nt.dao.TrasnferdataDaoImpl;
import com.nt.util.OracleUtil;
import com.nt.util.util;

public class Interacting_With_Two_DB_Test {

	public static void main(String[] args)
	{
		//get or create DAO
		TransferDataDao dao=null;
		dao=new TrasnferdataDaoImpl();
		System.out.println(dao.transferProductbyId(16));
		OracleUtil.closeSessionFactory();
		util.closeSessionFactory();

	}

}
