package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

public class PanelMemberInfo extends JPanel {
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfBirth;
	private JPanel pMember;
	private JTextField tfAddr;

	/**
	 * Create the panel.
	 */
	public PanelMemberInfo() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		pMember = new JPanel();
		pMember.setBorder(new EmptyBorder(50, 0, 50, 10));
		add(pMember, BorderLayout.CENTER);
		pMember.setLayout(new GridLayout(0, 2, 10, 15));
		
		JLabel lblId = new JLabel("아이디");
		pMember.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfId = new JTextField();
		pMember.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		pMember.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfName = new JTextField();
		pMember.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTel = new JLabel("전화번호");
		pMember.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfTel = new JTextField();
		pMember.add(tfTel);
		tfTel.setColumns(10);
		
		JLabel lblBirth = new JLabel("생년월일");
		pMember.add(lblBirth);
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfBirth = new JTextField();
		pMember.add(tfBirth);
		tfBirth.setColumns(10);
		
		JLabel lblAddr = new JLabel("주소");
		pMember.add(lblAddr);
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfAddr = new JTextField();
		pMember.add(tfAddr);
		tfAddr.setColumns(10);
	}

}
