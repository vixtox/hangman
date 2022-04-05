package controller;

import java.io.FileNotFoundException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import controller.MenuController;
import modelo.Hangman;
import modelo.Marcador;
import views.MenuPane;
import views.HangmanPane;
import views.Teclado;

public class HangmanController implements EventHandler<ActionEvent> {

	private MenuPane menu;
	private HangmanPane pane;
	private String used;
	private Alert alert;
	private char letter;
	private Button bTecla;
	private Hangman h;
	private Button[] teclado;
	private MenuController mc;
	private Marcador m;
	
	public HangmanController(HangmanPane pane, Marcador m) {
		this.pane = pane;
		this.m = m;
		
		try {
			this.menu = new MenuPane();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		this.teclado = this.pane.getBtPane().getTeclado().getbArray();// Conseguir array de botones
		this.h = this.pane.getbPane().getH();

		for (int i = 0; i < teclado.length; i++) {
			this.bTecla = teclado[i];
			this.bTecla.setOnAction(this);
			
			this.mc = new MenuController(menu,m);
			mc.hoverMouse(bTecla,"CYAN");
		}

		this.used = "";
	}

	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub

		for (int i = 0; i < teclado.length; i++) {
			this.bTecla = teclado[i];
			if ((Button) e.getSource() == this.bTecla) {
				this.letter = this.bTecla.getText().toLowerCase().charAt(0); // Conseguir letra
			}
		}

		this.alert = new Alert(Alert.AlertType.INFORMATION);

		if (h.repeatLetters(letter, used)) {// Comprobar letras usadas
			alertLetraRepetida(this.alert);
			actualizarImagen(h, letter);
		} else if (!h.checkLetter(letter))// Bajar vidas y pintar imagen
			actualizarImagen(h, letter);

		actualizarUsedLetters(letter); // Actualizar letras usadas

		if (h.checkLetter(letter)) {// Actualizar mask
			Label mask = this.pane.getbPane().getlMask();
			mask.setText(String.valueOf(h.getMask()));
		}
	
		
		if (h.youWin()) { // Victoria
			int countVictoria = m.getVictoria();
			countVictoria++;
			this.pane.gethPane().getlVictorias().setText("Victorias: " + countVictoria);
			m.setVictoria(countVictoria);
			alertVictoria(alert);
		}
		else if (h.getLives() == 0) { // Derrota
			int countDerrota = m.getDerrota();
			countDerrota++;
			this.pane.gethPane().getlDerrotas().setText("Derrotas: " + countDerrota);
			m.setDerrota(countDerrota);
			alertDerrota(alert);
		}
		
	}

	public void actualizarUsedLetters(char letter) {
		used += letter + "-";
		Label lUsed = this.pane.getbPane().getlUsed();
		lUsed.setText("Letras usadas: " + used);// Actualizar letras usadas
	}

	public void actualizarImagen(Hangman h, char letter) {
		h.downLives(letter);
		try {
			ImageView cuadro = this.pane.getbPane().getImgHangman();// Actualizar imagen
			this.pane.getbPane().add(cuadro, 0, 0);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void alertVictoria(Alert alert) {
		alert.setHeaderText(null);
		alert.setTitle("Felicidades");
		alert.setContentText("Has ganado!!!");
		alert.showAndWait();
		ponerMenuPane();
	}

	public void alertDerrota(Alert alert) {
		alert.setHeaderText(null);
		alert.setTitle("Intentalo de nuevo");
		alert.setContentText("Has perdido!!!");
		alert.showAndWait();
		ponerMenuPane();
	}

	public void alertLetraRepetida(Alert alert) {
		alert.setHeaderText(null);
		alert.setTitle("Letra Repetida");
		alert.setContentText("Letra Repetida, pierdes una vida");
		alert.showAndWait();
	}

	public void ponerMenuPane() {// Cambiar vista a Menu
		Scene scene = new Scene(menu,1550,800);
		Stage primaryStage = (Stage) this.pane.getScene().getWindow();
		primaryStage.setScene(scene);
	
		MenuController mc = new MenuController(menu,m);
	}

}
