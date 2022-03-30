package controller;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.MenuPane;
import views.MyPane;

public class MenuController implements EventHandler<ActionEvent>{

	private MenuPane menu;
	private MyPane pane;
	private Button bPlay;
	
	public MenuController(MenuPane menu) {
		this.menu = menu;
		
		this.bPlay = this.menu.getbPlay();
		this.bPlay.setOnAction(this);
	}
	
	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if ((Button)e.getSource() == this.bPlay) {
			try {
				this.pane = new MyPane();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Scene scene = new Scene(pane,650,650);
			Stage primaryStage = (Stage)this.menu.getScene().getWindow();
			primaryStage.setScene(scene);
			
			HangmanController hc = new HangmanController(pane);
		}
			
	}

}
