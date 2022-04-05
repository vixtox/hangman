package controller;

import java.io.FileNotFoundException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Marcador;
import views.HangmanBody;
import views.MenuPane;
import views.HangmanPane;

public class MenuController implements EventHandler<ActionEvent>{

	private MenuPane menu;
	private HangmanPane pane;
	Button [] btnArray;
	Button button;
	Marcador m;
	
	public MenuController(MenuPane menu,Marcador m) {
		this.menu = menu;
		this.m = m;
		
		this.btnArray = this.menu.getbMenu().getBtnArray();// Conseguir btones del menú
		
		for (int i = 0; i < btnArray.length; i++) {
			this.button = this.btnArray [i];
			this.button.setOnAction(this);
			
			hoverMouse(this.button,"RED");// Poner y quitar sombra al pasar el cursor
		}
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < btnArray.length; i++) {
			this.button = this.btnArray [i];
			
			if ((Button)event.getSource() == this.button) {
				this.menu.setArchivo(this.button.getText());// Poner titulo del botón en archivo diccionario
				play();
			}
		}
			
	}

	public void play() {
		try {
			this.pane = new HangmanPane(this.menu,m);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scene scene = new Scene(pane,1550,800);
		Stage primaryStage = (Stage)this.menu.getScene().getWindow();
		primaryStage.setScene(scene);
		
		HangmanController hc = new HangmanController(pane,m);
	}

	public void hoverMouse(Button btn, String color) {
			final DropShadow shadowBotton = new DropShadow();
			shadowBotton.setColor(Color.valueOf(color));
			//Poner sombra cuado pase el cursor
			btn.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> btn.setEffect(shadowBotton));
			//Quitar sombra cuando se quite el cursor
			btn.addEventHandler(MouseEvent.MOUSE_EXITED, e -> btn.setEffect(null));	
	}
	
}
