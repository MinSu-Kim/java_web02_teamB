package kr.or.yi.food_mgm_program.ui.content;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import kr.or.yi.food_mgm_program.service.PanelReservationService;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelCurrentReservation;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelInputReservation;

public class PanelReservation extends JPanel {
	private PanelReservationService service;
	
	public PanelReservation() {
		service = PanelReservationService.getInstance();
		
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(20, 0));
		PanelInputReservation panel = new PanelInputReservation();
		PanelCurrentReservation panel_1 = new PanelCurrentReservation();
		
		panel_1.setPInput(panel);
		
		panel.setService(service);
		panel.setPCR(panel_1);
		
		panel.setPreferredSize(new Dimension(700, 300));
		add(panel, BorderLayout.WEST);
		add(panel_1, BorderLayout.CENTER);
		
	}

}
