package com.nt.entity;

import java.io.Serializable;

public class student_entity implements Serializable,istudent 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rollno;
	private String name;
	private String city;

	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "student_entity [rollno=" + rollno + ", name=" + name + ", city=" + city + "]";
	}
	
}
