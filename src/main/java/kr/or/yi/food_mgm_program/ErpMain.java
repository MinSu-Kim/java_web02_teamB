package kr.or.yi.food_mgm_program;

import java.awt.EventQueue;

import kr.or.yi.food_mgm_program.ui.LoginFrame;

public class ErpMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
