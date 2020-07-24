package main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import style.Bundestag;

public class Main extends Application implements Runnable {

	private Button createChart = new Button("Chart erstellen");
	private Button checkButton = new Button("Aktualisieren");
	private ArrayList<Double> content = new ArrayList<Double>();
	private ArrayList<TextField> listOfTextFields = new ArrayList<TextField>();
	private Label remainSeats = new Label();
	Double remain;
	
	private void createButtonEvent() {

		createChart.setOnAction(e -> {

			for (int i = 0; i < listOfTextFields.size(); i++) {
				System.out.println(listOfTextFields.get(i).getText());
			}

			for (int i = 0; i < listOfTextFields.size(); i++) {
				content.add(Double.parseDouble(listOfTextFields.get(i).getText()));
				System.err.println(content.get(i));
			}

			Bundestag bundestag = new Bundestag(content);
			bundestag.showGraph();
		});

	}

	private void checkButtonEvent() {

		
		checkButton.setOnAction(e -> {
			remain = 100.0;
			content = new ArrayList<Double>();
			for (int i = 0; i < listOfTextFields.size(); i++) {
				System.out.println(listOfTextFields.get(i).getText());
			}

			for (int i = 0; i < listOfTextFields.size(); i++) {
				content.add( Double.parseDouble(listOfTextFields.get(i).getText()) );
				System.err.println(content.get(i));
				remain = remain - content.get(i);
			}

			remainSeats.setText(remain.toString());
		});

	}

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Parlament Graph");

		VBox root = null;

		listOfTextFields.add(new TextField("SPD"));
		listOfTextFields.add(new TextField("Union"));
		listOfTextFields.add(new TextField("FDP"));
		listOfTextFields.add(new TextField("B90/Gruene"));
		listOfTextFields.add(new TextField("Linke"));
		listOfTextFields.add(new TextField("AfD"));

		root = new VBox(listOfTextFields.size() + 2);

		for (int i = 0; i < listOfTextFields.size(); i++) {
			root.getChildren().add(listOfTextFields.get(i));
		}
		root.getChildren().add(createChart);
		root.getChildren().add(remainSeats);
		root.getChildren().add(checkButton);
		
		Scene scene = new Scene(new Group());
		scene = new Scene(new ScrollPane(root), 250, listOfTextFields.get(0).getHeight() * listOfTextFields.size() - 1);

		createButtonEvent();
		checkButtonEvent();
		
		stage.setScene(scene);
		stage.show();

	}

	@Override
	public void run() {
		createButtonEvent();

	}

}
