package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dao.PostDao;
import kr.or.yi.food_mgm_program.daoImpl.PostDaoImpl;
import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.dto.Grade;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.MemberCoupon;
import kr.or.yi.food_mgm_program.service.PanelMCouponService;
import kr.or.yi.food_mgm_program.service.PanelMemberService;
import kr.or.yi.food_mgm_program.ui.PostFrame;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;

@SuppressWarnings("serial")
public class PanelMemberInfo extends JPanel implements ActionListener {
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfTel;
	private JDateChooser tfBirth;
	private JPanel pMember;
	private JTextField tfAddr;
	private JPanel pAddr;
	private JButton btnSearch;
//	private JPanel panel;
//	private JLabel lblImg;
	
	private PostFrame pFrame;
	private JLabel lblMileage;
	private JTextField tfMileage;
	private List<Coupon> couponList;
	private PanelMCouponService service;
	
	public PanelMemberInfo() {
		service = PanelMCouponService.getInstance();
		couponList = service.selectByCouponAll();
		//JOptionPane.showConfirmDialog(null, couponList);
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
//		panel = new JPanel();
//		panel.setBorder(new EmptyBorder(0, 40, 0, 0));
//		add(panel);
		
//		lblImg = new JLabel();
//		createImage();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//		panel.add(lblImg);		
		
		pMember = new JPanel();
		pMember.setBorder(new EmptyBorder(100, 0, 50, 0));
		add(pMember);
		pMember.setLayout(new GridLayout(0, 2, 10, 15));
		
		JLabel lblId = new JLabel("회원번호");
		lblId.setHorizontalTextPosition(SwingConstants.LEADING);
		lblId.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblId.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfId = new JTextField();
		tfId.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfId);
		tfId.setColumns(15);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalTextPosition(SwingConstants.LEADING);
		lblName.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblName.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfName = new JTextField();
		tfName.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfName);
		tfName.setColumns(15);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblTel.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblTel.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfTel = new JTextField();
		tfTel.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfTel);
		tfTel.setColumns(15);
		
		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalTextPosition(SwingConstants.LEADING);
		lblBirth.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblBirth.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblBirth);
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfBirth = new JDateChooser();
		tfBirth.setDateFormatString("yyyy-MM-dd");
		tfBirth.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfBirth);
		
		JLabel lblAddr = new JLabel("주소");
		lblAddr.setHorizontalTextPosition(SwingConstants.LEADING);
		lblAddr.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblAddr.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblAddr);
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		
		pAddr = new JPanel();
		pMember.add(pAddr);
		pAddr.setLayout(new BorderLayout(0, 0));
		
		tfAddr = new JTextField();
		pAddr.add(tfAddr);
		tfAddr.setFont(new Font("굴림", Font.PLAIN, 15));
		tfAddr.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pAddr.add(btnSearch, BorderLayout.EAST);
		
		lblMileage = new JLabel("마일리지");
		lblMileage.setHorizontalTextPosition(SwingConstants.LEADING);
		lblMileage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMileage.setFont(new Font("굴림", Font.PLAIN, 15));
		lblMileage.setBorder(new EmptyBorder(0, 0, 0, 20));
		pMember.add(lblMileage);
		
		tfMileage = new JTextField();
		tfMileage.setFont(new Font("굴림", Font.PLAIN, 15));
		tfMileage.setColumns(15);
		pMember.add(tfMileage);
		setCbm();
	}
	
//	private void createImage() {
//		Image img = new ImageIcon("image/백종원.jpg").getImage().getScaledInstance(150, 300, Image.SCALE_SMOOTH);
//		ImageIcon imageIcon = new ImageIcon(img);
//		lblImg.setIcon(imageIcon);
//	}

	private void setCbm() {
		DefaultComboBoxModel<Coupon> fkModels = new DefaultComboBoxModel<Coupon>(new Vector<Coupon>(couponList));
	}

	public void clearMemberInfo(int nextNo) {
		tfId.setText(String.format("M%03d", nextNo));
		tfName.setText("");
		tfTel.setText("");
		tfBirth.setDate(null);
		tfAddr.setText("");
		tfMileage.setText("");
		tfId.setEditable(false);
		tfMileage.setEditable(false);
	
	}
	
	public void setEditable() {
		tfMileage.setEditable(true);
		
	}
	
	public void setMember(Member member) {
		tfId.setText(String.format("M%03d", member.getMbNo()));
		tfName.setText(member.getMbName());
		tfTel.setText(member.getMbTel());
		tfBirth.setDate(member.getMbBirth());
		tfAddr.setText(member.getMbAddress());
		tfMileage.setText(member.getMbMileage()+"");
	}
	
	public Member getMember(ActionEvent e) throws Exception {
		validCheck();
		
		int mileage = 0;
		int mbNo = Integer.parseInt(tfId.getText().trim().substring(1));
		String name = tfName.getText().trim();
		Date birth = tfBirth.getDate();
		String tel = tfTel.getText().trim();
		String address = tfAddr.getText().trim();
		Grade grade = new Grade("bronze");
		if(tfMileage.getText().equals("")) {
			mileage = 1000;
		}else {
			mileage = Integer.valueOf(tfMileage.getText());
		}
		
//		Member member = new Member(mbNo);
//		Coupon coupon = new Coupon(2);
//		MemberCoupon memberCoupon = new MemberCoupon(coupon, member);
		Member member2 = new Member(mbNo, name, birth, tel, address, grade, mileage);
		if(e.getActionCommand().equals("가입")||e.getActionCommand().equals("회원전환")) {
			member2.setMbJoin(new Date());
		}
		
//		//JOptionPane.showMessageDialog(null, member2);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("member", member2);
//		map.put("memberCoupon", memberCoupon);
		return member2;
	}
	
	public Member getNoMember() throws Exception {
		validCheck2();
		
		int mbNo = Integer.parseInt(tfId.getText().trim().substring(1));
		String name = tfName.getText().trim();
		String tel = tfTel.getText().trim();
		boolean tf = false;
		
		return new Member(mbNo, name, tel, tf);
	}
	
	private void validCheck() throws Exception {
		validCheck2();
		
		SimpleDateFormat sdfm = new SimpleDateFormat("yyyyMMdd");
		String birth = sdfm.format(tfBirth.getDate());
		String date = sdfm.format(new Date());
		int b = Integer.parseInt(birth);
		int d = Integer.parseInt(date);
		
		if(birth.equals(date)) {
			throw new Exception("생년월일을 입력하세요.");
		}
		if(b > d) {
			throw new Exception("생년월일을 잘못 입력하셨습니다.");
		}
		if(tfAddr.getText().equals("")) {
			throw new Exception("주소를 입력하세요.");
		}
	}

	public void validCheck2() throws Exception {
		if(tfName.getText().equals("")) {
			throw new Exception("이름을 입력하세요.");
		}
		if(tfTel.getText().equals("")) {
			throw new Exception("전화번호를 입력하세요.");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		if(pFrame == null) {
			pFrame = new PostFrame();
			pFrame.setParent(this);
		}
		pFrame.clear();
		pFrame.setVisible(true);
	}
	
	public void setAddr(String addr) {
		tfAddr.setText(addr);
	}
}
