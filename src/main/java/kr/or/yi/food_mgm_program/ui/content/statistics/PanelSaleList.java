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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.service.PanelSaleListService;
import kr.or.yi.food_mgm_program.ui.list.SaleList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class PanelSaleList extends JPanel implements DocumentListener, ActionListener {
	private JPanel panel_1;
	private SaleList panel_2;
	private ChartPanel panel_3;
	private List<Payment> itemList;
	private PanelSaleListService service;
	private JDatePickerImpl datePicker;
	private JButton btnSelectByAll;
	private CategoryPlot plot;
	private DefaultCategoryDataset dataset;

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
		itemList = service.selectPaymentByAll();
		dataset = new DefaultCategoryDataset();
		
		setDefaultChart(dataset);
		
		JFreeChart chart = ChartFactory.createBarChart("결제 통계", "결제수단", "판매액", dataset, PlotOrientation.VERTICAL, true,
				true, false);
		chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 13));
		chart.getLegend().setItemFont((new Font("맑은 고딕", Font.BOLD, 12)));
		
		
		 plot = chart.getCategoryPlot ();
		 chartFontSet(plot);
	        
		panel_3 = new ChartPanel(chart);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_1.add(panel_3);

	}

	private void chartFontSet(CategoryPlot plot) {
		plot.getDomainAxis().setLabelFont((new Font("맑은 고딕", Font.BOLD, 12)));
		 plot.getDomainAxis().setTickLabelFont((new Font("맑은 고딕", Font.BOLD, 12)));
		 plot.getRangeAxis().setLabelFont((new Font("맑은 고딕", Font.BOLD, 12)));
		 
		 NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	     rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	}

	private void setDefaultChart(DefaultCategoryDataset dataset) {
		int cardPrice = 0;
		int cashPrice = 0;
		for (Payment p : itemList) {
			int type = p.getPayType(); // 0 카드 /1현금
			if(type==1) { //현금이면
				cashPrice += p.getPayPrice();
			}else{
				cardPrice += p.getPayPrice();
			}
		}
		
		
		dataset.addValue((double)cardPrice, "카드", "카드");
        dataset.addValue((double)cashPrice, "현금", "현금");
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
		
		dataset = new DefaultCategoryDataset();
		setDefaultChart(dataset);
		plot.setDataset(dataset);
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

	protected void actionPerformedBtnSelectByAll(ActionEvent e) { //전체보기
		datePicker.getJFormattedTextField().setValue(null);
		setListAll();
		dataset = new DefaultCategoryDataset();
		setDefaultChart(dataset);
		plot.setDataset(dataset);
	}
}
