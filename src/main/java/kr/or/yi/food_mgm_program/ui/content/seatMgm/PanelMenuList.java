package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMenuList extends JPanel{
	private CardLayout cards = new CardLayout();
	private JPanel pCard;
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
		
		pCard = new JPanel();
		pContainer.add(pCard, BorderLayout.CENTER);
		pCard.setLayout(cards);
		
		pMainMenu = new JPanel();
		pCard.add(pMainMenu, "pMain");
		pMainMenu.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		
		pSide = new JPanel();
		pCard.add(pSide, "pSide");
		pSide.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		
		pDrink = new JPanel();
		pCard.add(pDrink, "pDrink");
		pDrink.setLayout(new GridLayout(0, 4, 0, 0));
	}
	

}















