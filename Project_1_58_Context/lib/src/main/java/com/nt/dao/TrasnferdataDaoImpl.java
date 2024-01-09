package com.nt.dao;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.product;
import com.nt.util.OracleUtil;
import com.nt.util.util;

public class TrasnferdataDaoImpl implements TransferDataDao {

	@SuppressWarnings("finally")
	public String transferProductbyId(int pid) {
		// TODO Auto-generated method stub
		// load product from oracle db s/w
		Session oses = null, sqlses = null;
		oses = OracleUtil.getSesion();
		sqlses = util.getSesion();
		product p = null;
		Transaction tx = null;
		int idVal = 0;
		var flag = false;// java 10 local variable type reference compiler decides the data type based on
							// the intial value assigned;
		OracleUtil.beginTransaction(oses);
		p = oses.get(product.class, pid);
		if (p == null) {
			return "no record found";
		} else 
		{
			try 
			{
				util.beginTransaction(sqlses);
				idVal = (int) sqlses.save(p);
				flag = true;
			} catch (HibernateException he) {
				he.printStackTrace();
				flag = false;
			} finally
			{
				if (flag)
				{
					util.commitTransaction(sqlses);
					return "record copied from oracle to mysql" + idVal;
				} else {
					util.rollbackTransaction(sqlses);
					return "record not copied from oracle to mysql";
				}
			}
		}

	}

}
