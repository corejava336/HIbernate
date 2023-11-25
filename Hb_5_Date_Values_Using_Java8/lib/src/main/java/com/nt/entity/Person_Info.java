package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Person_Info implements Serializable 
{

private static final long serialVersionUID = 1L;
private int pid;
private String pname;
private String paddrs;
private LocalDateTime dom;
private LocalDateTime doj;
private LocalDateTime dob;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPaddrs() {
	return paddrs;
}
public void setPaddrs(String paddrs) {
	this.paddrs = paddrs;
}
public LocalDateTime getDob() {
	return dob;
}
public void setDob(LocalDateTime dob) {
	this.dob = dob;
}
public LocalDateTime getDom() {
	return dom;
}
public void setDom(LocalDateTime localDateTime) {
	this.dom = localDateTime;
}
public LocalDateTime getDoj() {
	return doj;
}
public void setDoj(LocalDateTime localDateTime) {
	this.doj = localDateTime;
}
@Override
public String toString() {
	return "Person_Info [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", dob=" + dob + ", dom=" + dom
			+ ", doj=" + doj + "]";
}

}
