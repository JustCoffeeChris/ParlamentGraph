package style;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class Bundestag implements Runnable{

	private ArrayList<Double> content = new ArrayList<Double>();

	public Bundestag(ArrayList<Double> content) {

		for (int i = 0; i < content.size(); i++) {
			this.content.add((content.get(i) / 100) * 50);
		}
	}

	public PieChart getPieChart() {

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("", 50),
				new PieChart.Data("SPD", this.content.get(0)), new PieChart.Data("Union", this.content.get(1)),
				new PieChart.Data("FDP", this.content.get(2)), new PieChart.Data("Grune", this.content.get(3)),
				new PieChart.Data("Linke", this.content.get(4)), new PieChart.Data("AfD", this.content.get(5)));
		
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Bundestag Sitzverteilung");
		pieChartData.get(0).getNode().setStyle("-fx-pie-color: #ffffff;");

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

	@Override
	public void run() {
		showGraph();
	}

}
