package kr.or.yi.food_mgm_program.ui.content.statistics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.service.PanelSaleListService;
import kr.or.yi.food_mgm_program.ui.MainFrame;
import kr.or.yi.food_mgm_program.ui.list.SaleList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class PanelSaleList extends JPanel implements DocumentListener, ActionListener {
	private JPanel panel_1;
	private SaleList pList;
	private ChartPanel panel_3;
	private List<Payment> itemList;
	private PanelSaleListService service;
	private JDatePickerImpl datePicker;
	private JButton btnSelectByAll;
	private CategoryPlot plot;
	private DefaultCategoryDataset dataset;
	
	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private MainFrame frame;
	

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
		panel.add(btnSelectByAll);

		datePicker.getJFormattedTextField().getDocument().addDocumentListener(this);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));

		pList = new SaleList((String) null);

		panel_1.add(pList);

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
		
		popupMenu = new JPopupMenu();
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);

		pList.setPopupMenu(popupMenu);

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
			if(p.getPayCancel()==0) {
				int type = p.getPayType(); // 0 카드 /1현금
				if(type==1) { //현금이면
					cashPrice += p.getPayPrice();
				}else{
					cardPrice += p.getPayPrice();
				}
			}
			
		}
		
		
		dataset.addValue((double)cardPrice, "카드", "카드");
        dataset.addValue((double)cashPrice, "현금", "현금");
	}

	public void setListAll() {
		itemList = service.selectPaymentByAll();
		pList.setItemList(itemList);
		pList.reloadData();
		
		dataset = new DefaultCategoryDataset();
		setDefaultChart(dataset);
		plot.setDataset(dataset);
	}

	public void setListBydate(String searchDate) {
		itemList = service.selectPaymentByDate(searchDate);
		pList.setItemList(itemList);
		pList.reloadData();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println(datePicker.getJFormattedTextField().getText());
		String searchDate = datePicker.getJFormattedTextField().getText();
		itemList = service.selectPaymentByDate(searchDate);
		pList.setItemList(itemList);
		pList.reloadData();
		
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

	public void actionPerformed(ActionEvent e) { //결제취소
		if (e.getSource() == btnSelectByAll) {
			actionPerformedBtnSelectByAll(e);
		}
		if(e.getSource() == mntmUpdate) {
			
			Payment pay = pList.getSelectedItem();
			JOptionPane.showMessageDialog(null, pay);
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("cancel", 1);
			map.put("no", pay.getPayNo());
			service.updateSaleByCancel(map); //sale테이블의 sale_cancel를 1(true)로 바꿈
			
			
			setDatePickerText();
			setListAll(); //테이블 다시쓰기
			
			//차트 다시쓰기
			dataset = new DefaultCategoryDataset();
			setDefaultChart(dataset);
			plot.setDataset(dataset);
			
			//PanelSalesList(판매 패널)다시쓰기
			PanelSalesList f =  (PanelSalesList) frame.getpSales();
			f.setDatePickerText();
			f.setListAll();
			
			
			
			
			
		}
	}


	protected void actionPerformedBtnSelectByAll(ActionEvent e) { //전체보기
		setDatePickerText();
		setListAll();
		
	}
	
	public void setDatePickerText() {
		datePicker.getJFormattedTextField().setValue(null);
	}
}
