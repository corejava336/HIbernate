package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
@Entity
@Table
@Proxy(lazy=true,proxyClass=iproject.class)
public final class product implements Serializable,iproject
{
private Integer pid;
private String pname;
private float price;
private float qty;
@Id 
@Column(name="PID")
@Type(type = "int")
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
@Column(name="PNAME")
@Type(type = "string")
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
@Column(name="PRICE")
@Type(type = "float")
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
@Column(name="QTY")
@Type(type = "float")

public float getQty() {
	return qty;
}
public void setQty(float qty) {
	this.qty = qty;
}
public product() {
	super();
	// TODO Auto-generated constructor stub
}
public product(Integer pid, String pname, float price, float qty) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.qty = qty;
}
@Override
public String toString() {
	return "product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
}
}
