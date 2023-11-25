package com.nt.entity;

import java.io.Serializable;

public class bank implements Serializable
{	private int id;
private String name;
public bank() {
System.out.println("Zero parameter constructor");
	// TODO Auto-generated constructor stub
}
public bank(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
@Override
public String toString() {
	return "bank [id=" + id + ", name=" + name + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
