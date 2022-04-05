package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HangmanBottom extends FlowPane{
	
	private TextField tLetra;
	private Button bEnviar;
	private Teclado teclado;
	
	public HangmanBottom() {
		this.teclado = new Teclado();
		this.getChildren().add(teclado);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10));
		/*
		this.tLetra = new TextField();
		
		this.bEnviar = new Button("Enviar");
		this.bEnviar.setFont(new Font("Arial",14));
		this.bEnviar.setTextFill(Color.WHITE);
		this.bEnviar.setBackground(new Background(new BackgroundFill(Color.CORAL, null, null)));
		
		
		HBox hbox = new HBox(tLetra,bEnviar);
		hbox.setSpacing(20);
		
		this.getChildren().addAll(hbox);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10));
		
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		*/
	}

	public TextField gettLetra() {
		return this.tLetra;
	}

	public Button getbEnviar() {
		return bEnviar;
	}

	public Teclado getTeclado() {
		return teclado;
	}
	
}
