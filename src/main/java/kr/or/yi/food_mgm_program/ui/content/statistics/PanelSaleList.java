package kr.or.yi.food_mgm_program.ui.content.statistics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.ui.list.SaleList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class PanelSaleList extends JPanel implements DocumentListener {
	private JPanel panel_1;
	private SaleList panel_2;
	private JPanel panel_3;
	private List<Sale> itemList;
	private SaleDao dao;
	private JDatePickerImpl datePicker;

	public PanelSaleList() {
		dao = new SaleDaoImpl();
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

		datePicker.getJFormattedTextField().getDocument().addDocumentListener(this);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));

		panel_2 = new SaleList((String) null);
		panel_1.add(panel_2);

		panel_3 = new JPanel();
		panel_1.add(panel_3);

		// jfreeChart
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("one", new Integer(10));
		pieDataset.setValue("Two", new Integer(20));
		pieDataset.setValue("Three", new Integer(30));
		pieDataset.setValue("Four", new Integer(10));
		pieDataset.setValue("Five", new Integer(20));
		pieDataset.setValue("Six", new Integer(10));
		JFreeChart chart = ChartFactory.createPieChart("음식 판매 순위", pieDataset, true, true, true);
		chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 13));
		panel_3.setLayout(new BorderLayout(0, 0));
		JPanel chartPanel = new ChartPanel(chart);

		panel_3.add(chartPanel);
		chartPanel.setLayout(new BorderLayout(0, 0));

	}

	public void setListAll() {
		itemList = dao.selectSaleByAll();
		panel_2.setItemList(itemList);
		panel_2.reloadData();
	}

	public void setListBydate(String searchDate) {
		itemList = dao.selectSaleByDate(searchDate);
		panel_2.setItemList(itemList);
		panel_2.reloadData();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println(datePicker.getJFormattedTextField().getText());
		String searchDate = datePicker.getJFormattedTextField().getText();
		itemList = dao.selectSaleByDate(searchDate);
		panel_2.setItemList(itemList);
		panel_2.reloadData();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent e) {

	}
}
