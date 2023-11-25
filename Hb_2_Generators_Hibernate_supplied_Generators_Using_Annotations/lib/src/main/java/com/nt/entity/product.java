package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
@Table(name="product")
public final class product implements Serializable
{
private static final long serialVersionUID = 1L;
private  int pid;
private String pname;
private float price;
private float qty;
@Id 
@Column(name="PID")
@Type(type = "int")
//@GenericGenerator(name="gen1",strategy="sequence")
@TableGenerator(name="gen1",
pkColumnName="ID_COL",
valueColumnName="Id_VAL",
pkColumnValue = "PID",
table = "ID_TAB",
initialValue=10,
allocationSize = 5

)
@GeneratedValue(strategy=GenerationType.TABLE)
public int getPid() {
	return pid;
}
public void setPid(int i) {
	this.pid = i;
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
public product(int pid, String pname, float price, float qty) {
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
