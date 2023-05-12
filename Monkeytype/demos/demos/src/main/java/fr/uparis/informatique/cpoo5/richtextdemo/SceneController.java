package fr.uparis.informatique.cpoo5.richtextdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneController extends Application {
	private Stage stage;
	private Scene scene;
	private Parent root;


	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox root = new VBox();
		root.setStyle("-fx-background-color: #323437;");

		Text texte = new Text("Bienvenu Sur Monkeytype");
		texte.setStyle("-fx-font: 35 arial;");
		texte.setFill(Color.WHITE);

		Button niveau1 = new Button("niveau1");
		Button niveau2 = new Button("niveau2");
		HBox hbox = new HBox();
		hbox.getChildren().addAll(niveau1,niveau2);
		hbox.setPadding(new Insets(20, 10, 20, 370));
		hbox.setSpacing(15);

		HBox hboxtexte = new HBox();
		hboxtexte.getChildren().add(texte);
		hboxtexte.setPadding(new Insets(20, 10, 20, 270));

		root.getChildren().addAll(hboxtexte,hbox);


		niveau1.setStyle("-fx-background-color: #0000FF; -fx-font-size: 15pt; -fx-text-fill: white; ");
		niveau2.setStyle("-fx-background-color: #0000FF; -fx-font-size: 15pt; -fx-text-fill: white; ");



		Scene scene = new Scene( root,1000, 500);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		scene.setFill(Color.web("#81c483"));
		primaryStage.setTitle("Rich Text Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		niveau1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				VueModelController r = new VueModelController();

				try {
					r.niveau1(primaryStage);
					r.declancheTimer(r.textArea);

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});



		niveau2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				VueModelController r = new VueModelController();
				System.out.println("salu");
				try {
					r.declancheTimer(r.textArea);

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}



}
