package kr.or.yi.food_mgm_program.ui.list;

import kr.or.yi.food_mgm_program.dto.Member;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class memberList extends AbstractList<Member> {
	public memberList(String title) {
		super("회원");
	}

	@Override
	protected void tableAlignmentAndWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 5, 6);
		tableCellAlignment(SwingConstants.RIGHT,4);
		//tableSetWidth(100, 200);
	}

	@Override
	protected Object[] toArray(int idx) {
		Member member = itemList.get(idx);
		return member.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"회원번호","회원명","생일","전화번호","마일리지","등급","주소"};
	}


}
