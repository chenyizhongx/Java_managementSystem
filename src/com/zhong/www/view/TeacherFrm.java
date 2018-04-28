package com.zhong.www.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JDesktopPane;
import javax.swing.UIManager;

public class TeacherFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Create the frame.
	 */
	public TeacherFrm() {
		setTitle("HomeTeacher");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 808);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4FE1\u606F\u7BA1\u7406");
		menu.setIcon(new ImageIcon(TeacherFrm.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-more-details.png")));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  AddStuFrm addStuFrm = new AddStuFrm();
				  addStuFrm.setVisible(true);
				  table.add(addStuFrm);
			  }
		});
		mntmNewMenuItem.setIcon(new ImageIcon(TeacherFrm.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed.gif")));
		menu.add(mntmNewMenuItem);
		 
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7BA1\u7406\u5B66\u751F\u4FE1\u606F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StuManagerFrm stuManagerFrm = new StuManagerFrm();
				stuManagerFrm.setVisible(true);
				table.add(stuManagerFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(TeacherFrm.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed.gif")));
		menu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF");
		mnNewMenu.setIcon(new ImageIcon(TeacherFrm.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-more-details.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//弹出窗口确认是否退出
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(0 == result) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(TeacherFrm.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		table = new JDesktopPane();
		table.setBounds(0, 0, 1907, 966);
		desktopPane.add(table);
		//设置居中
		this.setLocationRelativeTo(null);
		//最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}


