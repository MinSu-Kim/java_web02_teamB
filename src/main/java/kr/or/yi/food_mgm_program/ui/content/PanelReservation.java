package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;

import kr.or.yi.food_mgm_program.service.PanelReservationService;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelInputReservation;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelCurrentReservation;

public class PanelReservation extends JPanel {
	private PanelReservationService service;
	
	public PanelReservation() {
		service = PanelReservationService.getInstance();
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(20, 0));
		
		PanelInputReservation panel = new PanelInputReservation();
		panel.setService(service);
		panel.setPreferredSize(new Dimension(700, 300));
		add(panel, BorderLayout.WEST);
		
		PanelCurrentReservation panel_1 = new PanelCurrentReservation();
		add(panel_1, BorderLayout.CENTER);
	}

}
