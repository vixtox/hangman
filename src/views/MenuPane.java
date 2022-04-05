package views;

import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuPane extends BorderPane{
	
	private MenuHeader hPane;
	private MenuBody bMenu;
	private Label lCopyright;
	private String archivo;
	
	public MenuPane() throws FileNotFoundException {
		this.hPane = new MenuHeader();
		this.bMenu = new MenuBody();
		
		//Bottom
		this.lCopyright = getDesignLabel();
		
		//Colocar nodos en BorderPane
		this.setTop(hPane);
		this.setCenter(bMenu);
		this.setBottom(lCopyright);

		//Diseño del panel
		this.backgroundProperty().set(new Background(new BackgroundFill(Color.BLACK, null, null)));
		this.setAlignment(lCopyright, Pos.CENTER);
		this.setPadding(new Insets(30));
	}

	public Label getDesignLabel() {
		this.lCopyright = new Label("Víctor Martínez Domínguez, 1º DAW");
		this.lCopyright.setFont(new Font("Verdana",14));
		this.lCopyright.setTextFill(Color.WHITE);
		
		return this.lCopyright;
	}

	public String getArchivo() {
		return this.archivo;
	}
	
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	public MenuHeader gethPane() {
		return hPane;
	}

	public MenuBody getbMenu() {
		return bMenu;
	}
	
}
