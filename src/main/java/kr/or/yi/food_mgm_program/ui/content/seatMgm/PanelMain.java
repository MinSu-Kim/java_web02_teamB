package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelMain extends JPanel {

	private JPanel pC;
	private JPanel pCC;
	private JPanel pCCN;
	private JPanel pCCC;
	private PanelSeat pSeat;
	private JPanel pPay;
	private JPanel pOrder;
	private JPanel pBtn;
	private JPanel pMenu;
	private JPanel pPayment;
	private JButton btnAllCancel;
	private JButton btnSelectCancel;
	private JButton btnPlus;
	private JButton btnMinus;
	private JPanel panel_5;
	private JButton btnCash;
	private JPanel pS;

	
	public PanelMain() {

		initComponents();
	}
	private void initComponents() {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(new BorderLayout(0, 0));
		
		pC = new JPanel();
		add(pC, BorderLayout.CENTER);
		pC.setLayout(new BorderLayout(0, 0));
		
		pCC = new JPanel();
		pC.add(pCC, BorderLayout.CENTER);
		pCC.setLayout(new BorderLayout(0, 0));
		
		pCCN = new JPanel();
		pCC.add(pCCN, BorderLayout.NORTH);
		pCCN.setPreferredSize(new Dimension(100, 30));
		
		pCCC = new JPanel();
		pCC.add(pCCC, BorderLayout.CENTER);
		pCCC.setLayout(new BorderLayout(0, 0));
		
		pSeat = new PanelSeat();
		pCCC.add(pSeat, BorderLayout.CENTER);
		
		pPay = new JPanel();
		pCCC.add(pPay, BorderLayout.WEST);
		pPay.setPreferredSize(new Dimension(300, 30));
		pPay.setLayout(new BoxLayout(pPay, BoxLayout.Y_AXIS));
		
		pOrder = new JPanel();
		pPay.add(pOrder);
		
		pBtn = new JPanel();
		pPay.add(pBtn);
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.X_AXIS));
		
		btnAllCancel = new JButton("전체취소");
		pBtn.add(btnAllCancel);
		
		btnSelectCancel = new JButton("선택취소");
		pBtn.add(btnSelectCancel);
		
		btnPlus = new JButton("+");
		pBtn.add(btnPlus);
		
		btnMinus = new JButton("-");
		pBtn.add(btnMinus);
		
		pMenu = new JPanel();
		pPay.add(pMenu);
		
		pPayment = new JPanel();
		pPay.add(pPayment);
		pPayment.setLayout(new BoxLayout(pPayment, BoxLayout.Y_AXIS));
		
		panel_5 = new JPanel();
		pPayment.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		btnCash = new JButton("결제");
		btnCash.setFont(new Font("굴림", Font.BOLD, 25));
		panel_5.add(btnCash);
		btnCash.setPreferredSize(new Dimension(200, 50));
		
		pS = new JPanel();
		add(pS, BorderLayout.SOUTH);
		pS.setPreferredSize(new Dimension(200, 50));
	}

}
