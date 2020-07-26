package myCharts;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class HalfPieChart {

	private PieChart myChart = null;

	private Double sumOfArrayList(ArrayList<Double> values) {
		Double sum = 0.0;
		
		for(int i = 0; i < values.size(); i++) {
			sum += values.get(i);
		}
		
		return sum;
	}
	
	private ArrayList<Double> fillUp(ArrayList<Double> getValues, double sum){
		
		
		for(int i = 0; i < getValues.size(); i++) {
			System.out.println(getValues.get(i)/sum);
			getValues.set(i, ((getValues.get(i)/sum) * 50 ));
		}
		
		return getValues;
		
	}
	public HalfPieChart(ArrayList<Double> values, String[] names, String title) {

		
		double sum = sumOfArrayList(values); 
		if( sum < 50.0) {
			values = fillUp(values, sum);
		}
		

		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

		pieChartData.add(new PieChart.Data("", 50));

		for (int i = 0; i < values.size(); i++) {
			pieChartData.add(new PieChart.Data(names[i], values.get(i)));
		}

		myChart = new PieChart(pieChartData);
		myChart.getData().get(0).getNode().setStyle("-fx-pie-color: transparent;");
		myChart.setTitle(title);
		myChart.setLegendVisible(false);
		
	}

	public void changeColors(String[] colors) {
		for(int i = 1; i < myChart.getData().size(); i++) {
			myChart.getData().get(i).getNode().setStyle("-fx-pie-color:" + colors[i - 1] + ";");
		}
	}
	
	public PieChart toChart() {
		return myChart;
	}
}
