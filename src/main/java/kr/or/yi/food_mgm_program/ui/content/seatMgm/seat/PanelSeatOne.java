package kr.or.yi.food_mgm_program.ui.content.seatMgm.seat;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.service.PanelSeatService;
import kr.or.yi.food_mgm_program.ui.MainFrame;
import kr.or.yi.food_mgm_program.ui.PaymentFrame;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class PanelSeatOne extends JPanel implements ActionListener {
	private JPanel pOrder;
	private JPanel pNumber;
	private JPanel pC;
	private JPanel pCC;
	private JPanel pCS;
	private JPanel pN;
	private JPanel pS;
	private JPanel pW;
	private JPanel pE;
	private JButton btnPrice;
	private JButton btnNumber;
	private JLabel lbl;
	private PanelOrderList pList;
	private List<Food> foodList;
	private PanelMain panelMain;
	private PaymentFrame payFrame;
	private MainFrame frame;
	private Sale sales;
	private PanelSeatService service;
	
	public PanelSeatOne(MainFrame frame) {
		
		this.frame = frame;
		initComponents();
		service = PanelSeatService.getInstance();
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
		pCC.setBackground(SystemColor.control);
		pCC.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pC.add(pCC, BorderLayout.CENTER);
		pCC.setLayout(new GridLayout(0, 1, 0, 0));
		
	
		
		pCS = new JPanel();
		pC.add(pCS, BorderLayout.SOUTH);
		pCS.setPreferredSize(new Dimension(10, 40));
		pCS.setLayout(new BorderLayout(0, 0));
		
		btnPrice = new JButton();
		btnPrice.addActionListener(this);
		btnPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pCS.add(btnPrice, BorderLayout.CENTER);
		
		pN = new JPanel();
		pN.setBackground(SystemColor.activeCaption);
		pOrder.add(pN, BorderLayout.NORTH);
		
		pS = new JPanel();
		pS.setBackground(SystemColor.activeCaption);
		pOrder.add(pS, BorderLayout.SOUTH);
		
		pW = new JPanel();
		pW.setBackground(SystemColor.activeCaption);
		pOrder.add(pW, BorderLayout.WEST);
		pW.setPreferredSize(new Dimension(10, 10));
		
		pE = new JPanel();
		pE.setBackground(SystemColor.activeCaption);
		pOrder.add(pE, BorderLayout.EAST);
		pE.setPreferredSize(new Dimension(10, 10));
		
		pNumber = new JPanel();
		pNumber.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(0, 0, 0)));
		add(pNumber, BorderLayout.WEST);
		pNumber.setPreferredSize(new Dimension(70, 10));
		pNumber.setLayout(new BorderLayout(0, 0));
		
		btnNumber = new JButton("");
		btnNumber.addActionListener(this);
		btnNumber.setBackground(SystemColor.activeCaption);
		pNumber.add(btnNumber, BorderLayout.CENTER);
	}
	
	public void setSeatNumber(String number) {
		btnNumber.setText(number);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrice) {
			actionPerformedBtnPrice(e);
		}
		if (e.getSource() == btnNumber) {
			actionPerformedBtnNumber(e);
		}
	}
	protected void actionPerformedBtnNumber(ActionEvent e) {
		String no = btnNumber.getText();
			pList.setList(foodList);
			pList.setTableNo(no);
			panelMain.setSeatOne(this);
		}
	public void setPcc(List<Food> list) {
		pCC.removeAll();
		if(list==null) {
			return;
		}
		for(Food fd : list) {
			lbl = new JLabel(fd.toString2());
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			pCC.add(lbl);
			
		}
		foodList = list;
		revalidate();
		repaint();
		
	}
	public void setPlist(PanelOrderList plist) {
		this.pList = plist;
	}
	public void setPanelMain(PanelMain main) {
		this.panelMain = main;
	}
	
	public String getNo() {
		return btnNumber.getText();
	}
	
	public void setLblPrice(String price) {
		if(price.equals("")) {
			btnPrice.setText("");
		}else {
			btnPrice.setText(price+"원");
		}
	}
	

	protected void actionPerformedBtnPrice(ActionEvent e) {
		if(e.getActionCommand().equals("")) {
			return;
		}
		
		
		List<Sale> saleList = new ArrayList<Sale>();
		sales = service.selectLastNo();
		int Number = 0;
		if(sales==null) {
			Number = 1;
		}else {
			Number = sales.getSaleNo()+1; // 판매번호
		}
		int sum = 0; //총금액
		for(Food food : foodList) {
			Sale sale = new Sale();
			int foodCount = food.getCount();
			sale.setSaleNo(Number);
			sale.setSaleOrderCnt(foodCount);
			sale.setSaleOrderKind(true);
			sale.setFdNo(food);
			saleList.add(sale);
			 sum += food.getFdPrice()*food.getCount();
		}
		payFrame = new PaymentFrame();
		payFrame.setClear();
		payFrame.setInitWork(sum,saleList);
		payFrame.setMainFrame(frame);
		payFrame.setVisible(true);
		payFrame.setParent(this);
	}
	
	public void btnColor() {
		btnNumber.setBackground(Color.RED);
	}
	public void btnColor2() {
		btnNumber.setBackground(SystemColor.activeCaption);
	}
	
	public void setClear() {
		pCC.removeAll();
		btnPrice.setText("");
		pCC.revalidate();
		pCC.repaint();
		List<Food> list = null;
		pList.setList(list);
		foodList = null;
	}
}







