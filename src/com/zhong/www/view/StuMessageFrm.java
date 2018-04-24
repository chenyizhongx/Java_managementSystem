package com.zhong.www.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zhong.java.dao.StuInformationDao;
import com.zhong.java.model.StuInformation;
import com.zhong.www.util.DbUtil;

public class StuMessageFrm extends JFrame {

	private JPanel contentPane;
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
					StuMessageFrm frame = new StuMessageFrm();
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
	public StuMessageFrm() {
		setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setToolTipText("stuTable");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u7D27\u6025\u8054\u7CFB\u4EBA\u7535\u8BDD", "\u90AE\u7BB1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
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
		con = dbUtil.getCon();  
		ResultSet rs = StuInformationDao.list(con, StuInformation);
		while(rs.next()) {
			Vector v = new Vector();  
			v.add(rs.getString("StuNum"));
			v.add(rs.getString("StuName"));
			v.add(rs.getString("Sex"));
			v.add(rs.getString("Mail"));
			v.add(rs.getString("Phone"));
			//dtm.addRow(v);	//将一行添加到模型的末尾。新行将包含null值，除非指定行数据。将生成正在添加的行的通知
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
