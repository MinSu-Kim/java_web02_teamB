package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelSeatOne extends JPanel {
	private JPanel pOrder;
	private JPanel pNumber;
	private JPanel pC;
	private JPanel pCC;
	private JPanel pCS;
	private JPanel pN;
	private JPanel pS;
	private JPanel pW;
	private JPanel pE;
	private JLabel lblPrice;
	private JButton btnNumber;

	
	public PanelSeatOne() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pOrder = new JPanel();
		pOrder.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(pOrder, BorderLayout.CENTER);
		pOrder.setLayout(new BorderLayout(0, 0));
		
		pC = new JPanel();
		pC.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pOrder.add(pC, BorderLayout.CENTER);
		pC.setLayout(new BorderLayout(0, 0));
		
		pCC = new JPanel();
		pCC.setBackground(Color.WHITE);
		pCC.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pC.add(pCC, BorderLayout.CENTER);
		
		pCS = new JPanel();
		pC.add(pCS, BorderLayout.SOUTH);
		pCS.setPreferredSize(new Dimension(10, 40));
		pCS.setLayout(new BorderLayout(0, 0));
		
		lblPrice = new JLabel("가격");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pCS.add(lblPrice, BorderLayout.CENTER);
		
		pN = new JPanel();
		pN.setBackground(new Color(205, 133, 63));
		pOrder.add(pN, BorderLayout.NORTH);
		
		pS = new JPanel();
		pS.setBackground(new Color(205, 133, 63));
		pOrder.add(pS, BorderLayout.SOUTH);
		
		pW = new JPanel();
		pW.setBackground(new Color(205, 133, 63));
		pOrder.add(pW, BorderLayout.WEST);
		pW.setPreferredSize(new Dimension(10, 10));
		
		pE = new JPanel();
		pE.setBackground(new Color(205, 133, 63));
		pOrder.add(pE, BorderLayout.EAST);
		pE.setPreferredSize(new Dimension(10, 10));
		
		pNumber = new JPanel();
		pNumber.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(0, 0, 0)));
		add(pNumber, BorderLayout.WEST);
		pNumber.setPreferredSize(new Dimension(70, 10));
		pNumber.setLayout(new BorderLayout(0, 0));
		
		btnNumber = new JButton("no");
		btnNumber.setBackground(new Color(205, 133, 63));
		pNumber.add(btnNumber, BorderLayout.CENTER);
	}
	
	public void setSeatNumber(String number) {
		btnNumber.setText(number);
	}

}







