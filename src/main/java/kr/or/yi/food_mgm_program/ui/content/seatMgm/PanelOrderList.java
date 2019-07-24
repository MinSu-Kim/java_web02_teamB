package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PanelOrderList extends JPanel {

	public PanelOrderList() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
	}
	

}
