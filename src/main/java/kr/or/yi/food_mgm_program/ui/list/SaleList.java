package kr.or.yi.food_mgm_program.ui.list;

import java.util.ArrayList;

import javax.swing.SwingConstants;

import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;

@SuppressWarnings("serial")
public class SaleList extends AbstractList<Payment> {

	public SaleList(String title) {
		super("판매");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void tableAlignmentAndWidth() {
		// no, sale_no, sale_time, order_cnt,  sale_type, name, name
				//번호, 판매번호,판매시간,판매수량,판매종류 ,결제방식,메뉴명,회원명
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 4,6,7);
		tableCellAlignment(SwingConstants.RIGHT, 3,5);
		
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(40, 150, 200,80,150,50,30,30);
		
	}

	@Override
	protected Object[] toArray(int idx) {
		Payment sale = itemList.get(idx);
		return sale.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"판매번호","판매시간","판매메뉴","판매금액","할인정보","할인금액","결제방식","회원","결제상태"};
	}

	@Override
	protected Object[][] getRows() {
		if (itemList==null) {
			itemList = new ArrayList<>();
		}
		Object[][] rows = new Object[itemList.size()+1][];
		for (int i = 0; i < itemList.size(); i++) {
			rows[i] = toArray(i);
		}
		int sum =0;
		int discountSum = 0;
		for(Payment p : itemList) {
			if(p.getPayCancel()==0) {
				sum += p.getPayPrice();
				discountSum += p.getPayDiscountPrice();
			}
		}
		
		rows[itemList.size()] = new Object[]{"","","",String.format("%,d원", sum),"",String.format("%,d원", discountSum),"",""};
		return rows;
	}

	
}
