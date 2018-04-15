package com.zhong.java.dao;
/**
 * User 实体
 * @author zhong
 *
 */
public class User {
	
	//User类的成员变量
	private int id;
	private String UserName;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//生成构造方法
	public User(String userName, String password) {
		super();
		UserName = userName;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
