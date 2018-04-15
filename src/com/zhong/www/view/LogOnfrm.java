package com.zhong.www.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhong.java.dao.User;
import com.zhong.java.dao.UserDao;
import com.zhong.java.dao.UserDaoImpl;
import com.zhong.www.util.StringNull;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton; 
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DropMode;

public class LogOnfrm extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameTxt;
	private JPasswordField passwordTxt;
	
	private User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnfrm frame = new LogOnfrm();
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
	public LogOnfrm() {
		setResizable(false);
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LogOnfrm.class.getResource("/com/zhong/www/image/hat.png")));
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 33));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("��Բ", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("��Բ", Font.BOLD, 25));
		
		UserNameTxt = new JTextField();
		UserNameTxt.setColumns(10);
		
		JButton logIn = new JButton("\u767B\u5F55");
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginActionPerformed(arg0);
			}
		});
		logIn.setFont(new Font("����", Font.PLAIN, 20));
		logIn.setForeground(new Color(0, 0, 128));
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});
		reset.setFont(new Font("����", Font.PLAIN, 20));
		reset.setForeground(new Color(0, 0, 128));
		
		passwordTxt = new JPasswordField();
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
	}
	/**
	 * ��¼�¼�����
	 * @param arg0
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String UserName = this.UserNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		
		if(StringNull.isEmply(UserName)) {
			//�����Ϣ���������
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			return;
		}
		if(StringNull.isEmply(password)) {
			//�����Ϣ���������
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			return;
		}	 
		UserDaoImpl udi = new UserDaoImpl();  
		User user = new User(UserName,password);
		//�ж��Ƿ��¼�ɹ�
        boolean flag = udi.isLogin(UserName, password);  
        if (flag) {  
			JOptionPane.showMessageDialog(null, "��¼�ɹ���");
        }else{  
			JOptionPane.showMessageDialog(null, "������û�������");
        }  
        
	}

	/**
	 * �����¼�����
	 * @param arg0
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.UserNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}