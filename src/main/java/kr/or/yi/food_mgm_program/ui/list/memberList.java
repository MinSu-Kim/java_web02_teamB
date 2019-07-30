package kr.or.yi.food_mgm_program.ui.list;

import kr.or.yi.food_mgm_program.dto.Member;

import java.util.ArrayList;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class memberList extends AbstractList<Member> {
	public memberList(String title) {
		super("회원");
	}

	@Override
	protected void tableAlignmentAndWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 7, 8);
		tableCellAlignment(SwingConstants.RIGHT,6);
		tableSetWidth(100, 100, 100, 150, 250, 100, 100, 150, 100);
	}

	@Override
	protected Object[] toArray(int idx) {
		Member member = itemList.get(idx);
		return member.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"회원번호","회원명","생일","전화번호","주소","등급","마일리지","쿠폰","탈퇴여부"};
	}

	@Override
	protected Object[][] getRows() {
		if (itemList==null) {
			itemList = new ArrayList<>();
		}
		Object[][] rows = new Object[itemList.size()][];
		for (int i = 0; i < itemList.size(); i++) {
			rows[i] = toArray(i);
		}
		
	
		return rows;
	}
}
