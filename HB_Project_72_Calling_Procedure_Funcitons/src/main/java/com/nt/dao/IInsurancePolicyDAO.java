package com.nt.dao;

import java.util.List;

public interface IInsurancePolicyDAO {

	public List<InsurancePolicy> getPoliciesByTenure(int start,int end);
	public String[] getPolicyById(int id);
}