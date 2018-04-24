package com.zhong.www.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class StudentFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrm frame = new StudentFrm();
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
	public StudentFrm() {
		setTitle("HomeStudent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 746);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4FE1\u606F\u67E5\u8BE2");
		menu.setIcon(new ImageIcon(StudentFrm.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 stuActionPerformed(e);
			}
		});
		menuItem_1.setIcon(new ImageIcon(StudentFrm.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		menu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u7CFB\u7EDF");
		menu_2.setIcon(new ImageIcon(StudentFrm.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.setIcon(new ImageIcon(StudentFrm.class.getResource("/com/sun/javafx/webkit/prism/resources/missingImage.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//弹出窗口确认是否退出
				int result = JOptionPane.showConfirmDialog(null, "是否推出系统");
				if(0 == result) {
					dispose();
				}
			}
		});
		menu_2.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1908, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1022, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//设置居中
		this.setLocationRelativeTo(null);
		//最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	protected void stuActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new StuMessageFrm().setVisible(true);
	}
}
