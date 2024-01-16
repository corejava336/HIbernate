package com.nt.entity;


public class student extends person {

	private String college;
	private String branch;
	private float avg;

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public student(Integer id, String name, String address) {
		super(id, name, address);
		// TODO Auto-generated constructor stub
	}

	public student(String college, String branch, float avg) {
		super();
		this.college = college;
		this.branch = branch;
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "student [college=" + college + ", branch=" + branch + ", avg=" + avg + "]";
	}

}