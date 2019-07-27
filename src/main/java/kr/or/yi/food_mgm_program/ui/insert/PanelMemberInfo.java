package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dto.Grade;
import kr.or.yi.food_mgm_program.dto.Member;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PanelMemberInfo extends JPanel {
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfTel;
	private JDateChooser tfBirth;
	private JPanel pMember;
	private JTextField tfAddr;
	private JPanel panel;
	private JLabel lblImg;
	
	public PanelMemberInfo() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 40, 0, 0));
		add(panel);
		
		lblImg = new JLabel();
		createImage();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(lblImg);		
		
		pMember = new JPanel();
		pMember.setBorder(new EmptyBorder(50, 0, 50, 10));
		add(pMember);
		pMember.setLayout(new GridLayout(0, 2, 10, 15));
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalTextPosition(SwingConstants.LEADING);
		lblId.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblId.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfId = new JTextField();
		tfId.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalTextPosition(SwingConstants.LEADING);
		lblName.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblName.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfName = new JTextField();
		tfName.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblTel.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblTel.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfTel = new JTextField();
		tfTel.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfTel);
		tfTel.setColumns(10);
		
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
		
		tfAddr = new JTextField();
		tfAddr.setFont(new Font("굴림", Font.PLAIN, 15));
		pMember.add(tfAddr);
		tfAddr.setColumns(10);
	}
	
	private void createImage() {
		Image img = new ImageIcon("image/백종원.jpg").getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(img);
		lblImg.setIcon(imageIcon);
	}

	public void clearMemberInfo(int nextNo) {
		tfId.setText(String.format("M%03d", nextNo));
		tfName.setText("");
		tfTel.setText("");
		tfBirth.setDate(new Date());
		tfAddr.setText("");
		tfId.setEditable(false);
	}
	
	public void setMember(Member member) {
		tfId.setText(String.format("M%03d", member.getMbNo()));
		tfName.setText(member.getMbName());
		tfTel.setText(member.getMbTel());
		tfBirth.setDate(member.getMbBirth());
		tfAddr.setText(member.getMbAddress());
	}
	
	public Member getMember() throws Exception {
		validCheck();
		
		int mbNo = Integer.parseInt(tfId.getText().trim().substring(1));
		String name = tfName.getText().trim();
		Date birth = tfBirth.getDate();
		String tel = tfTel.getText().trim();
		String address = tfAddr.getText().trim();
		Grade grade = new Grade("bronze");
		int mileage = 1000;
		
		return new Member(mbNo, name, birth, tel, address, grade, mileage);
	}
	
	private void validCheck() throws Exception {
		if(tfName.getText().equals("")) {
			throw new Exception("이름을 입력하세요.");
		}
		if(tfTel.getText().equals("")) {
			throw new Exception("전화번호를 입력하세요.");
		}
//		if(tfBirth.getText().equals("")) {
//			throw new Exception("생년월일을 입력하세요.");
//		}
	}
}
