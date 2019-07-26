package kr.or.yi.food_mgm_program;

import java.awt.EventQueue;

import javax.swing.UIManager;

import kr.or.yi.food_mgm_program.ui.LoginFrame;

public class ErpMain {

	public static void main(String[] args) {
		try {
			// select Look and Feel
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			// start application
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			private LoginFrame frame;

			public void run() {
				try {
					frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
