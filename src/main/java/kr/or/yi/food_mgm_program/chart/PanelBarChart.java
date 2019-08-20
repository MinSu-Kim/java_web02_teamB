package kr.or.yi.food_mgm_program.chart;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;
import kr.or.yi.food_mgm_program.dto.Payment;




@SuppressWarnings("serial")
public class PanelBarChart extends JFXPanel implements InitScene{
	private List<Payment> pList;
	
	
	
	public PanelBarChart() {
	}
	
	

	public PanelBarChart(List<Payment> pList) {
		super();
		this.pList = pList;
	}


	public void setpList(List<Payment> pList) {
		this.pList = pList;
	}



	private BarChart<String, Number> barChart;
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		root.setAutoSizeChildren(true);
		
		//막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("결제수단");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("판매액");

		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("결제 수단별 결제금액");
		
		barChart.setPrefSize(800, 250);
		barChart.setData(getChartData());
		
		root.getChildren().add(barChart);

		return scene;
	}
	
	/**
	 * 전체 데이터 삭제
	 */
	public void deleteAllData() {
		barChart.getData().clear();
	}
	
	/** 해당 학생의 삭제
	 * @param std
	 */
	/*
	 * public void delChartData(Payment pay) { ObservableList<Series<String,
	 * Number>> list = barChart.getData(); Iterator<Series<String, Number>> it =
	 * list.iterator(); while(it.hasNext()) { Series<String, Number> s = it.next();
	 * if (s.getName().equals(std.getStdName())) { barChart.getData().remove(s);
	 * break; } } }
	 */
	

	/**
	 * 해당 학생 정보 갱신
	 * @param std
	 */
	
	public void updateChartData() {
		ObservableList<Series<String, Number>> list = barChart.getData();
		int sum = 0; 
		int sum2 = 0; 
		for(Payment p : pList) {
			if(p.getPayType()==1 && p.getPayCancel()==0) {
				sum += p.getPayPrice();
			}else if(p.getPayType()==0 && p.getPayCancel()==0) {
				sum2 += p.getPayPrice();
			}
		}
		
		Payment p1 = new Payment();
		p1.setPayType(1);
		p1.setPayPrice(sum);
		Payment p2 = new Payment();
		p2.setPayType(0);
		p2.setPayPrice(sum2);
		
		for (int i = 0; i < list.size(); i++) {
			Series<String, Number> s = list.get(i);
			if (s.getName().equals("현금")) {
				s.getData().set(0, new XYChart.Data<>("현금", p1.getPayPrice()));
			}else if(s.getName().equals("카드")) {
				s.getData().set(0, new XYChart.Data<>("카드", p2.getPayPrice()));
			}
		}
	}
	
	/** getChartData() 를 이용하여 학생정보추가
	 * @param std
	 */
	public void addChartData(Payment pay) {
		barChart.getData().add(getChartData(pay));
	}
	
	/**
	 * getChartData()에 의해 모든 데이터 추가
	 */
	public void addAllChartData() {
		barChart.setData(getChartData());
	}
	
	/**
	 * @param std
	 * @return
	 */
	public XYChart.Series<String, Number> getChartData(Payment pay) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		if(pay.getPayType()==1) {
			dataSeries.setName("현금");
			dataSeries.getData().add(new XYChart.Data<>("현금", pay.getPayPrice()));
		}else {
			dataSeries.setName("카드");
			dataSeries.getData().add(new XYChart.Data<>("카드", pay.getPayPrice()));
		}
		
		return dataSeries;
	}
	
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		int sum = 0; 
		int sum2 = 0; 
		for(Payment p : pList) {
			if(p.getPayType()==1 && p.getPayCancel()==0) {
				sum += p.getPayPrice();
			}else if(p.getPayType()==0 && p.getPayCancel()==0) {
				sum2 += p.getPayPrice();
			}
		}
		
		Payment p1 = new Payment();
		p1.setPayType(1);
		p1.setPayPrice(sum);
		Payment p2 = new Payment();
		p2.setPayType(0);
		p2.setPayPrice(sum2);
		
		list.add(getChartData(p1));
		list.add(getChartData(p2));
		
		return list;
	}

}
