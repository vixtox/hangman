package views;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import modelo.Marcador;

public class HangmanPane extends BorderPane{
	
	//private Header hPane;
	private HangmanBody bPane;
	private HangmanBottom btPane;
	private HangmanHeader hPane;
	
	public HangmanPane(MenuPane menu,Marcador m) throws FileNotFoundException {
		this.hPane = new HangmanHeader(m);
		
		this.bPane = new HangmanBody(menu);
		
		this.btPane = new HangmanBottom();
		
		this.setTop(hPane);
		this.setCenter(bPane);
		this.setBottom(btPane);
		
		this.setPadding(new Insets(20));
		this.backgroundProperty().set(new Background(new BackgroundFill(Color.BLACK, null, null)));
	}

	public HangmanHeader gethPane() {
		return hPane;
	}

	public HangmanBody getbPane() {
		return bPane;
	}

	public HangmanBottom getBtPane() {
		return btPane;
	} 

}
