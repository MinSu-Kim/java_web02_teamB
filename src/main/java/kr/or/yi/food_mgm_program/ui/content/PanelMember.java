package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import kr.or.yi.food_mgm_program.ui.list.memberList;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import kr.or.yi.food_mgm_program.ui.insert.PanelMemberInfo;
import javax.swing.border.EmptyBorder;

public class PanelMember extends JPanel {
	private JTextField tfSearch;

	/**
	 * Create the panel.
	 */
	public PanelMember() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(1, 0, 20, 0));
		
		JPanel pInsert = new JPanel();
		add(pInsert);
		pInsert.setLayout(new BorderLayout(0, 0));
		
		PanelMemberInfo pMember = new PanelMemberInfo();
		pMember.setBorder(new EmptyBorder(30, 0, 0, 0));
		pInsert.add(pMember, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		pInsert.add(pBtns, BorderLayout.SOUTH);
		pBtns.setLayout(new BorderLayout(0, 0));
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(0, 0, 40, 0));
		pBtns.add(pBtn, BorderLayout.NORTH);
		
		JButton btnJoin = new JButton("가입");
		pBtn.add(btnJoin);
		
		JButton btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
		
		JPanel pList = new JPanel();
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 10));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pList.add(panel_4, BorderLayout.NORTH);
		
		tfSearch = new JTextField();
		panel_4.add(tfSearch);
		tfSearch.setColumns(30);
		
		JButton btnSearch = new JButton("검색");
		panel_4.add(btnSearch);
		
		memberList pMemberList = new memberList((String) null);
		pList.add(pMemberList, BorderLayout.CENTER);
	}

}
