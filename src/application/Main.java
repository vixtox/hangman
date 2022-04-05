package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import controller.MenuController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import modelo.Marcador;
import views.MenuPane;
import views.IntroPane;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			IntroPane intro = new IntroPane();

			Scene scene = new Scene(intro,1550,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hangman game");
			primaryStage.show();

			delay(15000, () -> {
				try {
					MenuPane menu = new MenuPane();

					Marcador m = new Marcador(0, 0);

					Scene scene2 = new Scene(menu,1550,800);
					primaryStage.setScene(scene2);

					String tema = elegirTema();
					ReproducirSonido(tema);

					MenuController mc = new MenuController(menu, m);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public String elegirTema() {
		String tema;
		int aleatorio = (int) (Math.random() * 2) + 1;
		if (aleatorio == 1)
			tema = "audio/Endgame.wav";
		else
			tema = "audio/SaveMe.wav";
		return tema;
	}

	public void ReproducirSonido(String nombreSonido) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error al reproducir el sonido.");

		}
	}

	public static void delay(long millis, Runnable continuation) {
		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
		sleeper.setOnSucceeded(event -> continuation.run());
		new Thread(sleeper).start();
	}

}
