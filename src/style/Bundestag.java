package style;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import myCharts.HalfPieChart;

public class Bundestag{

	private ArrayList<Double> content = new ArrayList<Double>();

	public Bundestag(ArrayList<Double> content) {

		for (int i = 0; i < content.size(); i++) {
			this.content.add((content.get(i) / 100) * 50);
		}
	}

	public PieChart getPieChart() {

		
		String[] names = {
				"Linke", "B90/Gruene", "SPD", 
				"FDP", "Union", "AfD"
		};
		String[] colors = {
				"#D00060", "#46962b", "#E3000F",
				"#ffed00", "#000000", "#009ee0"
		};
	
		
		HalfPieChart myChart = new HalfPieChart( content, names, "Bundestag");
		
		myChart.changeColors(colors);
		return myChart.toChart();

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
