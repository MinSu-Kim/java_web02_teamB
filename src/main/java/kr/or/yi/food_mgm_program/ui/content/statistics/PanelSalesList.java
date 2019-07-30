package kr.or.yi.food_mgm_program.ui.content.statistics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import kr.or.yi.food_mgm_program.dao.SalesStatusDao;
import kr.or.yi.food_mgm_program.daoImpl.SalesStatusDaoImpl;
import kr.or.yi.food_mgm_program.dto.SalesStatus;
import kr.or.yi.food_mgm_program.service.PanelSaleListService2;
import kr.or.yi.food_mgm_program.ui.list.SalesList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class PanelSalesList extends JPanel implements DocumentListener, ActionListener {
	private JPanel panel_1;
	private SalesList panel_2;
	private ChartPanel panel_3;
	private List<SalesStatus> itemList;
	private PanelSaleListService2 service;
	private JDatePickerImpl datePicker;
	private PiePlot plot;
	private DefaultPieDataset pieDataset;
	private JButton btnSelectbyAll;

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
	protected void actionPerformedBtnSelectbyAll(ActionEvent e) {
		datePicker.getJFormattedTextField().setValue(null);
		setListAll();
		pieDataset = new DefaultPieDataset();
		setDefaultChart(pieDataset);
		plot.setDataset(pieDataset);
	}
}
