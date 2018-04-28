package com.zhong.java.model;
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
	private String flag;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//生成构造方法
	public User(String userName, String password, String flag) {
		super();
		UserName = userName;
		this.flag = flag;
		this.password = password;
	}
	
	public User(String userName, String password) {
		super();
		this.UserName = userName;
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
	public String getflag() {
		return flag;
	}
	public void setflag(String flag) {
		this.flag = flag;
	}
	
	
}
