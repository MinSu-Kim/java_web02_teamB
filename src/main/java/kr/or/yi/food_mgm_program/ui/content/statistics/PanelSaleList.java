package kr.or.yi.food_mgm_program.ui.content.statistics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import kr.or.yi.food_mgm_program.ui.list.SaleList;

@SuppressWarnings("serial")
public class PanelSaleList extends JPanel {

	public PanelSaleList() {
		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		//jdatepicker 생성
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

		panel.add(datePicker);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));

		SaleList panel_2 = new SaleList((String) null);
		panel_1.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		//jfreeChart
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		  pieDataset.setValue("one", new Integer(10));
		  pieDataset.setValue("Two", new Integer(20));
		  pieDataset.setValue("Three", new Integer(30));
		  pieDataset.setValue("Four", new Integer(10));
		  pieDataset.setValue("Five", new Integer(20));
		  pieDataset.setValue("Six", new Integer(10));
		  JFreeChart chart = ChartFactory.createPieChart
		   ("음식 판매 순위", pieDataset, true,true,true);
		  chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 13));
		  panel_3.setLayout(new BorderLayout(0, 0));
		  ChartPanel chartPanel = new ChartPanel(chart);
		  panel_3.add(chartPanel);
		  chartPanel.setLayout(new BorderLayout(0, 0));
		  
	}

}
