package views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Header extends FlowPane{

	private Label title;
	
	public Header() {
		this.title = new Label("Hangman");
		this.title.setFont(new Font("Verdana",50));
		this.title.setTextFill(Color.WHITE);
		
		this.getChildren().add(title);
		this.setAlignment(Pos.CENTER);
		
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	}

	public Label getTitle() {
		return title;
	}
	
}
