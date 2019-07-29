package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import kr.or.yi.food_mgm_program.dto.Member;

import javax.swing.UIManager;

public class PanelPaymentInfo extends JPanel {
	private JTextField tfTotalPrice;
	private JTextField tfDiscountPrice;
	private JTextField tfTpReceive;
	private JTextField tfReceive;
	private JTextField tfChange;
	private JTextField ftDisCountInfo;
	private JTextField tfSaleNo;
	private JLabel lblMember;
	private JTextField tfMember;

	/**
	 * Create the panel.
	 */
	public PanelPaymentInfo() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACB0\uC81C\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblSaleNo = new JLabel("번호");
		lblSaleNo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSaleNo);
		
		tfSaleNo = new JTextField();
		add(tfSaleNo);
		tfSaleNo.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("총 금액");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalPrice);
		
		tfTotalPrice = new JTextField();
		tfTotalPrice.setColumns(10);
		add(tfTotalPrice);
		
		JLabel lblDiscountPrice = new JLabel("할인 금액");
		lblDiscountPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDiscountPrice);
		
		tfDiscountPrice = new JTextField();
		tfDiscountPrice.setColumns(10);
		add(tfDiscountPrice);
		
		JLabel lblIDiscountInfo = new JLabel("할인정보");
		lblIDiscountInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblIDiscountInfo);
		
		ftDisCountInfo = new JTextField();
		ftDisCountInfo.setColumns(10);
		add(ftDisCountInfo);
		
		JLabel lblToReceive = new JLabel("받을 금액");
		lblToReceive.setHorizontalAlignment(SwingConstants.CENTER);
		lblToReceive.setForeground(Color.RED);
		add(lblToReceive);
		
		tfTpReceive = new JTextField();
		tfTpReceive.setColumns(10);
		add(tfTpReceive);
		
		JLabel lblReceive = new JLabel("받은 금액");
		lblReceive.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblReceive);
		
		tfReceive = new JTextField();
		tfReceive.setColumns(10);
		add(tfReceive);
		
		JLabel lblChange = new JLabel("거스름돈");
		lblChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblChange.setForeground(Color.RED);
		add(lblChange);
		
		tfChange = new JTextField();
		tfChange.setColumns(10);
		add(tfChange);
		
		lblMember = new JLabel("회원 정보");
		lblMember.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMember);
		
		tfMember = new JTextField();
		add(tfMember);
		tfMember.setColumns(10);
	}
	
	public void setMemberInfo(Member mem) {
		tfMember.setText(mem.getMbName()+"님");
	}

}
