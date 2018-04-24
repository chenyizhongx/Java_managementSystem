package com.zhong.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zhong.java.model.StuInformation;
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
		String sql="select * from t_user where userName = ? and password = ? and flag = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2,user.getPassword());
		pstmt.setString(3, user.getflag());
		//返回结果集
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setflag(rs.getString("flag"));
		}
		
		return resultUser;
	}
	/**
	 * 学生账号密码创建
	 * @param con
	 * @param User
	 * @return
	 * @throws Exception
	 */
	public int stuLoginAdd(Connection con,User User) throws Exception{
		String sql="insert into t_user values(null,?,?,0)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,User.getUserName());
		pstmt.setString(2,User.getPassword());
		
		return pstmt.executeUpdate();
	}
	
 	/**
 	 * 学生账号密码删除
 	 * @param con
 	 * @param id
 	 * @return
 	 * @throws Exception
 	 */
 	public int deleted(Connection con,String password)throws Exception{
 		String sql = "delete from t_user where password = ?";
 		PreparedStatement pstmt = con.prepareStatement(sql);
 		pstmt.setString(1, password);  //将第一个id设成1
 		return pstmt.executeUpdate();
 	}
 	
 	/**
 	 * 学生账号密码修改
 	 * @param con
 	 * @param stuInformation
 	 * @return
 	 * @throws Exception
 	 */
 	public int update(Connection con,User User) throws Exception{
 		String sql = "update t_user set userName = ? where password = ?";
 		PreparedStatement pstmt = con.prepareStatement(sql);
 		pstmt.setString(1, User.getUserName());
 		pstmt.setString(2, User.getPassword());

 		return pstmt.executeUpdate();
 	}
}
