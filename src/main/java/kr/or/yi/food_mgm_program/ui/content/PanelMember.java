package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import kr.or.yi.food_mgm_program.ui.list.memberList;
import java.awt.FlowLayout;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.ui.insert.PanelMemberInfo;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelMember extends JPanel implements ActionListener {
	private JTextField tfSearch;
	
	private memberList pMemberList;
	private PanelMemberInfo pMember;
	private MemberDao dao;
	private List<Member> list;
	private JPanel pInsert;
	private JPanel pList;
	private JButton btnJoin;
	private JButton btnCancel;
	private JButton btnSearch;

	public PanelMember() {
		dao = new MemberDaoImpl();
		list = dao.selectMemberByAll();
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new GridLayout(1, 0, 20, 0));
		
		pInsert = new JPanel();
		add(pInsert);
		pInsert.setLayout(new BorderLayout(0, 0));
		
		pMember = new PanelMemberInfo();
		pMember.clearMemberInfo(list.size()+1);
		pMember.setBorder(new EmptyBorder(50, 0, 0, 0));
		pInsert.add(pMember, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		pInsert.add(pBtns, BorderLayout.SOUTH);
		pBtns.setLayout(new BorderLayout(0, 0));
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(0, 0, 50, 0));
		pBtns.add(pBtn, BorderLayout.NORTH);
		
		btnJoin = new JButton("가입");
		btnJoin.setBorder(new EmptyBorder(20, 100, 20, 100));
		btnJoin.addActionListener(this);
		pBtn.add(btnJoin);
		
		btnCancel = new JButton("취소");
		btnCancel.setBorder(new EmptyBorder(20, 100, 20, 100));
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pList = new JPanel();
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 10));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pList.add(panel_4, BorderLayout.NORTH);
		
		tfSearch = new JTextField();
		tfSearch.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_4.add(tfSearch);
		tfSearch.setColumns(30);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBorder(new EmptyBorder(10, 20, 10, 20));
		panel_4.add(btnSearch);
		
		pMemberList = new memberList((String) null);
		pList.add(pMemberList, BorderLayout.CENTER);
		reloadList();
	}

	public void reloadList() {
		list = dao.selectMemberByAll();
		pMemberList.setItemList(list);
		pMemberList.reloadData();
		pMember.clearMemberInfo(list.size()+1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnJoin) {
			actionPerformedBtnJoin(e);
		}
	}
	
	protected void actionPerformedBtnJoin(ActionEvent e) {
		Member member = pMember.getMember();
		dao.insertMember(member);
		reloadList();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pMember.clearMemberInfo(list.size()==0? 1 : list.size()+1);
	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		Member member = new Member();
		member.setMbTel(tfSearch.getText());
		
		dao.selectMemberByTel(member);
		JOptionPane.showMessageDialog(null, member);
	}
}
