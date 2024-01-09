package com.nt.service;

import com.nt.dao.BankDao;
import com.nt.entity.bank;
import com.nt.entity.items;

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
	}

	public items add(String name, String count, items i) {
		// TODO Auto-generated method stub
		return dao.add(name, count, i);
	}

	public items search(String name) {
		// TODO Auto-generated method stub
		return dao.search(name);
	}

	public items update(String name, String count, items i) {
		// TODO Auto-generated method stub
		return dao.update(name, count, i);
	}

}
