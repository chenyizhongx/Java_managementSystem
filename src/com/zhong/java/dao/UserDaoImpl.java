package com.zhong.java.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * �û���½�ӿڵ�ʵ����
 * @author zhong
 *
 */
public class UserDaoImpl implements UserDao{
	 //static File file = new File("user.txt");  
	static File file =new File("C:\\Users\\zhong\\eclipse-workspace\\data","user.txt");

	/*
	 * ��user.txt�ļ��д���"aaa--bbb",����aaaΪ�û�����bbbΪ���룬ͨ�����ø÷�����֤�û���������
	 */
	@Override
	public boolean isLogin(String name, String password) {
		boolean flag = false;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			try {
				while((line = br.readLine())!= null){  
					//���ַ�����--�ֳ�������
				    String[] strings = line.split("--");  
				    if(name.equals(strings[0])&&password.equals(strings[1])){  
				        flag = true;  
				    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return flag;
	}       
}
