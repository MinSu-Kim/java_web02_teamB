package kr.or.yi.food_mgm_program.ui.list;

import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;

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

	@Override
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
		
	}

	public String ImgName() {
		int i = table.getSelectedRow();
		if(i==-1) {
			return null;
		}
		String imgName = (String) table.getModel().getValueAt(i, 2);
		
		return imgName;
	}

	
	
	
}
