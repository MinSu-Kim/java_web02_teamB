package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class PanelSale extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelSale() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
	}

}
