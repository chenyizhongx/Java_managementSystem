package com.zhong.www.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.sql.Connection;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;

import com.zhong.java.dao.StuInformationDao;
import com.zhong.java.model.StuInformation;
import com.zhong.www.util.DbUtil;
import com.zhong.www.util.StringNull;

import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStuFrm extends JInternalFrame {
	private JTextField StuNumTxt;
	private JTextField NameTxt;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JRadioButton MaleJre;
	private JRadioButton FamaleJre;
	private JTextField EmailTxt;
	private JTextField PhoneNumTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private DbUtil dbUtil = new DbUtil();
	private StuInformationDao StuInformationDao = new StuInformationDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStuFrm frame = new AddStuFrm();
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
	public AddStuFrm() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		try {
			setMaximum(false);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setClosable(true);
		setResizable(true);
		setTitle("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		setBounds(100, 100, 676, 730);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		
		StuNumTxt = new JTextField();
		StuNumTxt.setFont(new Font("����", Font.PLAIN, 25));
		StuNumTxt.setColumns(10);
		
		NameTxt = new JTextField();
		NameTxt.setFont(new Font("����", Font.PLAIN, 25));
		NameTxt.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\u7D27\u6025\u8054\u7CFB\u4EBA\u7535\u8BDD");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 25));
		
		lblNewLabel_3 = new JLabel("\u5E38\u7528\u7535\u5B50\u90AE\u7BB1");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 25));
		
		lblNewLabel_4 = new JLabel("\u6027\u522B");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 30));
		
		MaleJre = new JRadioButton("\u7537");
		buttonGroup.add(MaleJre);
		MaleJre.setSelected(true);
		MaleJre.setFont(new Font("����", Font.PLAIN, 20));
		
		FamaleJre = new JRadioButton("\u5973");
		buttonGroup.add(FamaleJre);
		FamaleJre.setFont(new Font("����", Font.PLAIN, 20));
		
		EmailTxt = new JTextField();
		EmailTxt.setFont(new Font("����", Font.PLAIN, 25));
		EmailTxt.setColumns(10);
		
		PhoneNumTxt = new JTextField();
		PhoneNumTxt.setFont(new Font("����", Font.PLAIN, 25));
		PhoneNumTxt.setColumns(10);
		
		btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stuInActionPerformation(e);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 30));
		
		btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(MaleJre)
							.addGap(32)
							.addComponent(FamaleJre))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(PhoneNumTxt)
								.addComponent(EmailTxt)
								.addComponent(NameTxt)
								.addComponent(StuNumTxt, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
									.addComponent(btnNewButton)))))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(StuNumTxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(NameTxt, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(MaleJre)
						.addComponent(FamaleJre))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(EmailTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(PhoneNumTxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(72))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * �����¼�����
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * ѧ����Ϣ����¼�����
	 * @param e
	 */
	private void stuInActionPerformation(ActionEvent evt) {
		String stuNum = this.StuNumTxt.getText();
		String stuName = this.NameTxt.getText();
		String mail = this.EmailTxt.getText();
		String phone = this.PhoneNumTxt.getText();
		
		if(StringNull.isEmply(stuNum)) {
			//�����Ϣ���������
			JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ�գ�");
			return;
		}
		
		if(StringNull.isEmply(stuName)) {
			//�����Ϣ���������
			JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
			return;
		}
		
		if(StringNull.isEmply(mail)) {
			//�����Ϣ���������
			JOptionPane.showMessageDialog(null, "���䲻��Ϊ�գ�");
			return;
		}
		
		if(StringNull.isEmply(phone)) {
			//�����Ϣ���������
			JOptionPane.showMessageDialog(null, "�绰���벻��Ϊ�գ�");
			return;
		}
		
		String sex = "";
		if(MaleJre.isSelected()) {
			sex = "��";
		}else {
			sex = "Ů";
		}
		
		StuInformation stuInformation = new StuInformation(stuNum, stuName, sex, mail, phone);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addStuInformation = StuInformationDao.add(con, stuInformation);
			if(addStuInformation == 1) {
				JOptionPane.showMessageDialog(null, "ѧ����Ϣ��ӳɹ���");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "ѧ����Ϣ���ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ѧ����Ϣ���ʧ�ܣ�");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		}

	private void resetValue() {
		this.StuNumTxt.setText("");
		this.NameTxt.setText("");
		this.MaleJre.setSelected(true);
		this.EmailTxt.setText("");
		this.PhoneNumTxt.setText("");
		
	}

}
