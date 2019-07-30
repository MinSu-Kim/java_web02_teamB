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

import kr.or.yi.food_mgm_program.dao.PaymentDao;
import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.PaymentDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.service.PanelSaleListService;
import kr.or.yi.food_mgm_program.ui.list.SaleList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelSaleList extends JPanel implements DocumentListener, ActionListener {
	private JPanel panel_1;
	private SaleList panel_2;
	private ChartPanel panel_3;
	private List<Payment> itemList;
	private PanelSaleListService service;
	private JDatePickerImpl datePicker;
	private JButton btnSelectByAll;

	public PanelSaleList() {
		service = PanelSaleListService.getInstance();
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
		
		btnSelectByAll = new JButton("전체보기");
		btnSelectByAll.addActionListener(this);
		panel.add(btnSelectByAll);

		datePicker.getJFormattedTextField().getDocument().addDocumentListener(this);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));

		panel_2 = new SaleList((String) null);
		
		panel_1.add(panel_2);
		

		// jfreeChart
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		setDefaultChart(pieDataset);
		JFreeChart chart = ChartFactory.createPieChart("월별 판매 순위", pieDataset, true, true, true);
		chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		panel_3 = new ChartPanel(chart);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_1.add(panel_3);

	}

	private void setDefaultChart(DefaultPieDataset pieDataset) {
		pieDataset.setValue("one", new Integer(10));
		pieDataset.setValue("Two", new Integer(20));
		pieDataset.setValue("Three", new Integer(30));
		pieDataset.setValue("Four", new Integer(10));
		pieDataset.setValue("Five", new Integer(20));
		pieDataset.setValue("Six", new Integer(10));
	}

	public void setListAll() {
		itemList = service.selectPaymentByAll();
		panel_2.setItemList(itemList);
		panel_2.reloadData();
	}

	public void setListBydate(String searchDate) {
		itemList = service.selectPaymentByDate(searchDate);
		panel_2.setItemList(itemList);
		panel_2.reloadData();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println(datePicker.getJFormattedTextField().getText());
		String searchDate = datePicker.getJFormattedTextField().getText();
		itemList = service.selectPaymentByDate(searchDate);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelectByAll) {
			actionPerformedBtnSelectByAll(e);
		}
	}
	protected void actionPerformedBtnSelectByAll(ActionEvent e) {
		datePicker.getJFormattedTextField().setValue(null);
		setListAll();
		
	}
}
