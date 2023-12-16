package com.nt.service;

import com.nt.dao.BankDao;
import com.nt.entity.bank;

public class BankService {
	private BankDao dao;

	public BankService() {
		this.dao = new BankDao();
	}

	public boolean login(String name, String password) {
		return dao.login(name, password);
	}

	public boolean signup(String name, String password, bank bankEntity) {
		return dao.signup(name, password, bankEntity);
		// TODO Auto-generated method stub

	}

}
