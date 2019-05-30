package com.java1234.model;

public class User {
	
	private int id; //编号
	private String userName; //用户名
	private String password; //密码
	
	
	
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
		
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
