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

	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(500, 250);
		pieChart.setData(getChartData());
		pieChart.setTitle("매출 순위");
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
		if(pList.size()>=3) {
			for (int i = 0; i < 3; i++) {
				list.add(new PieChart.Data(pList.get(i).getPayMember()+"("+ String.format("%,d원", pList.get(i).getPayPrice())+")" , pList.get(i).getPayPrice()));
			}
		}
		
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
	
	public void updateChartData(String title, int count) {
		ObservableList<Data> list =  pieChart.getData();
		
		for(int i = 0; i<list.size(); i++) {
			Data s = list.get(i);
			String[] strD = s.getName().split(" ");
			if (strD[0].equals(title)) {
				s.setPieValue(count);
				break;
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
