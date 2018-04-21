package com.zhong.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zhong.java.model.User;

/**
 * 用户dao类
 * @author zhong
 *
 */
public class UserDao{
	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user) throws Exception{
		User resultUser = null;
		String sql="select * from t_user where userName = ? and password = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2,user.getPassword());
		//返回结果集
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}
}
