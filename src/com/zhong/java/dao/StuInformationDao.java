package com.zhong.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zhong.java.model.StuInformation;
import com.zhong.www.util.StringNull;

/**
 * 学生dao类
 * @author zhong
 *
 */
public class StuInformationDao {
	
	/**
	 * 学生信息添加
	 * @param con
	 * @param StuInformation
	 * @return
	 * @throws Exception
	 */
 	public int add(Connection con, StuInformation StuInformation)throws Exception{
		String sql="insert into t_stuInformation values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,StuInformation.getStuNum());
		pstmt.setString(2,StuInformation.getStuName());
		pstmt.setString(3,StuInformation.getSex());
		pstmt.setString(4,StuInformation.getMail());
		pstmt.setString(5,StuInformation.getPhone());
		
		return pstmt.executeUpdate();
	}
 	
 	/**
 	 * 学生信息查询
 	 * @param con
 	 * @param StuInformation
 	 * @return
 	 * @throws Exception
 	 */
 	public ResultSet list(Connection con, StuInformation StuInformation)throws Exception{
 		StringBuffer sb = new StringBuffer("select * from t_stuInformation");
 		if(StringNull.isNoEmply(StuInformation.getStuNum())) {
 			//模糊查询
 			sb.append(" and stuNum like '%"+StuInformation.getStuNum()+"%'");
 		}
 		if(StringNull.isNoEmply(StuInformation.getStuName())) {
 			sb.append(" and stuName like '%" +StuInformation.getStuName()+"%'");
 		}
 		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
 	}
 	/**
 	 * 学生信息删除
 	 * @param con
 	 * @param id
 	 * @return
 	 * @throws Exception
 	 */
 	public int delete(Connection con,String stuNum)throws Exception{
 		String sql = "delete from t_stuInformation where stuNum = ?";
 		PreparedStatement pstmt = con.prepareStatement(sql);
 		pstmt.setString(1, stuNum);  //将第一个id设成1
 		return pstmt.executeUpdate();
 	}
 	/**
 	 * 学生信息修改
 	 * @param con
 	 * @param stuInformation
 	 * @return
 	 * @throws Exception
 	 */
 	public int update(Connection con,StuInformation stuInformation) throws Exception{
 		String sql = "update t_stuInformation set stuName = ?, sex = ?, mail = ?, phone = ? where stuNum = ?";
 		PreparedStatement pstmt = con.prepareStatement(sql);
 		pstmt.setString(1, stuInformation.getStuName());
 		pstmt.setString(2, stuInformation.getSex());
 		pstmt.setString(3, stuInformation.getMail());
 		pstmt.setString(4, stuInformation.getPhone());
 		pstmt.setString(5, stuInformation.getStuNum());
 		return pstmt.executeUpdate();
 	}
 	
}








