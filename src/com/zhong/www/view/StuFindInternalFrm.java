package com.zhong.www.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class StuFindInternalFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuFindInternalFrm frame = new StuFindInternalFrm();
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
	public StuFindInternalFrm() {
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 548, 488);

	}
	
	

}
