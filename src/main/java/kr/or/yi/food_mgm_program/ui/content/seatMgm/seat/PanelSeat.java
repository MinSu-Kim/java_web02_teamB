package kr.or.yi.food_mgm_program.ui.content.seatMgm.seat;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class PanelSeat extends JPanel {
	private JPanel pC;
	private PanelSeatOne p1;
	private PanelSeatOne p2;
	private PanelSeatOne p3;
	private PanelSeatOne p4;
	private PanelCurrent pEmpty;
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
	
	public PanelSeat() {

		initComponents();
		
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pC = new JPanel();
		add(pC, BorderLayout.CENTER);
		pC.setLayout(new GridLayout(0, 3, 20, 30));
		
		p1 = new PanelSeatOne();
		pC.add(p1);
		p1.setSeatNumber("no.1");
		
		p2 = new PanelSeatOne();
		pC.add(p2);
		p2.setSeatNumber("no.2");
		
		p3 = new PanelSeatOne();
		pC.add(p3);
		p3.setSeatNumber("no.3");
		
		p4 = new PanelSeatOne();
		pC.add(p4);
		p4.setSeatNumber("no.4");
		
		pEmpty = new PanelCurrent();
		pC.add(pEmpty);
		
		pEmpty2 = new JPanel();
		pC.add(pEmpty2);
		
		p5 = new PanelSeatOne();
		pC.add(p5);
		p5.setSeatNumber("no.5");
		
		p6 = new PanelSeatOne();
		pC.add(p6);
		p6.setSeatNumber("no.6");
		
		p7 = new PanelSeatOne();
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
		
		pEmpty.setSeat(this);
		
		
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
	
	public List<String> getEmptyPanel(){
		List<String> list = new ArrayList<String>();
		if(p1.getEmptyNo()!=null) {
			list.add(p1.getEmptyNo());
		}
		if(p2.getEmptyNo()!=null) {
			list.add(p2.getEmptyNo());
		}
		if(p3.getEmptyNo()!=null) {
			list.add(p3.getEmptyNo());
		}
		if(p4.getEmptyNo()!=null) {
			list.add(p4.getEmptyNo());
		}
		if(p5.getEmptyNo()!=null) {
			list.add(p5.getEmptyNo());
		}
		if(p6.getEmptyNo()!=null) {
			list.add(p6.getEmptyNo());
		}
		if(p7.getEmptyNo()!=null) {
			list.add(p7.getEmptyNo());
		}
		JOptionPane.showMessageDialog(null, list);
		return list;
	}
	public void setEmpty() {
		pEmpty.addLabel();
	}

}














