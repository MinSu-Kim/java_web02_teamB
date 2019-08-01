//package kr.or.yi.food_mgm_program.ui;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//import javax.swing.JFrame;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JPopupMenu;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.SwingConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumnModel;
//
//import kr.or.yi.food_mgm_program.dao.FoodDao;
//import kr.or.yi.food_mgm_program.dto.Food;
//import kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList.PanelMenuList;
//import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;
//
//public class MenuListFrame extends JFrame implements ActionListener {
//
//	private JPanel contentPane;
//	private List<Food> food;
//	private JTable table;
//	private JPopupMenu popupMenu;
//	private JMenuItem mntmPopAdd;
//	private FoodDao dao;
//	private PanelOrderList pOrder;
//
//	public MenuListFrame() {
//
//		initComponents();
//		
//	}
//	private void initComponents() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(300, 300, 300, 400);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
//		
//		JScrollPane scrollPane = new JScrollPane();
//		contentPane.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);	
//		
//		popupMenu = new JPopupMenu();
//
//		mntmPopAdd = new JMenuItem("추가");
//		mntmPopAdd.addActionListener(this);
//		popupMenu.add(mntmPopAdd);
//		table.setComponentPopupMenu(popupMenu);
//		scrollPane.setComponentPopupMenu(popupMenu);
//	}
//	
//	
//	public void setFood(List<Food> food) {
//		this.food = food;
//	}
//	
//	public void reloadData() {
//		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
//
//		tableCellAlignment(SwingConstants.CENTER, 0);
//		tableCellAlignment(SwingConstants.RIGHT, 1);
//		
//		tableSetWidth(100,30);
//	}
//
//	private Object[][] getRows() {
//		Object[][] rows = new Object[food.size()][];
//		for (int i = 0; i < food.size(); i++) {
//			rows[i] = food.get(i).toArray();
//		}
//		return rows;
//	}
//
//	private String[] getColumnNames() {
//		return new String[] { "상품명", "가격"};
//	}
//
//	// 테이블 셀 내용의 정렬
//	protected void tableCellAlignment(int align, int... idx) {
//		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
//		dtcr.setHorizontalAlignment(align);
//
//		TableColumnModel model = table.getColumnModel();
//		for (int i = 0; i < idx.length; i++) {
//			model.getColumn(idx[i]).setCellRenderer(dtcr);
//		}
//	}
//
//	// 테이블 셀의 폭 설정
//	protected void tableSetWidth(int... width) {
//		TableColumnModel cModel = table.getColumnModel();
//
//		for (int i = 0; i < width.length; i++) {
//			cModel.getColumn(i).setPreferredWidth(width[i]);
//		}
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==mntmPopAdd) {
//			int i = table.getSelectedRow();
//			String fName = (String) table.getModel().getValueAt(i, 0);
//			Food food = new Food();
//			food.setFdName(fName);
//			Food food1 = dao.selectByNames(food);
//			pOrder.setList(food1);
//			
//			
//		}
//		
//	}
//	public void setDao(FoodDao fDao) {
//		this.dao = fDao;
//	}
//	public void setPOrder(PanelOrderList orderList) {
//		this.pOrder = orderList;
//	}
//}
package kr.or.yi.food_mgm_program.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dao.FoodDao;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.service.MenuListService;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;

public class MenuListFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel listPane;
	private List<Food> food;
	private FoodDao dao;
	private PanelOrderList pOrder;
	private MenuListService service;
	public MenuListFrame() {
		initComponents();
		
	}
	private void initComponents() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(220, 250, 1500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		listPane = new JPanel();
		listPane.setLayout(new GridLayout(0, 4, 10, 10));
		scrollPane.setViewportView(listPane);	
		
		
	}
	
	
	public void setFood(List<Food> food) {
		this.food = food;
		listPane.removeAll();
		for(Food fd : this.food) {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			JLabel lblName = new JLabel(fd.getFdName()+"("+fd.getFdPrice()+")");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			panel.add(lblName, BorderLayout.NORTH);
			
		
		
			ImageIcon image = new ImageIcon("image/"+fd.getFdName()+".jpg");
			Image image1 = image.getImage();
			Image image3 = null;
			if(fd.getFkNo().getFkNo()==5) {
				image3 = image1.getScaledInstance(360, 450, Image.SCALE_SMOOTH);
			}else {
				image3 = image1.getScaledInstance(360, 200, Image.SCALE_SMOOTH);

			}
			ImageIcon image4 = new ImageIcon(image3);
			JButton btnImg = new JButton(image4);
			btnImg.setName(fd.getFdName());
			btnImg.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(btnImg, BorderLayout.CENTER);
			listPane.add(panel);
			btnImg.addActionListener(this);
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton) e.getSource();
		String fdName = o.getName();
		Food food = new Food();
		food.setFdName(fdName);
		Food food1 = service.selectByName(food);
		pOrder.setList(food1);
	}

	public void setService(MenuListService service) {
		this.service = service;
	}
	public void setPOrder(PanelOrderList orderList) {
		this.pOrder = orderList;
		
	}
	
	
	
}










