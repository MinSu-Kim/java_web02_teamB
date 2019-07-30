package kr.or.yi.food_mgm_program.ui.insert;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Sale;

@SuppressWarnings("serial")
public class PanelPaymentInfo extends JPanel {
	private JTextField tfTotalPrice;
	private JTextField tfDiscountPrice;
	private JTextField tfTpReceive;
	private JTextField tfReceive;
	private JTextField tfChange;
	private JTextField tfDisCountInfo;
	private JTextField tfSaleNo;
	private JLabel lblMember;
	private JTextField tfMember;
	private List<Sale> saleList;
	private double disPrice;

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
		
		tfDisCountInfo = new JTextField();
		tfDisCountInfo.setColumns(10);
		add(tfDisCountInfo);
		
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
	
	public void setMemberInfo(Member mem,int sum) {
		System.out.println(mem);
		tfMember.setText(mem.getMbName()+"님("+mem.getMbGrade().getGrade()+")");
	}
	
	public void setDiscountInfoMileage(int mileage,int sum) { 
		tfDisCountInfo.setText("마일리지 : " + mileage + "원");
		tfDiscountPrice.setText(mileage+"원");
		disPrice = sum-mileage;
		tfTpReceive.setText(String.format("%,d원",(int)disPrice));
			
	}
	
	public void setDiscountInfoCoupon(Coupon searchCoupon,int sum) {
		tfDisCountInfo.setText("쿠폰 : " + searchCoupon.getCpName() + "("+searchCoupon.getCpDiscount()+"%)");
		disPrice = sum*((double)searchCoupon.getCpDiscount()/100);
		tfDiscountPrice.setText(String.format("%,d원", (int)disPrice));
		tfTpReceive.setText(String.format("%,d원",(int)(sum-disPrice)));

	}
	
	public void setDiscountInfoGrade(Member mem,int sum) {
		tfDisCountInfo.setText("등급할인 : " + mem.getMbGrade().getGrade()+"(" + mem.getMbGrade().getG_discount()+"%)");
		disPrice = sum*((double)mem.getMbGrade().getG_discount()/100);
		tfDiscountPrice.setText(String.format("%,d원",(int)disPrice));
		tfTpReceive.setText(String.format("%,d원",(int)(sum-disPrice)));
	}
	
	public void setInitWork(int  sum, List<Sale> saleList) {
		this.saleList = saleList;
		tfTotalPrice.setText(String.format("%,d원", sum));
		tfSaleNo.setText(Integer.toString(saleList.get(0).getSaleNo()));
		tfTpReceive.setText(String.format("%,d원", sum));
		
	}
	
	public List<Sale>  getInfo(List<Sale> saleList,Member mem,int type,int sum) {
		for(Sale s : saleList) {
			s.setSaletime(new Date());
			s.setSaleType(type);

			if(mem==null) {
				s.setMbNo(new Member(0));
				s.setSaleDiscountPrice(0);
			}else {
				s.setMbNo(new Member(mem.getMbNo()));
				s.setSaleDiscountPrice(sum-(int)disPrice);
				
			}
			s.setSaleDiscountInfo(tfDisCountInfo.getText());
			
			
			
		}
		return saleList;
	}

}
