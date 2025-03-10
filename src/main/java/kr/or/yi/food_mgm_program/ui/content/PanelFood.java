package kr.or.yi.food_mgm_program.ui.content;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.service.MenuListService;
import kr.or.yi.food_mgm_program.ui.insert.PanelFoodInfo;
import kr.or.yi.food_mgm_program.ui.list.FoodList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class PanelFood extends JPanel implements ActionListener, MouseListener {
	private JTextField tfSearch;
	
	private MenuListService service;
	private List<Food> fList;
	private List<Food> fListAll;
	private List<FoodKind> fkList;

	private FoodList pFoodList;
	private JButton btnAdd;
	private JButton btnCancel;

	private PanelFoodInfo pFood;
	private JButton btnSearch;
	private JButton btnList;

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	private JPanel pImg;
	private JLabel lblImg;
	private JPanel panel;
	private JPanel panel_1;
	
	public PanelFood() {
		service = MenuListService.getInstance();
		
		fList = service.selectFoodByAll();
		fkList = service.selectFoodKindByAll();
		fListAll = service.selectFoodByAllF();
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pInsert = new JPanel();
		add(pInsert);
		pInsert.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel = new JPanel();
		pInsert.add(panel);
		
		panel_1 = new JPanel();
		pInsert.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		pFood = new PanelFoodInfo();
		panel_1.add(pFood);
//		pFood.setList(fkList);
		pFood.setFoodKindCmbModel(fkList);
		
		JPanel pBtn = new JPanel();
		panel_1.add(pBtn);
		pBtn.setBorder(new EmptyBorder(0, 0, 0, 30));
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.Y_AXIS));
		
		btnAdd = new JButton("추가");
		btnAdd.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		JPanel pList = new JPanel();
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		pList.add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		tfSearch = new JTextField();
		tfSearch.setBorder(new EmptyBorder(10, 10, 10, 10));
		tfSearch.registerKeyboardAction(this, "search", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		pSearch.add(tfSearch);
		tfSearch.setColumns(30);
		
		btnSearch = new JButton("검색");
		btnSearch.setActionCommand("search"); //해당 버튼에 부여할 액션명령에 대한 명칭을 부여한다.
		btnSearch.addActionListener(this);
		btnSearch.setBorder(new EmptyBorder(10, 20, 10, 20));
		pSearch.add(btnSearch);
		
		btnList = new JButton("메뉴보기");
		btnList.addActionListener(this);
		btnList.setBorder(new EmptyBorder(10, 20, 10, 20));
		pSearch.add(btnList);
		
		pFoodList = new FoodList((String) null);
		pFoodList.getTable().addMouseListener(this);
		pList.add(pFoodList, BorderLayout.CENTER);
		reloadList();
		
		popupMenu = new JPopupMenu();
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);

		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);

		pFoodList.setPopupMenu(popupMenu);
		
		pImg = new JPanel();
		pImg.setBorder(new TitledBorder(null, "\uC74C\uC2DD \uC0AC\uC9C4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pList.add(pImg, BorderLayout.EAST);
		pImg.setPreferredSize(new Dimension(500, 100));
		pImg.setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel("");
		pImg.add(lblImg);
		
		
		
	}
	
	
	public void setLableImg() {
		String Img = pFoodList.ImgName();
		if(Img==null) {
			return;
		}
		ImageIcon image = new ImageIcon("image/"+Img+".jpg");
		Image image1 = image.getImage();
		Image image3 = image1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon image4 = new ImageIcon(image3);
		lblImg.setIcon(image4);
		
		
	}

	public void reloadList() {
		fList = service.selectFoodByAll();
		pFoodList.setItemList(fList);
		pFoodList.reloadData();
		pFood.clearFoodInfo();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnList) {
			actionPerformedBtnList(e);
		}
		if (e.getActionCommand() == "search") {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			try {
				if(e.getActionCommand().equals("추가")) {
					actionPerformedBtnAdd(e);
				}else if(e.getActionCommand().equals("수정")) {
					actionPerformedBtnUpdate(e);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		if (e.getSource() == mntmDelete) {
			actionPerformedMntmDelete(e);
		}
		if (e.getSource() == mntmUpdate) {
			actionPerformedMntmUpdate(e);
		}
	}
	
	private void actionPerformedBtnUpdate(ActionEvent e) throws Exception {
		Food food = pFood.getFoodUP();
		service.updateFood(food);
		reloadList();
	}

	private void actionPerformedMntmUpdate(ActionEvent e) {
		Food food = pFoodList.getSelectedItem();
		pFood.setFood(food);
		btnAdd.setText("수정");
	}

	private void actionPerformedMntmDelete(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제확인", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			Food food = pFoodList.getSelectedItem();
			food.setFdWithdrawal(true);
			service.deleteFood(food);
			reloadList();
		}
	}

	protected void actionPerformedBtnAdd(ActionEvent e) throws Exception {
		Food food = pFood.getFood();
//		int lastNo = 0;
//		if(!fList.isEmpty()) {
//			Food last = fList.get(fList.size()-1);
//			lastNo = last.getFdNo()+1;
//		}
//		food.setFdNo(lastNo);
		service.insertFood(food);
		reloadList();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pFood.clearFoodInfo();
	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		if(tfSearch.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "검색어를 입력하세요.");
		}else {
			Food food = new Food();
			food.setFdName(tfSearch.getText());
			
			fList = service.selectByName1(food);
			if(fList.size() == 0) {
				JOptionPane.showMessageDialog(null, "검색한 음식이 없습니다.");
				actionPerformedBtnList(e);
			}else {
				pFoodList.setItemList(fList);
				pFoodList.reloadData();
			}
		}
	}
	
	protected void actionPerformedBtnList(ActionEvent e) {
		reloadList();
		tfSearch.setText("");
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == pFoodList.getTable()) {
			mouseClickedPFoodListTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedPFoodListTable(MouseEvent e) {
		setLableImg();
	}
}
