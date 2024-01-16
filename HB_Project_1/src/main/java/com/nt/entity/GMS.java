package com.nt.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


public class GMS implements Serializable {

	private static final long serialVersionUID = 1L;
	private int aid;
	private String name;
	private String password;
	private LocalDateTime DateOfOpen;
	private Timestamp LastUpdated;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "GMS [aid=" + aid + ", name=" + name + ", password=" + password + ", DateOfOpen=" + DateOfOpen
				+ ", LastUpdated=" + LastUpdated + "]";
	}

	public GMS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GMS(int aid, String name, String password, LocalDateTime dateOfOpen, Timestamp lastUpdated) {
		super();
		this.aid = aid;
		this.name = name;
		this.password = password;
		DateOfOpen = dateOfOpen;
		LastUpdated = lastUpdated;
	}

}