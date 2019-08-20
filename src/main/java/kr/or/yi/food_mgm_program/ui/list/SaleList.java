package kr.or.yi.food_mgm_program.ui.list;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelCurrentReservation.ReturnTableCellRenderer;

@SuppressWarnings("serial")
public class SaleList extends AbstractList<Payment> {

	public SaleList(String title) {
		super("판매");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void tableAlignmentAndWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 4, 6, 7, 8);
		tableCellAlignment(SwingConstants.RIGHT, 3, 5);
		tableSetWidth(40, 110, 730, 80, 150, 50, 30, 30);

	}

	@Override
	protected Object[] toArray(int idx) {
		Payment sale = itemList.get(idx);
		return sale.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "판매번호", "판매시간", "판매메뉴", "판매금액", "할인정보", "할인금액", "결제방식", "회원", "결제상태" };
	}

	@Override
	protected Object[][] getRows() {
		if (itemList == null) {
			itemList = new ArrayList<>();
		}
		Object[][] rows = new Object[itemList.size() + 1][];
		for (int i = 0; i < itemList.size(); i++) {
			rows[i] = toArray(i);
		}
		int sum = 0;
		int discountSum = 0;
		for (Payment p : itemList) {
			if (p.getPayCancel() == 0) {
				sum += p.getPayPrice();
				discountSum += p.getPayDiscountPrice();
			}
		}

		rows[itemList.size()] = new Object[] { "", "", "", String.format("%,d원", sum), "",
				String.format("%,d원", discountSum), "", "","" };
		return rows;
	}

	@Override
	protected void tableSetWidth(int... width) {

		for (int i = 0; i < getColumnNames().length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new ReturnTableCellRenderer());
		}

		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	@SuppressWarnings("serial")
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value == null)
				return this;
			setText(value.toString());
			setOpaque(true);

			if(column==0 || column==1 || column==4 || column==6 || column==7 || column==8) {
	            setHorizontalAlignment(CENTER);
	         }else if(column==3 || column==5) {
	            setHorizontalAlignment(RIGHT);
	         }
			
			
			if (table.getValueAt(row, 8).toString().equals("취소")) {
				setForeground(Color.RED);
			} else if(table.getValueAt(row, 8).toString().equals("")){
				setForeground(Color.BLUE);
			}else {
				setForeground(Color.BLACK);
			}
			
			if (isSelected) {
				setBackground(new Color(57, 105, 138));
			} else {
				setBackground(Color.WHITE);
			}
			return this;
		}
	}

}
