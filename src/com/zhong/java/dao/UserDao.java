package com.zhong.java.dao;

import java.io.File;
import java.io.FileReader;

/**
 * �����½�ӿ�
 * @author zhong
 *
 */
public interface UserDao {
	 //ʵ�ֵ�½
	 public abstract boolean isLogin(String name,String password); 
}
