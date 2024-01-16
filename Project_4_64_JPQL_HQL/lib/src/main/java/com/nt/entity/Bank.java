package com.nt.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import antlr.Version;

public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	private int aid;
	private String name;
	private double balance;
	private String type;
	private LocalDateTime DateOfOpen;
	private Timestamp LastUpdated;

	public Bank() {
		// TODO Auto-generated constructor stub
		System.out.println("Bank::0-param constructor " + this.getClass().getName());
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getDateOfOpen() {
		return DateOfOpen;
	}

	public void setDateOfOpen(LocalDateTime dateOfOpen) {
		DateOfOpen = dateOfOpen;
	}

	public Timestamp getLastUpdated() {
		return LastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		LastUpdated = lastUpdated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bank [aid=" + aid + ", name=" + name + ", balance=" + balance + ", type=" + type + ", DateOfOpen="
				+ DateOfOpen + ", LastUpdated=" + LastUpdated + "]";
	}

}