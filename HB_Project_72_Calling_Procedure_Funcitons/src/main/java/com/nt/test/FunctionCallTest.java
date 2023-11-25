package com.nt.test;

import java.util.List;

import com.nt.dao.IInsurancePolicyDAO;
import com.nt.dao.InsurancePolicy;

public class FunctionCallTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IInsurancePolicyDAO dao=null;
		List<InsurancePolicy> list=null;
		String result[]=null;
		dao=new InsurancePolicy();
		list=dao.getPoliciesByTenure(20,35);
		list.forEach(System.out::println);
		System.out.println("::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::::::::::::::::::::");
		result=dao.getPolicyById(9003);
		System.out.println(result[0]+" "+result[1]+" "+result[2]+" ");
	}

}
