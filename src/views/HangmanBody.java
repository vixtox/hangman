package views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Dictionary;
import modelo.Hangman;

public class HangmanBody extends GridPane{
	
	private FileInputStream inputStream;
	private Image image;
	private ImageView cuadro;
	private String [] lista;
	private Label lMask;
	private Label lUsed;
	private Hangman h;
	
	public HangmanBody(MenuPane menu) throws FileNotFoundException {
		
		String archivo = menu.getArchivo();
		
		this.h = getWordFromFile(archivo);
		
		this.lMask = new Label(String.valueOf(h.getMask()));//Conseguir mask
		this.lMask.setFont(new Font("Verdana",30));
		
		this.lUsed = new Label("Letras usadas: ");//Conseguir letras usadas
		this.lUsed.setFont(new Font("Verdana",30));
		
		this.cuadro = getImgHangman();// Conseguir imagen del ahorcado
		
		this.add(cuadro, 0, 0);
		this.add(lMask, 0, 1);
		this.add(lUsed, 0, 2);
		
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);

		this.setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
		
	}

	public ImageView getImgHangman() throws FileNotFoundException {
		File folder = new File("img");
		if (folder.isDirectory()) 
			this.lista = folder.list();
		
		this.inputStream = new FileInputStream("img/" + this.lista[h.getLives()]);
		this.image = new Image(inputStream);
		this.cuadro = new ImageView(this.image);
		
		this.cuadro.setPreserveRatio(true);//Cambiar tamaño del marco ajustando imagen
		this.cuadro.setFitHeight(350);
		this.cuadro.setFitWidth(350);
		
		return this.cuadro;
	}

	public Hangman getWordFromFile(String archivo) {
		Scanner input = new Scanner (System.in);
		Dictionary d = null;
		try {
		d = new Dictionary(archivo + ".txt");
		}
		catch (Exception e) {
			System.out.println("Problemas con el fichero");
			System.exit(0);
		}
		
		Hangman h = new Hangman(d.getRandomWord());
		return h;
	}

	public FileInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(FileInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ImageView getCuadro() {
		return cuadro;
	}

	public void setCuadro(ImageView cuadro) {
		this.cuadro = cuadro;
	}
	
	public String[] getLista() {
		return lista;
	}

	public Hangman getH() {
		return h;
	}

	public Label getlMask() {
		return lMask;
	}

	public void setlMask(Label lMask) {
		this.lMask = lMask;
	}

	public Label getlUsed() {
		return lUsed;
	}

}
