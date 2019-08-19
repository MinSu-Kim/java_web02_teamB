package kr.or.yi.food_mgm_program.ui.content.statistics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.food_mgm_program.chart.InitScene;
import kr.or.yi.food_mgm_program.chart.PanelBarChart;
import kr.or.yi.food_mgm_program.chart.PanelPieChart;
import kr.or.yi.food_mgm_program.dto.Grade;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.service.PanelSaleListService;
import kr.or.yi.food_mgm_program.ui.MainFrame;
import kr.or.yi.food_mgm_program.ui.content.PanelMember;
import kr.or.yi.food_mgm_program.ui.list.SaleList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class PanelSaleList extends JPanel implements DocumentListener, ActionListener, ItemListener {
	private JPanel panel_1;
	private SaleList pList;
	private PanelBarChart panel_3;
	private PanelPieChart panel_4;
	private List<Payment> itemList;
	private List<Payment> itemList2;
	private PanelSaleListService service;
	private JDatePickerImpl datePicker;
	private JButton btnSelectByAll;
	/*
	 * private CategoryPlot plot; private DefaultCategoryDataset dataset;
	 */

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private MainFrame frame;
	private JComboBox<String> cmbYear;
	private JComboBox<String> cmbMonth;
	ArrayList<String> y;
	ArrayList<String> m;

	public PanelSaleList() {
		super();
	}

	public PanelSaleList(MainFrame frame) {
		service = PanelSaleListService.getInstance();
		initComponents();
		setListAll();
		this.frame = frame;
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		// jdatepicker 생성
		UtilDateModel model = new UtilDateModel();

		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panel.add(datePicker);

		btnSelectByAll = new JButton("전체보기");
		btnSelectByAll.addActionListener(this);
		
		cmbYear = new JComboBox<String>();
		cmbYear.addItemListener(this);
		panel.add(cmbYear);
		
		cmbMonth = new JComboBox<String>();
		cmbMonth.addItemListener(this);
		panel.add(cmbMonth);
		
		setCmbYearMonth();
		
		panel.add(btnSelectByAll);

		datePicker.getJFormattedTextField().getDocument().addDocumentListener(this);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 10, 0));

		pList = new SaleList((String) null);

		panel_1.add(pList);
		JPanel panel2 = new JPanel();
		panel_1.add(panel2);
		panel2.setLayout(new GridLayout(0, 2, 0, 0));
		// jfreeChart
		itemList = service.selectPaymentByAll();
		 panel_3 = new PanelBarChart(itemList);
		 panel2.add(panel_3);
		 Platform.runLater(() -> initFX(panel_3));
		 itemList2 = service.selectPaymentByNo();
		 panel_4 = new PanelPieChart(itemList2);
		 panel2.add(panel_4);
		 Platform.runLater(() -> initFX(panel_4));
		 
		 popupMenu = new JPopupMenu(); 
		 mntmUpdate = new JMenuItem("결제 취소");
		  mntmUpdate.addActionListener(this); popupMenu.add(mntmUpdate);
		  
		  pList.setPopupMenu(popupMenu);
		 

	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

	

	public void setListAll() {
		itemList = service.selectPaymentByAll();
		itemList2 =service.selectPaymentByNo();
		pList.setItemList(itemList);
		pList.reloadData();

		/*
		 * dataset = new DefaultCategoryDataset(); setDefaultChart(dataset);
		 * plot.setDataset(dataset);
		 */
	}

	public void setListBydate(String searchDate) {
		itemList = service.selectPaymentByDate(searchDate);
		itemList2 = service.selectPaymentByNoDate(searchDate);
		pList.setItemList(itemList);
		pList.reloadData();
		panel_4.setpList(itemList2);
		 panel_3.setpList(itemList);
		 Platform.runLater(() -> {
			 panel_3.updateChartData();
			 if(itemList2.size()>0) {
					panel_4.updateChartData();
				 }
			}); 
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println(datePicker.getJFormattedTextField().getText());
		String searchDate = datePicker.getJFormattedTextField().getText();
		itemList = service.selectPaymentByDate(searchDate);
		itemList2 = service.selectPaymentByNoDate(searchDate);
		pList.setItemList(itemList);
		pList.reloadData();

		panel_4.setpList(itemList2);
		 panel_3.setpList(itemList);
		 Platform.runLater(() -> {
			 panel_3.updateChartData();
			 if(itemList2.size()>0) {
				panel_4.updateChartData();
			 }
			
			}); 
		
		/*
		 * dataset = new DefaultCategoryDataset(); setDefaultChart(dataset);
		 * plot.setDataset(dataset);
		 */
		
		
		setCmbClear();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent e) {

	}

	public void actionPerformed(ActionEvent e) { // 결제취소
		if (e.getSource() == btnSelectByAll) {
			actionPerformedBtnSelectByAll(e);
		}
		if (e.getSource() == mntmUpdate) {
			Member member = null;
			Payment pay = pList.getSelectedItem();
			int res = JOptionPane.showConfirmDialog(null, "정말 결제취소  하시겠습니까?", "결제취소 확인", JOptionPane.YES_OPTION);

			if (res == 0 && pay.getPayCancel() == 0) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("cancel", 1);
				map.put("no", pay.getPayNo());
				if (pay.getPayMember().equals("비회원")) { // 비회원일 경우
					service.updateSaleByCancel(map);// sale테이블의 sale_cancel를 1(true)로 바꿈
				} else { // 회원일 경우(마일리지)
					member = new Member();
					member.setMbNo(pay.getPayMemberNo());
					member.setMbMileage(pay.getPayDiscountPrice());
					String cou = "";
					String info = pay.getPayDiscountInfo();
					int a = info.indexOf(":");
					int b = info.indexOf("(");
					try { // 쿠폰 or 마일리지 사용일경우
						cou = info.substring(a + 1, b);
						Map<String, Object> map2 = new HashMap<String, Object>();
						map2.put("whether", 0);
						map2.put("no", pay.getPayMemberNo());
						map2.put("cpname", cou);
						service.updateCancelUpdateMileageCoupon(map, member, map2); // sale테이블의 sale_cancel를 1(true)로
																					// 바꿈/마일리지 원상복귀/count -1/쿠폰 복귀
					} catch (StringIndexOutOfBoundsException e2) { // 쿠폰사용 x or 마일리지x 경우
						cou = "";
						service.updateCancelUpdateMileage(map, member); // sale테이블의 sale_cancel를 1(true)로 바꿈/마일리지
																		// 원상복귀/count -1/쿠폰 복귀
					}

					// 등급 변경
					int total = service.totalPrice(pay.getPayMemberNo());
					Member mem2 = new Member(pay.getPayMemberNo());

					if (total > 0 && total <= 299999) { // 등급 변경
						mem2.setMbGrade(new Grade("bronze"));
						service.updateGrade(mem2);
					} else if (total > 300000 && total <= 499999) {
						mem2.setMbGrade(new Grade("silver"));
						service.updateGrade(mem2);
					} else if (total > 500000 && total <= 999999) {
						mem2.setMbGrade(new Grade("gold"));
					} else if (total > 1000000) {
						mem2.setMbGrade(new Grade("vip"));
					}
					service.updateGrade(mem2);
				}

				setDatePickerText(); // 달력 텍스트 초기화
				setListAll(); // 테이블 다시쓰기
				
				// 차트 다시쓰기
				panel_4.setpList(itemList);
				 panel_3.setpList(itemList2);
				 Platform.runLater(() -> {
					 panel_3.updateChartData();
					 if(itemList2.size()>0) {
							panel_4.updateChartData();
						 }
					});  
				

				// PanelSalesList(판매 패널)다시쓰기
				PanelSalesList f = (PanelSalesList) frame.getpSales();
				f.setDatePickerText();
				f.setListAll();

				// 회원패널 다시쓰기
				PanelMember m = (PanelMember) frame.getpMember();
				m.reloadList();
				JOptionPane.showMessageDialog(null, "결제 취소가 완료 되었습니다.");
				
			}else {
				JOptionPane.showMessageDialog(null, "취소된 결제 정보입니다.");
			}

		}
		
	}

	protected void actionPerformedBtnSelectByAll(ActionEvent e) { // 전체보기
		setDatePickerText();
		setListAll();
		setCmbClear();
		panel_4.setpList(itemList2);
		 panel_3.setpList(itemList);
		 Platform.runLater(() -> {
			 panel_3.updateChartData();
			 if(itemList2.size()>0) {
					panel_4.updateChartData();
				 }
			}); 
		
	}

	public void setDatePickerText() {
		datePicker.getJFormattedTextField().setValue(null);
	}
	
	public void setCmbYearMonth() {
		 //년도,월별
		Calendar cal= Calendar.getInstance();
		 int nyear = cal.get(Calendar.YEAR)+1 ;
		 y = new ArrayList<String>();
		 y.add("연도를 선택해주세요");
		 for (int i = 2002; i < nyear; i++) {
			y.add(String.valueOf(i)+"년");
			
		}
		 
		 m = new ArrayList<String>();
		m.add("월을 선택해주세요");
		for(int i=1; i<13; i++) {
			if(i<10) {
				m.add("0"+i+"월");
			}else {
				m.add(i+"월");
			}
		}
		
		DefaultComboBoxModel<String> deptModels = new DefaultComboBoxModel<String>(new Vector<String>(y));
		cmbYear.setModel(deptModels);
		cmbYear.setSelectedIndex(0);
		
		DefaultComboBoxModel<String> deptModels2 = new DefaultComboBoxModel<String>(new Vector<String>(m));
		cmbMonth.setModel(deptModels2);
		cmbMonth.setSelectedIndex(0);
		 
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbMonth) {
			itemStateChangedCmbMonth(e);
		}
		if (e.getSource() == cmbYear) {
			itemStateChangedCmbYear(e);
		}
	}
	protected void itemStateChangedCmbYear(ItemEvent e) {
		cmbMonth.setSelectedIndex(0);
		if(cmbYear.getSelectedIndex()!=0) {
			String selDate = (String) cmbYear.getSelectedItem();
			setListBydate(selDate.replace("년", ""));
			/*
			 * dataset = new DefaultCategoryDataset(); setDefaultChart(dataset);
			 * plot.setDataset(dataset);
			 */
			setDatePickerText();
			
		}else if(cmbYear.getSelectedIndex()==0) {
			cmbMonth.setSelectedIndex(0);
		}
		
	}
	protected void itemStateChangedCmbMonth(ItemEvent e) {
		if(cmbMonth.getSelectedIndex()!=0 && cmbYear.getSelectedIndex()==0) { //연도 선택x, 월만 선택
			Calendar cal= Calendar.getInstance();
			 int nyear = cal.get(Calendar.YEAR)+1 ;
			 String selDate2 = (String) cmbMonth.getSelectedItem();
			String sd =nyear+"-"+selDate2.replace("월", "");
			setListBydate(sd);
			setDatePickerText();
			
			cmbYear.setSelectedIndex(y.size()-1);
			/*
			 * dataset = new DefaultCategoryDataset(); setDefaultChart(dataset);
			 * plot.setDataset(dataset);
			 */
		}else if(cmbYear.getSelectedIndex()!=0 && cmbMonth.getSelectedIndex()!=0) { //연도 , 월 선택
			String selDate = (String) cmbYear.getSelectedItem();
			String selDate2 = (String) cmbMonth.getSelectedItem();
			String sd =selDate.replace("년", "")+"-"+selDate2.replace("월", "");
			setListBydate(sd);
			/*
			 * dataset = new DefaultCategoryDataset(); setDefaultChart(dataset);
			 * plot.setDataset(dataset);
			 */
			setDatePickerText();
		}
	}
	
	public void setCmbClear() {
		cmbYear.setSelectedIndex(0);
		cmbMonth.setSelectedIndex(0);
	}
}
