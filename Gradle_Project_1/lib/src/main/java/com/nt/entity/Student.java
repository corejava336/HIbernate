package com.nt.entity;

public class Student {
	private String name;
	private String password;
	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", password=" + password + ", id=" + id + "]";
	}

	public Student(String name, String password, Integer id) {
		super();
		this.name = name;
		this.password = password;
		this.id = id;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
