package style;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import myCharts.HalfPieChart;

public class Bundestag {

	private ArrayList<Double> content = null;
	private Button saveChart = null;
	private HalfPieChart myChart = null;
	private void saveChartEvent() {
		saveChart.setOnAction(e -> {
			
			WritableImage  image = this.myChart.toChart().snapshot(new SnapshotParameters(), null);
			File file = new File("chart.png");
			
			
			try {
				ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public Bundestag(ArrayList<Double> content) {

		this.content = new ArrayList<Double>();
		this.saveChart = new Button("save Chart");
		for (int i = 0; i < content.size(); i++) {
			this.content.add((content.get(i) / 100) * 50);
		}
	}

	public PieChart getPieChart() {

		String[] names = { "Linke", "B90/Gruene", "SPD", "FDP", "Union", "AfD" };
		String[] colors = { "#D00060", "#46962b", "#E3000F", "#ffed00", "#000000", "#009ee0" };

		this.myChart = new HalfPieChart(content, names, "Bundestag");

		myChart.changeColors(colors);
		return myChart.toChart();

	}

	public void showGraph() {
		Stage newStage = new Stage();

		newStage.setTitle("Bundestag");
		Scene bScene = new Scene(new Group());

		((Group) bScene.getRoot()).getChildren().add(getPieChart());
		((Group) bScene.getRoot()).getChildren().add(saveChart);
		
		saveChartEvent();
		newStage.setScene(bScene);
		newStage.show();
	}

}
