package com.zhong.www.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zhong.java.dao.StuInformationDao;
import com.zhong.java.model.StuInformation;
import com.zhong.www.util.DbUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuManagerFrm extends JInternalFrame {
	private JTable stuTable;
	private JTextField s_stuNum;
	private JTextField s_stuName;
	
	private DbUtil dbUtil = new DbUtil();
	private StuInformationDao StuInformationDao = new StuInformationDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuManagerFrm frame = new StuManagerFrm();
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
	public StuManagerFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 880, 726);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
					.addGap(46))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		
		stuTable = new JTable();
		scrollPane.setViewportView(stuTable);
		stuTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u90AE\u7BB1", "\u7D27\u6025\u8054\u7CFB\u4EBA\u7535\u8BDD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		stuTable.getColumnModel().getColumn(0).setPreferredWidth(98);
		stuTable.getColumnModel().getColumn(1).setPreferredWidth(82);
		stuTable.getColumnModel().getColumn(3).setPreferredWidth(117);
		stuTable.getColumnModel().getColumn(4).setPreferredWidth(125);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("宋体", Font.BOLD, 20));
		
		s_stuNum = new JTextField();
		s_stuNum.setFont(new Font("宋体", Font.BOLD, 20));
		s_stuNum.setColumns(10);
		
		s_stuName = new JTextField();
		s_stuName.setFont(new Font("宋体", Font.BOLD, 20));
		s_stuName.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stuSearchActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_stuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addComponent(label)
					.addGap(18)
					.addComponent(s_stuName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(51))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(label)
						.addComponent(s_stuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_stuName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new StuInformation());
		
	}
	/**
	 * 学生信息查询事件处理
	 * @param e
	 */
	private void stuSearchActionPerformed(ActionEvent e) {
		String stuName = this.s_stuName.getText();
		String stuNum = this.s_stuNum.getText();
		
		StuInformation stuInformation = new StuInformation(stuNum,stuName);
		this.fillTable(stuInformation); 
	}

	/** 
	 * 初始化信息列表
	 * @param tuInformation
	 */
	private void fillTable(StuInformation StuInformation) {
		DefaultTableModel dtm = (DefaultTableModel) stuTable.getModel();
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
