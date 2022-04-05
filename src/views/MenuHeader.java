package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuHeader extends FlowPane{

	private Label lTitle;
	
	public MenuHeader() {
		this.lTitle = new Label("Hangman");
		this.lTitle.setFont(new Font("Verdana",50));
		this.lTitle.setTextFill(Color.WHITE);
		
		this.getChildren().add(lTitle);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	}

	public Label getlTitle() {
		return lTitle;
	}
	
}
