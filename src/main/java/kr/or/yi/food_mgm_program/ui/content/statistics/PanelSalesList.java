package kr.or.yi.food_mgm_program.ui.content.statistics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import kr.or.yi.food_mgm_program.dto.SalesStatus;
import kr.or.yi.food_mgm_program.service.PanelSaleListService2;
import kr.or.yi.food_mgm_program.ui.list.SalesList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class PanelSalesList extends JPanel implements DocumentListener, ActionListener, ItemListener {
	private JPanel panel_1;
	private SalesList panel_2;
	private ChartPanel panel_3;
	private List<SalesStatus> itemList;
	private PanelSaleListService2 service;
	private JDatePickerImpl datePicker;
	private PiePlot plot;
	private DefaultPieDataset pieDataset;
	private JButton btnSelectbyAll;
	private JComboBox<String> cmbYear;
	private JComboBox<String> cmbMonth;
	ArrayList<String> y;
	ArrayList<String> m;
	

	public PanelSalesList() {
		service = PanelSaleListService2.getInstance();
		initComponents();
		setListAll();
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
		
		btnSelectbyAll = new JButton("전체보기");
		btnSelectbyAll.addActionListener(this);
		
		cmbYear = new JComboBox<String>();
		cmbYear.addItemListener(this);
		panel.add(cmbYear);
		
		cmbMonth = new JComboBox<String>();
		cmbMonth.addItemListener(this);
		panel.add(cmbMonth);
		
		setCmbYearMonth();
		panel.add(btnSelectbyAll);

		datePicker.getJFormattedTextField().getDocument().addDocumentListener(this);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));

		panel_2 = new SalesList((String) null);

		panel_1.add(panel_2);

		// jfreeChart
		itemList = service.selectSalesStatusByAll();
		pieDataset = new DefaultPieDataset();
		setDefaultChart(pieDataset);
		
		JFreeChart chart = ChartFactory.createPieChart("음식 판매 통계", pieDataset, true, true, true);
		chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 13));
		chart.getLegend().setItemFont(new Font("맑은 고딕", Font.BOLD, 12));
		plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("맑은 고딕", Font.BOLD, 12));
		plot.setBackgroundPaint(Color.white);
		
		panel_3 = new ChartPanel(chart);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_1.add(panel_3);

	}

	private void setDefaultChart(DefaultPieDataset pieDataset) {
		for (SalesStatus s : itemList) {
			String name = s.getSsName();
			double dShare = Double.parseDouble(s.getSsShare());
			pieDataset.setValue(name+"("+dShare+"%)", dShare);
		}

	}

	public void setListAll() {
		itemList = service.selectSalesStatusByAll();
		setListRank();
		panel_2.setItemList(itemList);
		panel_2.reloadData();
		
		pieDataset = new DefaultPieDataset();
		setDefaultChart(pieDataset);
		plot.setDataset(pieDataset);
	}

	private void setListRank() {
		for (int i = 0; i < itemList.size(); i++) {
			itemList.get(i).setSsNo(i + 1);
		}
	}

	public void setListBydate(String searchDate) {
		itemList = service.selectSalesStatusByDate(searchDate);
		setListRank();
		panel_2.setItemList(itemList);
		panel_2.reloadData();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println(datePicker.getJFormattedTextField().getText());
		String searchDate = datePicker.getJFormattedTextField().getText();
		itemList = service.selectSalesStatusByDate(searchDate);
		setListRank();
		panel_2.setItemList(itemList);
		panel_2.reloadData();
		
		pieDataset = new DefaultPieDataset();
		setDefaultChart(pieDataset);
		plot.setDataset(pieDataset);
		
		setCmbClear();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent e) {

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelectbyAll) {
			actionPerformedBtnSelectbyAll(e);
		}
	}
	protected void actionPerformedBtnSelectbyAll(ActionEvent e) { //전체보기
		setDatePickerText();
		setListAll();
		setCmbClear();
		
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
			pieDataset = new DefaultPieDataset();
			setDefaultChart(pieDataset);
			plot.setDataset(pieDataset); 
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
			pieDataset = new DefaultPieDataset();
			setDefaultChart(pieDataset);
			plot.setDataset(pieDataset);
		}else if(cmbYear.getSelectedIndex()!=0 && cmbMonth.getSelectedIndex()!=0) { //연도 , 월 선택
			String selDate = (String) cmbYear.getSelectedItem();
			String selDate2 = (String) cmbMonth.getSelectedItem();
			String sd =selDate.replace("년", "")+"-"+selDate2.replace("월", "");
			setListBydate(sd);
			pieDataset = new DefaultPieDataset();
			setDefaultChart(pieDataset);
			plot.setDataset(pieDataset);
			setDatePickerText();
		}
	}
	
	public void setCmbClear() {
		cmbYear.setSelectedIndex(0);
		cmbMonth.setSelectedIndex(0);
	}
	
}
