package kr.or.yi.food_mgm_program.ui.list;

import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.ui.content.reservation.PanelCurrentReservation.ReturnTableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class memberList extends AbstractList<Member> {
	public memberList(String title) {
		super("회원");
	}

	@Override
	protected void tableAlignmentAndWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 7, 8);
		tableCellAlignment(SwingConstants.RIGHT,6);
		tableCellAlignment(SwingConstants.LEFT,5);
		tableSetWidth(100, 100, 100, 150, 250, 100, 100, 100, 100);
	}

	@Override
	protected Object[] toArray(int idx) {
		Member member = itemList.get(idx);
		return member.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"회원번호","회원명","생일","전화번호","주소","등급","마일리지","회원여부","가입일"};
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
		
		for (int i = 0; i < getColumnNames().length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new ReturnTableCellRenderer());
		}
		
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
		
	}
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (value==null) return this;
			setText(value.toString());
			setOpaque(true);
			
			setHorizontalAlignment(JLabel.CENTER);
			if (table.getValueAt(row, 7).toString().equals("NO")) {
				setForeground(Color.RED);
			}else {
				setForeground(Color.BLACK);
			}
			if (isSelected) {
				setBackground(new Color(57, 105, 138));
			}else {
				setBackground(Color.WHITE);
			}
			return this;
		}
	}	
}
