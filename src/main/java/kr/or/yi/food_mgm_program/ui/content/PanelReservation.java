package kr.or.yi.food_mgm_program.ui.content;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import kr.or.yi.food_mgm_program.service.PanelReservationService;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelCurrentReservation;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelInputReservation;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;

public class PanelReservation extends JPanel {
	private PanelReservationService service;
	private PanelMember pMember;
	private PanelMain pSeat;
	
	public PanelReservation(PanelMember pMember, PanelReservationService service, PanelMain pSeat) {
		this.service = service;
		this.pMember = pMember;
		this.pSeat = pSeat;
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(20, 0));
		PanelInputReservation panel = new PanelInputReservation(pMember, pSeat);
		PanelCurrentReservation panel_1 = new PanelCurrentReservation(pSeat);
		
		panel_1.setPInput(panel);
		
		panel.setService(service);
		panel.setPCR(panel_1);
		
		panel.setPreferredSize(new Dimension(700, 300));
		add(panel, BorderLayout.WEST);
		add(panel_1, BorderLayout.CENTER);
		
	}
	
	

}
