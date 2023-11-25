package com.nt.entity;

import java.io.Serializable;

public class Info implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private Proj_Id id;
	private String pname;
	private String projName;
	private Integer deptno;
	public Proj_Id getId() {
		return id;
	}
	public void setId(Proj_Id id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Info [id=" + id + ", pname=" + pname + ", projName=" + projName + ", deptno=" + deptno + "]";
	}
	
	

}
