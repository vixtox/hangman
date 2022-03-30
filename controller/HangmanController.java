package controller;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Hangman;
import views.MenuPane;
import views.MyPane;

public class HangmanController implements EventHandler<ActionEvent> {

	private MenuPane menu;
	private MyPane pane;
	private Button bEnviar;
	private String used;
	private Alert alert;

	public HangmanController(MyPane pane) {
		this.pane = pane;

		this.bEnviar = this.pane.getBtPane().getbEnviar();
		this.bEnviar.setOnAction(this);// Acción de botón

		this.used = "";
	}

	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub

		if ((Button) e.getSource() == this.bEnviar) {
			Hangman h = this.pane.getbPane().getH();

			TextField tLetra = this.pane.getBtPane().gettLetra();

			try {

				char letter = tLetra.getText().toLowerCase().charAt(0);// Conseguir letra
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

				this.menu = new MenuPane();

				if (h.youWin()) // Victoria
					alertVictoria(alert);
				else if (h.getLives() == 0) // Derrota
					alertDerrota(alert);

			} catch (Exception e1) {
				Alert alertError = new Alert(Alert.AlertType.ERROR);
				alertEnterLetter(alertError);
			}

		} // Fin Button controller

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

	public void ponerMenuPane() {// Cambiar vista a Menu
		Scene scene = new Scene(menu, 650, 650);
		Stage primaryStage = (Stage) this.pane.getScene().getWindow();
		primaryStage.setScene(scene);
		MenuController mc = new MenuController(menu);
	}

	public void alertEnterLetter(Alert alert) {
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText("Introduce una letra");
		alert.showAndWait();
	}

	public void alertLetraRepetida(Alert alert) {
		alert.setHeaderText(null);
		alert.setTitle("Letra Repetida");
		alert.setContentText("Letra Repetida, pierdes una vida");
		alert.showAndWait();
	}
}
