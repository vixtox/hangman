package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuBody extends FlowPane{
	
	private FileInputStream inputStream;
	private Image image;
	private ImageView cuadro;
	private Button bPlayAnimals;
	private Button bPlayEquipos;
	private Button bPlayMuebles;
	private Button bPlayElectrodomesticos;
	
	public MenuBody() throws FileNotFoundException {
		this.cuadro = getDesignImg();// conseguir diseño de la imagen
		
		this.bPlayAnimals = new Button("Animales");
		this.bPlayAnimals = getDesignBotton(bPlayAnimals);// conseguir diseño del botón
		
		this.bPlayEquipos = new Button("Equipos");
		this.bPlayEquipos = getDesignBotton(bPlayEquipos);// conseguir diseño del botón
		
		this.bPlayMuebles = new Button("Muebles");
		this.bPlayMuebles = getDesignBotton(bPlayMuebles);// conseguir diseño del botón
		
		this.bPlayElectrodomesticos = new Button("Electrodomesticos");
		this.bPlayElectrodomesticos = getDesignBotton(bPlayElectrodomesticos);// conseguir diseño del botón
		
		VBox vbox = getDesignVbox();// conseguir diseño del vbox
		
		this.getChildren().add(vbox);
		this.setAlignment(Pos.CENTER);
	}
	
	public ImageView getDesignImg() throws FileNotFoundException {
		this.inputStream = new FileInputStream("img/hangman_7.jpg");
		this.image = new Image(inputStream);
		this.cuadro = new ImageView(image);
		this.cuadro.setPreserveRatio(true);//Cambiar tamaño del marco ajustando imagen
		this.cuadro.setFitHeight(500);
		this.cuadro.setFitWidth(500);
		
		return this.cuadro;
	}
	
	public Button getDesignBotton(Button button) {
		
		button.setMinSize(260, 50);
		BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null,new BorderWidths(4));
        Border border = new Border(borderStroke);
        button.setBorder(border);
        button.setFont(new Font("Arial",20));
        button.setTextFill(Color.WHITE);
        button.setBackground(new Background(new BackgroundFill(Color.CORAL, null, null)));
		
		return button;
	}

	
	public VBox getDesignVbox() {
		HBox hbox = new HBox(this.bPlayAnimals,this.bPlayEquipos);
		hbox.setSpacing(30);
		hbox.setAlignment(Pos.CENTER);
		
		HBox hbox2 = new HBox(this.bPlayMuebles,this.bPlayElectrodomesticos);
		hbox2.setSpacing(30);
		hbox2.setAlignment(Pos.CENTER);
		
		VBox vbox = new VBox(this.cuadro,hbox,hbox2);
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20));
		vbox.setBackground(new Background(new BackgroundFill(Color.CYAN,null,null)));
		
		return vbox;
	}
	
	public Button getbPlayAnimals() {
		return bPlayAnimals;
	}
	
	public Button getbPlayEquipos() {
		return bPlayEquipos;
	}

	public Button getbPlayMuebles() {
		return bPlayMuebles;
	}

	public Button getbPlayElectrodomesticos() {
		return bPlayElectrodomesticos;
	}

	public Button [] getBtnArray() {
		Button [] btnArray = {this.bPlayAnimals,this.bPlayEquipos,this.bPlayMuebles,this.bPlayElectrodomesticos};
		
		return btnArray;
	}

}
