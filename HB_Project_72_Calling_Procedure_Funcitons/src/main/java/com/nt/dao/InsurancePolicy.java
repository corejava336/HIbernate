package com.nt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;

public class InsurancePolicy implements IInsurancePolicyDAO {

	@Override
	public List<InsurancePolicy> getPoliciesByTenure(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPolicyById(int id) {
		// TODO Auto-generated method stub
		//get session object
		Transaction tx=null;
		Session ses=null;
		ses=util.getSession();
		if(!ses.getTransaction().isActive())
			tx.=ses.beginTransaction();
		String result[]=ses.doReturningWork()new ReturningWork<String[]>{

	@Override
			public String[] execute(Connection con)throws SQLException{
			//create callable statament object
				java.sql.CallableStatement cs=null;
				String outputs[]=null;
				cs=con.prepareCall("{?=CALL FX_GET_POLICY_DETAILS_BY_ID(?,?,?)}");
				cs.registerOutParameter(1, Types.VARCHAR);)
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.INTEGER);
				cs.setInt(2, id);
				cs.execute();
				outputs=new String[3];
				outputs[0]=cs.getString(1);
				outputs[1]=cs.getString(3);
				outputs[2]=String.valueOf(cs.getInt(4));
			return outputs;
			}
};

return result;
}

}

}
