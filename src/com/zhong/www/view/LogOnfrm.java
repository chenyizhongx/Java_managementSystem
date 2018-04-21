package com.zhong.www.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zhong.java.dao.UserDao;
import com.zhong.java.model.User;
import com.zhong.www.util.DbUtil;
import com.zhong.www.util.StringNull;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/com/zhong/www/image/hat.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 33));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 25));
		
		UserNameTxt = new JTextField();
		UserNameTxt.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		UserNameTxt.setColumns(10);
		
		JButton logIn = new JButton("\u767B\u5F55");
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginActionPerformed(arg0);
			}
		});
		logIn.setFont(new Font("宋体", Font.PLAIN, 20));
		logIn.setForeground(new Color(0, 0, 128));
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});
		reset.setFont(new Font("宋体", Font.PLAIN, 20));
		reset.setForeground(new Color(0, 0, 128));
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(149)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
					.addGap(127))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(175)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(reset, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(logIn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_2)
								.addGap(18)
								.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addGap(17)
								.addComponent(UserNameTxt, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(UserNameTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(logIn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(reset, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//设置居中
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录事件处理
	 * @param arg0
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String UserName = this.UserNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		
		if(StringNull.isEmply(UserName)) {
			//输出信息后结束方法
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringNull.isEmply(password)) {
			//输出信息后结束方法
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}	   
		User user = new User(UserName,password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser != null) {  
				dispose();
				//JOptionPane.showMessageDialog(null, "登录成功！");
				new TeacherFrm().setVisible(true);
				
			}else{  
				JOptionPane.showMessageDialog(null, "密码或用户名错误！");
			}  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重置事件处理
	 * @param arg0
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.UserNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}






