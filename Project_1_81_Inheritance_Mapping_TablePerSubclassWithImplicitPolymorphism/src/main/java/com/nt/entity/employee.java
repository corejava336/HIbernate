package com.nt.entity;

public class employee extends person {

	private String desg;
	private float salary;

	public employee(String desg, float salary, Integer deptno) {
		super();
		this.desg = desg;
		this.salary = salary;
		this.deptno = deptno;
	}

	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public employee(Integer id, String name, String address) {
		super(id, name, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "employee [desg=" + desg + ", salary=" + salary + ", deptno=" + deptno + "]";
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	private Integer deptno;
}
