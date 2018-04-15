package com.zhong.java.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 用户登陆接口的实现类
 * @author zhong
 *
 */
public class UserDaoImpl implements UserDao{
	 //static File file = new File("user.txt");  
	static File file =new File("C:\\Users\\zhong\\eclipse-workspace\\data","user.txt");

	/*
	 * 在user.txt文件中存有"aaa--bbb",其中aaa为用户名，bbb为密码，通过调用该方法验证用户名和密码
	 */
	@Override
	public boolean isLogin(String name, String password) {
		boolean flag = false;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			try {
				while((line = br.readLine())!= null){  
					//将字符串沿--分成两部分
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
