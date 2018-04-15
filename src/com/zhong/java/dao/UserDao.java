package com.zhong.java.dao;

import java.io.File;
import java.io.FileReader;

/**
 * 定义登陆接口
 * @author zhong
 *
 */
public interface UserDao {
	 //实现登陆
	 public abstract boolean isLogin(String name,String password); 
}
