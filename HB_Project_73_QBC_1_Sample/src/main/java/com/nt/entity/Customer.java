package com.nt.entity;

public class Customer {
	private Integer id;
	private Integer Age;
	private String name;
	private String Company_name;
	private String Address;

	public Integer getId() {
		return id;
	}

	public Customer() {
		System.out.println("0-param constructor"); // TODO Auto-generated constructor stub
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany_name() {
		return Company_name;
	}

	public void setCompany_name(String company_name) {
		Company_name = company_name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer id=" + id + ", Age=" + Age + ", name=" + name + ", Company_name=" + Company_name
				+ ", Address=" + Address;
	}

	public Customer(Integer id, Integer age, String name, String company_name, String address) {
		super();
		this.id = id;
		Age = age;
		this.name = name;
		Company_name = company_name;
		Address = address;
	}
}