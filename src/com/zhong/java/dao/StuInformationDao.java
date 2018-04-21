package com.zhong.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zhong.java.model.StuInformation;
import com.zhong.www.util.StringNull;

/**
 * ѧ��dao��
 * @author zhong
 *
 */
public class StuInformationDao {
	
	/**
	 * ѧ����Ϣ���
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
 	 * ѧ����Ϣ��ѯ
 	 * @param con
 	 * @param StuInformation
 	 * @return
 	 * @throws Exception
 	 */
 	public ResultSet list(Connection con, StuInformation StuInformation)throws Exception{
 		StringBuffer sb = new StringBuffer("select * from t_stuInformation");
 		if(StringNull.isNoEmply(StuInformation.getStuNum())) {
 			//ģ����ѯ
 			sb.append(" and stuNum like '%"+StuInformation.getStuNum()+"%'");
 		}
 		if(StringNull.isNoEmply(StuInformation.getStuName())) {
 			sb.append(" and stuName like '%" +StuInformation.getStuName()+"%'");
 		}
 		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
 	}
 	
 	
 	
}








