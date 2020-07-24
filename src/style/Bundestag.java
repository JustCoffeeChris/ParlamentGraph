package style;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class Bundestag{

	private ArrayList<Double> content = new ArrayList<Double>();

	public Bundestag(ArrayList<Double> content) {

		for (int i = 0; i < content.size(); i++) {
			this.content.add((content.get(i) / 100) * 50);
		}
	}

	public PieChart getPieChart() {

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("", 50),
				new PieChart.Data("Linke", this.content.get(0)), 
				new PieChart.Data("B90/Gruene", this.content.get(1)),
				new PieChart.Data("SPD", this.content.get(2)), 
				new PieChart.Data("FDP", this.content.get(3)),
				new PieChart.Data("Union", this.content.get(4)), 
				new PieChart.Data("AfD", this.content.get(5)));
		
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Bundestag Sitzverteilung");
		
		pieChartData.get(0).getNode().setStyle("-fx-pie-color: #ffffff;");
		pieChartData.get(1).getNode().setStyle("-fx-pie-color: #cb99c9;");
		pieChartData.get(2).getNode().setStyle("-fx-pie-color: #46962b;");
		pieChartData.get(3).getNode().setStyle("-fx-pie-color: #E3000F;");
		pieChartData.get(4).getNode().setStyle("-fx-pie-color: #ffed00;");
		pieChartData.get(5).getNode().setStyle("-fx-pie-color: #000000;");
		pieChartData.get(6).getNode().setStyle("-fx-pie-color: #009ee0;");
		
		return chart;

	}
	
	public void showGraph() {
		Stage newStage = new Stage();
		newStage.setTitle("Bundestag");
		Scene bScene = new Scene(new Group());
		
		((Group) bScene.getRoot()).getChildren().add(getPieChart());
		newStage.setScene(bScene);
		newStage.show();
	}



}
