package com.nt.entity;

public class bank {
	private String name;
	private String password;
	  private int id;
	public bank() {
		super();
		// TODO Auto-generated constructor stub
	}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	public bank(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "bank [id "+id+"name=" + name + ", password=" + password + "]" ;
	}

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

}
