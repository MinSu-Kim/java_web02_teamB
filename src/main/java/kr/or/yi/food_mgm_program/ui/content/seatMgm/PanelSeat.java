package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

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
		
		p2 = new PanelSeatOne();
		pC.add(p2);
		
		p3 = new PanelSeatOne();
		pC.add(p3);
		
		p4 = new PanelSeatOne();
		pC.add(p4);
		
		pEmpty = new JPanel();
		pC.add(pEmpty);
		
		pEmpty2 = new JPanel();
		pC.add(pEmpty2);
		
		p5 = new PanelSeatOne();
		pC.add(p5);
		
		p6 = new PanelSeatOne();
		pC.add(p6);
		
		p7 = new PanelSeatOne();
		pC.add(p7);
		
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
	}

}
