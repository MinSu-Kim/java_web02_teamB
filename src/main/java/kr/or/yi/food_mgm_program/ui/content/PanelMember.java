package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import kr.or.yi.food_mgm_program.ui.list.memberList;
import java.awt.FlowLayout;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.dto.Grade;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.MemberCoupon;
import kr.or.yi.food_mgm_program.service.PanelMCouponService;
import kr.or.yi.food_mgm_program.service.PanelMemberService;
import kr.or.yi.food_mgm_program.ui.insert.PanelMemberInfo;
import javax.swing.border.EmptyBorder;

import com.mysql.fabric.xmlrpc.base.Data;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

@SuppressWarnings("serial")
public class PanelMember extends JPanel implements ActionListener {
	private JTextField tfSearch;
	
	private memberList pMemberList;
	private PanelMemberInfo pMember;
	private PanelMemberService service;
	private List<Member> list;
	private List<Member> listNM;
	private JPanel pInsert;
	private JPanel pList;
	private JButton btnJoin;
	private JButton btnCancel;
	private JButton btnSearch;
	private JButton btnList;
	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	private JMenuItem mntmTrans;
	private JMenuItem mntmCouponPlus;
	private JMenuItem mntmCouponMinus;
	private JButton btnNomem;
	private JButton btnAll;
	private JDialog couponDialog;
	private JPanel dialogContentPanel = new JPanel();
	private JComboBox<Coupon> couponBox; 
	private DefaultComboBoxModel<Coupon> DcouponBox;
	private Member member;

	private JButton btnAdd; 
	
	public JPanel getpList() {
		return pList;
	}

	public PanelMember() {
		service = PanelMemberService.getInstance();
		list = service.selectMemberByAll();
		listNM = service.selectMemberByAllNM();
		couponDialog = new JDialog();
		createJDialog();
		
		
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pInsert = new JPanel();
		add(pInsert, BorderLayout.WEST);
		pInsert.setLayout(new BorderLayout(0, 0));
		
		pMember = new PanelMemberInfo();
		lastNum();
		pMember.setBorder(new EmptyBorder(50, 0, 0, 50));
		pInsert.add(pMember, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		pInsert.add(pBtns, BorderLayout.SOUTH);
		pBtns.setLayout(new BorderLayout(0, 0));
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(0, 50, 50, 50));
		pBtns.add(pBtn, BorderLayout.NORTH);
		
		btnJoin = new JButton("가입");
		btnJoin.setBorder(new EmptyBorder(20, 30, 20, 30));
		btnJoin.addActionListener(this);
		
		btnNomem = new JButton("비회원등록");
		btnNomem.addActionListener(this);
		btnNomem.setBorder(new EmptyBorder(20, 15, 20, 15));
		pBtn.add(btnNomem);
		pBtn.add(btnJoin);
		
		btnCancel = new JButton("취소");
		btnCancel.setBorder(new EmptyBorder(20, 30, 20, 30));
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pList = new JPanel();
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		pSearch.setBorder(new EmptyBorder(0, 0, 0, 10));
		FlowLayout fl_pSearch = (FlowLayout) pSearch.getLayout();
		fl_pSearch.setAlignment(FlowLayout.RIGHT);
		pList.add(pSearch, BorderLayout.NORTH);
		
		tfSearch = new JTextField();
		tfSearch.setBorder(new EmptyBorder(10, 10, 10, 10));
		tfSearch.registerKeyboardAction(this, "search", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		pSearch.add(tfSearch);
		tfSearch.setColumns(30);
		
		btnSearch = new JButton("검색");
		btnSearch.setActionCommand("search"); //해당 버튼에 부여할 액션명령에 대한 명칭을 부여한다.
		btnSearch.addActionListener(this);
		btnSearch.setBorder(new EmptyBorder(10, 20, 10, 20));
		pSearch.add(btnSearch);
		
		btnList = new JButton("회원보기");
		btnList.addActionListener(this);
		btnList.setBorder(new EmptyBorder(10, 20, 10, 20));
		pSearch.add(btnList);
		
		btnAll = new JButton("전체보기");
		btnAll.addActionListener(this);
		btnAll.setBorder(new EmptyBorder(10, 20, 10, 20));
		pSearch.add(btnAll);
		
		pMemberList = new memberList((String) null);
		pList.add(pMemberList, BorderLayout.CENTER);
		reloadList();
		
		popupMenu = new JPopupMenu();
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);

		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);
		
		mntmTrans = new JMenuItem("회원전환");
		mntmTrans.addActionListener(this);
		popupMenu.add(mntmTrans);
		
		mntmCouponPlus = new JMenuItem("쿠폰추가");
		mntmCouponPlus.addActionListener(this);
		popupMenu.add(mntmCouponPlus);
		
		mntmCouponMinus = new JMenuItem("쿠폰삭제");
		mntmCouponMinus.addActionListener(this);
		popupMenu.add(mntmCouponMinus);
		

		pMemberList.setPopupMenu(popupMenu);
	}
	
	private void createJDialog() {
		
		couponDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		couponDialog.setBounds(100, 100, 348, 99);
		couponDialog.setLayout(new BorderLayout());
		dialogContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		couponDialog.add(dialogContentPanel, BorderLayout.CENTER);
		dialogContentPanel.setLayout(null);
		couponBox = new JComboBox<Coupon>();
		couponBox.setBounds(19, 10, 179, 38);
		dialogContentPanel.add(couponBox);
		btnAdd = new JButton("쿠폰추가");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(210, 10, 97, 38);
		dialogContentPanel.add(btnAdd);
		
	}
	private void setCouponBox(List<Coupon> couponList) {
		DcouponBox = new DefaultComboBoxModel<Coupon>(new Vector<Coupon>(couponList));
		couponBox.setModel(DcouponBox);
		
	}
	
	public void reloadList() {
		list = service.selectMemberByAll();
		
		pMemberList.setItemList(list);
		pMemberList.reloadData();
		lastNum();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAll) {
			actionPerformedBtnAll(e);
		}
		if (e.getSource() == btnNomem) {
			try {
				actionPerformedBtnNomem(e);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		if (e.getSource() == btnList) {
			actionPerformedBtnList(e);
		}
		if (e.getActionCommand() == "search") {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnJoin) {
			try {
				if(e.getActionCommand().equals("가입")) {
						actionPerformedBtnJoin(e);
				}else if(e.getActionCommand().equals("수정")) {
					actionPerformedBtnUpdate(e);
				}else if(e.getActionCommand().equals("회원전환")) {
					actionPerformedBtnTrans(e);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				//e1.printStackTrace();
			}
		}
		if (e.getSource() == mntmDelete) {
			actionPerformedMntmDelete(e);
		}
		if (e.getSource() == mntmUpdate) {
			actionPerformedMntmUpdate(e);
		}
		if(e.getSource() == mntmTrans) {
			actionPerformedMntmTrans();
		}
		if(e.getSource() == mntmCouponPlus) {
			actionPerformedMntmCouponPlus();
		}
		if(e.getSource() == mntmCouponMinus) {
			actionPerformedMntmCouponMinus();
		}
		if(e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("쿠폰추가")) {
				actionPerformedMntmCouponAdd();
			}else if(e.getActionCommand().equals("쿠폰삭제")) {
				actionPerformedMntmCouponCancel();
			}
		}
		
	}
	
	private void actionPerformedMntmCouponCancel() {
		// 회원번호랑 쿠폰이름 받아서 membercoupon테이블에서 삭제.
		
		int a = JOptionPane.showConfirmDialog(null, "쿠폰을 삭제 하시겠습니까?");
		if(a==0) {
			Coupon coupon = (Coupon) couponBox.getSelectedItem();
			String couponName = coupon.getCpName();
			coupon.setCpName(couponName);
			MemberCoupon memberCoupon = new MemberCoupon();
			memberCoupon.setCpNo(coupon);
			memberCoupon.setMbNo(member);
			service.deleteByMbNo(memberCoupon);
			reloadList();
			couponDialog.setVisible(false);
		}else {
			return;
		}
		
		
	}

	private void actionPerformedMntmCouponAdd() {
		//회원번호랑 쿠폰이름 받아서 membercoupon테이블에 추가
		int a = JOptionPane.showConfirmDialog(null, "쿠폰을 추가 하시겠습니까?");
		if(a==0) {
			Coupon coupon = (Coupon) couponBox.getSelectedItem();
			String couponName = coupon.getCpName();
			coupon.setCpName(couponName);
			MemberCoupon memberCoupon = new MemberCoupon();
			memberCoupon.setCpNo(coupon);
			memberCoupon.setMbNo(member);
			service.insertMemberCoupon(memberCoupon);
			reloadList();
			couponDialog.setVisible(false);
		}else {
			return;
		}
	}

	
	
	private void actionPerformedMntmCouponMinus() {
		//쿠폰 삭제
		//보유하고 있는 쿠폰이 나와야함.
		Member member = pMemberList.getSelectedItem();
		this.member = member;
		MemberCoupon memberCoupon = new MemberCoupon();
		memberCoupon.setMbNo(member);
		List<MemberCoupon> list = service.selectByMbNo(memberCoupon);
		List<Coupon> couponList = new ArrayList<Coupon>();
		
		for(MemberCoupon mc : list) {
			Coupon coupon = mc.getCpNo();
			couponList.add(coupon);
		}
		setCouponBox(couponList);
		btnAdd.setText("쿠폰삭제");
		couponDialog.setVisible(true);
		
	}

	private void actionPerformedMntmCouponPlus() {
		//쿠폰 추가
		//보유하지 않은 쿠폰이 나와야함.
		Member member = pMemberList.getSelectedItem();
		this.member = member;
		
		MemberCoupon memberCoupon = new MemberCoupon();
		memberCoupon.setMbNo(member);
		List<MemberCoupon> list = service.selectByMbNo(memberCoupon);
		
		List<Coupon> couponList = service.selectByCouponAll();
		
		for(MemberCoupon mc : list) {
			Coupon coupon = mc.getCpNo();
			couponList.remove(coupon);
		}
		setCouponBox(couponList);
		btnAdd.setText("쿠폰추가");
		couponDialog.setVisible(true);
	}

	private void actionPerformedBtnTrans(ActionEvent e) throws Exception {
		Member member = pMember.getMember(e);
		Member member2 = new Member(member.getMbNo());
		Coupon coupon = new Coupon("회원가입쿠폰");
		MemberCoupon memberCoupon = new MemberCoupon(coupon, member2);
		
		member.setMbWithdrawal(true);
		member.setMbMileage(1000);
		member.setMbGrade(new Grade("bronze"));
		service.updateTrnasMember(member);
		service.insertMemberCoupon(memberCoupon);
		reloadList();
		btnJoin.setText("가입");
	}

	private void actionPerformedMntmTrans() {
		Member member = pMemberList.getSelectedItem();
		if(member.isMbWithdrawal() == true) {
			JOptionPane.showMessageDialog(null, "이미 회원입니다.");
		}else {
			pMember.setMember(member);
			btnJoin.setText("회원전환");
		}
	}

	private void actionPerformedBtnUpdate(ActionEvent e) throws Exception { // 수정버튼 누를때
		Member member = pMember.getMember(e);
		member.setMbWithdrawal(true);
		service.updateMember(member);
		reloadList();
		btnJoin.setText("가입");
	}

	private void actionPerformedMntmUpdate(ActionEvent e) {
		Member member = pMemberList.getSelectedItem();
		pMember.setMember(member);
		pMember.setEditable();
		btnJoin.setText("수정");
	}

	private void actionPerformedMntmDelete(ActionEvent e) {
		Member member = pMemberList.getSelectedItem();
		member.setMbWithdrawal(false);
		service.deleteMember(member);
		reloadList();
	}

	protected void actionPerformedBtnJoin(ActionEvent e) throws Exception { // 가입버튼 누를때.
//		Map<String, Object> map = pMember.getMember(e);
//		Member member = (Member) map.get("member");
//		MemberCoupon membercoupon = (MemberCoupon) map.get("memberCoupon");
		
		Member member = pMember.getMember(e);
		Member member2 = new Member(member.getMbNo());
		Coupon coupon = new Coupon();
		coupon.setCpName("회원가입쿠폰");
		MemberCoupon memberCoupon = new MemberCoupon(coupon, member2);
		
		if(service.selectByNameTel(member)!=null) {
			JOptionPane.showMessageDialog(null, "이미 가입되어있습니다.");
			return;
		}
		member.setMbWithdrawal(true);
		service.insertMember(member);
		service.insertMemberCoupon(memberCoupon);
		reloadList();
		
		//가입 버튼 누를때 member_coupon 테이블에 회원번호랑 회원가입 쿠폰 들어가게함.
		// 회원 중복체크도 하고.
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		btnJoin.setText("가입");
		lastNum();
	}

	public void lastNum() {
		int lastNo = 0;
		listNM = service.selectMemberByAllNM();
		if(listNM.size()==0) {
			lastNo=1;
		}else {
			lastNo = listNM.size()+1;	
		}
		pMember.clearMemberInfo(lastNo);
	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		if(tfSearch.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "검색어를 입력하세요.");
		}else {
			Member member = new Member();
			member.setMbTel(tfSearch.getText());
			
			list = service.selectMemberByTel(member);
			if(list.size() == 0) {
				JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				actionPerformedBtnList(e);
			}else {
				pMemberList.setItemList(list);
				pMemberList.reloadData();
			}
		}
		lastNum();
		btnJoin.setText("가입");
	}
	
	protected void actionPerformedBtnList(ActionEvent e) {
		reloadList();
		tfSearch.setText("");
		btnJoin.setText("가입");
	}
	
	protected void actionPerformedBtnNomem(ActionEvent e) throws Exception {//비회원 등록
		Member member = pMember.getNoMember();
		service.insertMember(member);
		reloadList();
	}
	
	protected void actionPerformedBtnAll(ActionEvent e) {
		listNM = service.selectMemberByAllNM();
		pMemberList.setItemList(listNM);
		pMemberList.reloadData();
		btnJoin.setText("가입");
	}
}
