package com.zhong.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhong.java.model.StuInformation;
import com.zhong.www.util.StringNull;
import com.zhong.www.view.LogOnFrm;

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
	 * @throws SQLException 
	 * @throws Exception
	 */
 	public int add(Connection con, StuInformation StuInformation) throws SQLException  {
		String sql="insert into t_stuInformation values(null,?,?,?,?,?)";
		PreparedStatement pstmt = null;

			pstmt = con.prepareStatement(sql);
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

 	/**
 	 * 向数据库查询学号是否存在
 	 * @param con
 	 * @param stuInformation
 	 * @return 1   存在
 	 * @return 0   不存在
 	 * @throws SQLException 
 	 */
 	public int isUnique(Connection con,StuInformation StuInformation) throws SQLException {
 		StringBuffer sb = new StringBuffer("select * from t_stuInformation");
 		if(StringNull.isNoEmply(StuInformation.getStuNum())) {
 			//查询学号
 			sb.append(" and stuNum is "+StuInformation.getStuNum()+" ");
 			return 1;
 		}
		return 0;
 	}
 	
 	/**
 	 * 查询登录学生的个人信息 
 	 * @param con
 	 * @param stuInformation
 	 * @return 
 	 * @throws SQLException 
 	 */
// 	public ResultSet stuOwn(Connection con, StuInformation StuInformation)throws Exception{
// 		StringBuffer sb = new StringBuffer("select * from t_stuInformation");
// 		if(StringNull.isNoEmply(StuInformation.getRecordStuNum())) {
// 			//查询
// 			sb.append(" and stuNum is "+StuInformation.getRecordStuNum()+" ");
// 		}
// 		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
//		return pstmt.executeQuery();
// 	}
}








