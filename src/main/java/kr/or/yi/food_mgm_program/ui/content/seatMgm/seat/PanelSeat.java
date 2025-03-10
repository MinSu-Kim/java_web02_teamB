package kr.or.yi.food_mgm_program.ui.content.seatMgm.seat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.yi.food_mgm_program.dto.Reservation;
import kr.or.yi.food_mgm_program.service.PanelReservationService;
import kr.or.yi.food_mgm_program.ui.MainFrame;
import kr.or.yi.food_mgm_program.ui.PaymentFrame;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;

public class PanelSeat extends JPanel {
	private JPanel pC;
	private PanelSeatOne p1;
	private PanelSeatOne p2;
	private PanelSeatOne p3;
	private PanelSeatOne p4;
	private JPanel pEmpty;
	private JPanel pEmpty2;
	private PanelSeatOne p5;
	private PanelSeatOne p6;
	private PanelSeatOne p7;
	private JPanel pN;
	private JPanel pS;
	private JPanel pW;
	private JPanel pE;
	private PanelOrderList pList;
	private PanelMain panelMain;
	private MainFrame frame;
	private PanelReservationService service;
	
	public PanelSeat(MainFrame frame) {
		this.frame = frame;
		service = PanelReservationService.getInstance();
		initComponents();
		
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pC = new JPanel();
		add(pC, BorderLayout.CENTER);
		pC.setLayout(new GridLayout(0, 3, 20, 30));
		
		p1 = new PanelSeatOne(frame);
		pC.add(p1);
		p1.setSeatNumber("no.1");
		
		p2 = new PanelSeatOne(frame);
		pC.add(p2);
		p2.setSeatNumber("no.2");
		
		p3 = new PanelSeatOne(frame);
		pC.add(p3);
		p3.setSeatNumber("no.3");
		
		p4 = new PanelSeatOne(frame);
		pC.add(p4);
		p4.setSeatNumber("no.4");
		
		pEmpty = new JPanel();
		pC.add(pEmpty);
		
		pEmpty2 = new JPanel();
		pC.add(pEmpty2);
		
		p5 = new PanelSeatOne(frame);
		pC.add(p5);
		p5.setSeatNumber("no.5");
		
		p6 = new PanelSeatOne(frame);
		pC.add(p6);
		p6.setSeatNumber("no.6");
		
		p7 = new PanelSeatOne(frame);
		pC.add(p7);
		p7.setSeatNumber("no.7");
		
		pN = new JPanel();
		add(pN, BorderLayout.NORTH);
		pN.setPreferredSize(new Dimension(10, 30));
		
		pS = new JPanel();
		add(pS, BorderLayout.SOUTH);
		pS.setPreferredSize(new Dimension(10, 30));
		
		pW = new JPanel();
		add(pW, BorderLayout.WEST);
		pW.setPreferredSize(new Dimension(20, 30));
		
		pE = new JPanel();
		add(pE, BorderLayout.EAST);
		
		setBtnColor();
	}
	public void setBtnColor() {
		Reservation rsv = new Reservation();
		rsv.setRsvTime(new Date());
		List<Reservation> list = service.selectByRangeTime(rsv);
		p1.btnColor2();
		p2.btnColor2();
		p3.btnColor2();
		p4.btnColor2();
		p5.btnColor2();
		p6.btnColor2();
		p7.btnColor2();
		if(list==null || list.size()==0) {
			p1.setRssv(null);
			p2.setRssv(null);
			p3.setRssv(null);
			p4.setRssv(null);
			p5.setRssv(null);
			p6.setRssv(null);
			p7.setRssv(null);
		}
		for(Reservation rssv : list) {
			if(rssv.getRsvTableNo().equals("no.1")) {
				p1.btnColor();
				p1.setRssv(rssv);
			}
			if(rssv.getRsvTableNo().equals("no.2")) {
				p2.btnColor();
				p2.setRssv(rssv);
			}
			if(rssv.getRsvTableNo().equals("no.3")) {
				p3.btnColor();
				p3.setRssv(rssv);
			}
			if(rssv.getRsvTableNo().equals("no.4")) {
				p4.btnColor();
				p4.setRssv(rssv);
			}
			if(rssv.getRsvTableNo().equals("no.5")) {
				p5.btnColor();
				p5.setRssv(rssv);
			}
			if(rssv.getRsvTableNo().equals("no.6")) {
				p6.btnColor();
				p6.setRssv(rssv);
			}
			if(rssv.getRsvTableNo().equals("no.7")) {
				p7.btnColor();
				p7.setRssv(rssv);
			}
		
			
		}
	}
	public void setPanelSeatOne() {
		p1.setPlist(pList);
		p2.setPlist(pList);
		p3.setPlist(pList);
		p4.setPlist(pList);
		p5.setPlist(pList);
		p6.setPlist(pList);
		p7.setPlist(pList);
		p1.setPanelMain(panelMain);
		p2.setPanelMain(panelMain);
		p3.setPanelMain(panelMain);
		p4.setPanelMain(panelMain);
		p5.setPanelMain(panelMain);
		p6.setPanelMain(panelMain);
		p7.setPanelMain(panelMain);
	}
	
	public void setPlist(PanelOrderList plist) {
		this.pList = plist;
	}
	public void setPanelMain(PanelMain main) {
		this.panelMain = main;
	}
	


}














