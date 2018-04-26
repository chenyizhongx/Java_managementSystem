 package com.zhong.www.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zhong.java.dao.StuInformationDao;
import com.zhong.java.model.StuInformation;
import com.zhong.www.util.DbUtil;

public class StuInformationFrm extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil = new DbUtil();
	private StuInformationDao StuInformationDao = new StuInformationDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuInformationFrm frame = new StuInformationFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StuInformationFrm() {
		setClosable(true);
		setTitle("\u5B66\u751F\u4FE1\u606F");
		setBounds(100, 100, 954, 620);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(78)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(311, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u90AE\u7BB1", "\u7D27\u6025\u8054\u7CFB\u4EBA\u7535\u8BDD"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new StuInformation());
		
	}	
	
	/** 
	 * 初始化信息列表
	 * @param tuInformation
	 */
	private void fillTable(StuInformation StuInformation) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);  //设置成零行
		Connection con = null;
		try {
		//User user = new User(userName, password);
		con = dbUtil.getCon();  
		ResultSet rs = StuInformationDao.list(con, StuInformation);
		while(rs.next()) {
				Vector v = new Vector();  
				v.add(rs.getString("StuNum"));
				v.add(rs.getString("StuName"));
				v.add(rs.getString("Sex"));
				v.add(rs.getString("Mail"));
				v.add(rs.getString("Phone"));
				dtm.addRow(v);	//将一行添加到模型的末尾。新行将包含null值，除非指定行数据。将生成正在添加的行的通知

		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			dbUtil.closeCon(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}
