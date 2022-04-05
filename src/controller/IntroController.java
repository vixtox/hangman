package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Marcador;
import views.MenuPane;
import views.IntroPane;

public class IntroController {
	
	IntroPane intro;
	
	public IntroController(IntroPane intro) throws FileNotFoundException, InterruptedException{
		this.intro = intro;
			
		MenuPane menu = new MenuPane();
		Marcador m = new Marcador(0,0);
		
		Scene scene = new Scene(menu,750,750);
		Stage s = (Stage)this.intro.getScene().getWindow();
		s.setScene(scene);
		
		String tema = elegirTema();
		ReproducirSonido(tema);
		
		MenuController mc = new MenuController(menu,m);
		
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

}
