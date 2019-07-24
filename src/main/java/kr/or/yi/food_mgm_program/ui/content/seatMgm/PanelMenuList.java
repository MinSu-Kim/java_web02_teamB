package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMenuList extends JPanel implements ActionListener {
	private JButton btnSideMenu;
	private JButton btnDrink;
	private JButton btnMainMenu;
	private CardLayout cards = new CardLayout();
	private JPanel pCard;
	private JPanel pBtn;
	private JPanel pContainer;
	private JPanel pMainMenu;
	private JPanel pSide;
	private JPanel pDrink;
	
	public PanelMenuList() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pContainer = new JPanel();
		add(pContainer, BorderLayout.CENTER);
		pContainer.setLayout(new BorderLayout(0, 0));
		
		pBtn = new JPanel();
		pContainer.add(pBtn, BorderLayout.NORTH);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnMainMenu = new JButton("주메뉴");
		btnMainMenu.addActionListener(this);
		pBtn.add(btnMainMenu);
		
		btnSideMenu = new JButton("부메뉴");
		btnSideMenu.addActionListener(this);
		pBtn.add(btnSideMenu);
		
		btnDrink = new JButton("음료");
		btnDrink.addActionListener(this);
		pBtn.add(btnDrink);
		
		pCard = new JPanel();
		pContainer.add(pCard, BorderLayout.CENTER);
		pCard.setLayout(cards);
		
		pMainMenu = new JPanel();
		pCard.add(pMainMenu, "pMain");
		pMainMenu.setLayout(new GridLayout(0, 4, 0, 0));
		addMainMenu();
		
		
		pSide = new JPanel();
		pCard.add(pSide, "pSide");
		pSide.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		
		pDrink = new JPanel();
		pCard.add(pDrink, "pDrink");
		pDrink.setLayout(new GridLayout(0, 4, 0, 0));
	}

	private void addMainMenu() {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMainMenu) {
			actionPerformedBtnMainMenu(e);
		}
		if (e.getSource() == btnDrink) {
			actionPerformedBtnDrink(e);
		}
		if (e.getSource() == btnSideMenu) {
			actionPerformedBtnSideMenu(e);
		}
	}
	protected void actionPerformedBtnSideMenu(ActionEvent e) {
		cards.show(pCard, "pDrink");
	}
	protected void actionPerformedBtnDrink(ActionEvent e) {
		cards.show(pCard, "pSide");
	}
	protected void actionPerformedBtnMainMenu(ActionEvent e) {
		cards.show(pCard, "pMain");
	}
}















