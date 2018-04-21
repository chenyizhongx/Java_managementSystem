package com.zhong.java.model;
/**
 * 学生实体
 * @author zhong
 *
 */
public class StuInformation {
	private int id;
	private String stuNum;
	private String stuName;
	private String sex;
	private String mail;
	private String phone;
	
	public StuInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public StuInformation(String stuNum, String stuName) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
	}




	public StuInformation(String stuNum, String stuName, String sex, String mail, String phone) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.sex = sex;
		this.mail = mail;
		this.phone = phone;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	
}
