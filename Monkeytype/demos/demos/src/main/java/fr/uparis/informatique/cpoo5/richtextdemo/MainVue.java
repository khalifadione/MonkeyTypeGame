package fr.uparis.informatique.cpoo5.richtextdemo;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainVue extends Application {
	public static void main(String[] args) {
		MainVue.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneController sc = new SceneController();
		sc.start(primaryStage);
	}
}
