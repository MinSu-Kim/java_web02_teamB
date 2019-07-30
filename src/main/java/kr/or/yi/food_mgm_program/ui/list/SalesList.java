package kr.or.yi.food_mgm_program.ui.list;

import java.util.ArrayList;

import javax.swing.SwingConstants;

import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;

@SuppressWarnings("serial")
public class SalesList extends AbstractList<SalesStatus> {

	public SalesList(String title) {
		super("판매");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void tableAlignmentAndWidth() {
		// no, sale_no, sale_time, order_cnt,  sale_type, name, name
				//번호, 판매번호,판매시간,판매수량,판매종류 ,결제방식,메뉴명,회원명
		tableCellAlignment(SwingConstants.CENTER, 0, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3,4);
		
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(40, 200, 30,80,50);
		
	}

	@Override
	protected Object[] toArray(int idx) {
		SalesStatus sales = itemList.get(idx);
		return sales.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"순위","음식명","판매수량","판매금액","점유율"};
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
		int count = 0;
		for(SalesStatus s : itemList) {
			sum += s.getSsTotalPrice();
			count += s.getSsCount();
			
		}
		
		rows[itemList.size()] = new Object[]{"","",String.format("%d개", count),String.format("%,d원", sum),sum>0?"100.0%" : "0.0%"};
		return rows;
	}

	
}
