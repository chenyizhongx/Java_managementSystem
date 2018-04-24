package com.zhong.www.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;
import com.zhong.java.dao.StuInformationDao;
import com.zhong.java.model.StuInformation;
import com.zhong.java.dao.UserDao;
import com.zhong.java.model.User;
import com.zhong.www.util.DbUtil;
import com.zhong.www.util.StringNull;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class StuManagerFrm extends JInternalFrame {
	private JTable stuTable;
	private JTextField s_stuNum;
	private JTextField s_stuName;
	private JRadioButton maleJrb;
	private JRadioButton femaleJrb;
	
	private DbUtil dbUtil = new DbUtil();
	private StuInformationDao StuInformationDao = new StuInformationDao();
	private UserDao UserDao = new UserDao();
	private JTextField stuNumTxt;
	private JTextField stuNameTxt;
	private JTextField mailTxt;
	private JTextField phoneTxt_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		setBounds(100, 100, 880, 792);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
					.addGap(46))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		stuNumTxt = new JTextField();
		stuNumTxt.setEditable(false);
		stuNumTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		stuNameTxt = new JTextField();
		stuNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		maleJrb = new JRadioButton("\u7537");
		buttonGroup.add(maleJrb);
		maleJrb.setFont(new Font("宋体", Font.BOLD, 20));
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		femaleJrb.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("\u90AE\u7BB1");
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		
		mailTxt = new JTextField();
		mailTxt.setColumns(10);
		
		JLabel phoneTxt = new JLabel("\u7D27\u6025\u8054\u7CFB\u4EBA\u7535\u8BDD");
		phoneTxt.setFont(new Font("宋体", Font.BOLD, 20));
		
		phoneTxt_1 = new JTextField();
		phoneTxt_1.setColumns(10);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				stuDeleteactionPerformed(evt);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 25));
		
		JButton button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				stuUpdateActionPerformed();
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 25));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(stuNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(76)
							.addComponent(label_1)
							.addGap(27)
							.addComponent(stuNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(label_2)
							.addGap(18)
							.addComponent(maleJrb)
							.addGap(31)
							.addComponent(femaleJrb))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3)
									.addGap(28)
									.addComponent(mailTxt, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
									.addGap(60)
									.addComponent(phoneTxt)
									.addGap(43))
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addComponent(button_1)
									.addGap(56)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(phoneTxt_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(button_2)))))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(stuNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(stuNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(maleJrb)
						.addComponent(femaleJrb))
					.addGap(48)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(mailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneTxt_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneTxt))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(24))
		);
		panel_1.setLayout(gl_panel_1);
		
		stuTable = new JTable();
		stuTable.setFont(new Font("宋体", Font.PLAIN, 20));
		stuTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				stuTablemousePressed(met);
			}
		});
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
	 * 学生信息删除事件处理
	 * @param evt
	 */
	private void stuDeleteactionPerformed(ActionEvent evt) {
		String stuNum = this.stuNumTxt.getText();
		if(StringNull.isEmply(stuNum)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return ;
		} 
		int n = JOptionPane.showConfirmDialog(null, "是否确认删除记录?");
		if(n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = StuInformationDao.delete(con, stuNum);
				int deleteUser = UserDao.deleted(con,stuNum);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new StuInformation());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败！");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 学生信息修改事件处理
	 */
	private void stuUpdateActionPerformed() {
		String stuNum = this.stuNumTxt.getText();
		if(StringNull.isEmply(stuNum)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return ;
		} 
		String stuName = this.stuNameTxt.getText();
		String mail = this.mailTxt.getText();
		String phone = this.phoneTxt_1.getText();
		
		if(StringNull.isEmply(stuName)) {
			//输出信息后结束方法
			JOptionPane.showMessageDialog(null, "姓名不能为空！");
			return;
		}
		
		if(StringNull.isEmply(mail)) {
			//输出信息后结束方法
			JOptionPane.showMessageDialog(null, "邮箱不能为空！");
			return;
		}
		
		if(StringNull.isEmply(phone)) {
			//输出信息后结束方法
			JOptionPane.showMessageDialog(null, "电话号码不能为空！");
			return;
		}
		
		String sex = "";
		if(maleJrb.isSelected()) {
			sex = "男";
		}else {
			sex = "女";
		}
		
		StuInformation stuInformation = new StuInformation(stuNum, stuName, sex, mail, phone);
		User user = new User(stuName,stuNum);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int updateStuInformation = StuInformationDao.update(con, stuInformation);
			int updateuser = UserDao.update(con,user);
			if(updateStuInformation == 1) {
				JOptionPane.showMessageDialog(null, "学生信息修改成功！");
				resetValue();
				this.fillTable(new StuInformation());
			}else {
				JOptionPane.showMessageDialog(null, "学生信息修改失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "学生信息修改失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.stuNumTxt.setText("");
		this.stuNameTxt.setText("");
		this.maleJrb.setSelected(true);
		this.mailTxt.setText("");
		this.phoneTxt_1.setText("");
		
	}


	/**
	 * 表格行点击事件处理
	 * @param met
	 */
	private void stuTablemousePressed(MouseEvent met) {
		int row = this.stuTable.getSelectedRow();  //获取选中的行
		this.stuNumTxt.setText((String)stuTable.getValueAt(row, 0));
		this.stuNameTxt.setText((String)stuTable.getValueAt(row, 1));
		String sex = (String)stuTable.getValueAt(row, 2);
		if("男".equals(sex)) {
			this.maleJrb.setSelected(true);
		}else if("女".equals(sex)){
			this.femaleJrb.setSelected(true);
		}
		this.mailTxt.setText((String)stuTable.getValueAt(row, 3));
		this.phoneTxt_1.setText((String)stuTable.getValueAt(row, 4));
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
