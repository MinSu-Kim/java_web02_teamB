package kr.or.yi.food_mgm_program.chart;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import kr.or.yi.food_mgm_program.dto.Payment;

@SuppressWarnings("serial")
public class PanelPieChart extends JFXPanel implements InitScene{
	private List<Payment> pList;
	private PieChart pieChart;
	
	
	
	public PanelPieChart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PanelPieChart(List<Payment> pList) {
		super();
		this.pList = pList;
	}
	
	

	public void setpList(List<Payment> pList) {
		this.pList = pList;
	}

	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(800, 250);
		pieChart.setData(getChartData());
		pieChart.setTitle("결제 수단별 결제 현황");
		pieChart.setLegendVisible(true);	// 범례 표시 유무
		pieChart.setLegendSide(Side.BOTTOM);// 범례 위치
		pieChart.setLabelLineLength(30);	// 원의 둘레 가장자리와 라벨간의 거리 지정
		pieChart.setClockwise(true); 		// 시계방향 배치여부
		pieChart.setLabelsVisible(true);	// 레이블 표시여부
		
				
//		pieChart.getData().forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), " %")));
		for(Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName()));
		}
		
		root.getChildren().add(pieChart);

		return scene;
	}
	
	private ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		
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
		
		list.add(new PieChart.Data("현금", p1.getPayPrice()));
		list.add(new PieChart.Data("카드", p2.getPayPrice()));
	
		
		return list;
	}

	public void addChartData(String title, int count) {
		Data d = new PieChart.Data(title, count);
		pieChart.getData().add(d);
		d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
	}
	
	public void delChartData(String title) {
		ObservableList<Data> list =  pieChart.getData();
		for(int i=0; i<list.size(); i++) {
			Data d = list.get(i);
			String[] strD = d.getName().split(" ");
			if (strD[0].equals(title)) {
				pieChart.getData().remove(i);
				break;
			}
		}
	}
	
	public void updateChartData() {
		ObservableList<Data> list =  pieChart.getData();
		
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
		
		for(int i = 0; i<list.size(); i++) {
			Data s = list.get(i);
			if (s.getName().equals("현금")) {
				s.setPieValue(p1.getPayPrice());
			}else {
				s.setPieValue(p2.getPayPrice());
			}
		}
	}
	
	public void addAllChartData() {
		pieChart.setData(getChartData());
	}
	
	public void deleteAllData() {
		pieChart.getData().clear();
	}
}
