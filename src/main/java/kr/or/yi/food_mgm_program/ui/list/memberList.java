package kr.or.yi.food_mgm_program.ui.list;

import kr.or.yi.food_mgm_program.dto.Member;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;

public class memberList extends AbstractList<Member> {
	private JTable table;

	public memberList(String title) {
		super("회원");
		initComponents();
	}
	private void initComponents() {
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	@Override
	protected void tableAlignmentAndWidth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object[] toArray(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}


}
