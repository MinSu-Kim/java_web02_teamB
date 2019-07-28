package kr.or.yi.food_mgm_program.ui.content.seatMgm.seat;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class PanelCurrent extends JPanel {
	private PanelSeat seat; 
	private JPanel panel;
	
	public PanelCurrent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(0, 2, 20, 0));
		
		JLabel lblNewLabel = new JLabel("빈 좌석");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
	}
	
	public void addLabel() {
		panel.removeAll();
		List<String> list = seat.getEmptyPanel();
		if(list==null) {
			return;
		}
		for(int i=0; i<list.size(); i++) {
			JLabel label = new JLabel();
			label.setText(list.get(i));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label);
		}
		
	}
	public void setSeat(PanelSeat seat) {
		this.seat = seat;
	}
	

}
