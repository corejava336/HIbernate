package com.nt.entity;

import java.io.Serializable;

public class Proj_Id implements Serializable
{

	private static final long serialVersionUID = 1L;
	private Integer pid;
	private Integer projid;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getProjid() {
		return projid;
	}
	public void setProjid(Integer projid) {
		this.projid = projid;
	}
	@Override
	public String toString() {
		return "Proj_Id [pid=" + pid + ", projid=" + projid + "]";
	}

}
