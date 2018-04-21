package com.zhong.www.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author zhong
 *
 */
public class DbUtil {
	private String dbUrl ="jdbc:mysql://localhost:3306/db_stu";  //���ݿ����ӵ�ַ
	private String dbUserName="root";			//�û���
	private String dbPassword="zhongYi123.";	//����
	private String jdbcName="com.mysql.jdbc.Driver";	//��������
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if(con != null) {
			con.close();
		}
			
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		
	}
	
	
	
	
	
}
