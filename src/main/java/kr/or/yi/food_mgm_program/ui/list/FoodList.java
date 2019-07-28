package kr.or.yi.food_mgm_program.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.food_mgm_program.dto.Food;

@SuppressWarnings("serial")
public class FoodList extends AbstractList<Food> {

	public FoodList(String title) {
		super("음식");
	}

	@Override
	protected void tableAlignmentAndWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3);
	}

	@Override
	protected Object[] toArray(int idx) {
		Food food = itemList.get(idx);
		return food.toArray2();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"음식종류","음식번호","음식명","가격"};
	}


}
