package application;

import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.MenuPane;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			MenuPane menu = new MenuPane();
			MenuController mc = new MenuController(menu);
			
			Scene scene = new Scene(menu,650,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hangman game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
