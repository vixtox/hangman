package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuPane extends BorderPane{
	
	private Header hPane;
	private Button bPlay;
	private Label lCopyright;
	private FileInputStream inputStream;
	private Image image;
	private ImageView cuadro;
	
	public MenuPane() throws FileNotFoundException {
		this.hPane = new Header();
		
		//Body
		this.cuadro = getDesignImg();// conseguir dise�o de la imagen
		this.bPlay = getDesignBoton();// conseguir dise�o del bot�n
		VBox vbox = getDesignVbox();// conseguir dise�o del vbox
		
		//Bottom
		this.lCopyright = getDesignLabel();
		
		//Colocar nodos en BorderPane
		this.setTop(hPane);
		this.setCenter(vbox);
		this.setBottom(lCopyright);

		//Dise�o del panel
		this.backgroundProperty().set(new Background(new BackgroundFill(Color.BLACK, null, null)));
		this.setAlignment(lCopyright, Pos.CENTER_RIGHT);
		this.setPadding(new Insets(30));
	}

	public Label getDesignLabel() {
		this.lCopyright = new Label("V�ctor Mart�nez Dom�nguez, 1� DAW");
		this.lCopyright.setFont(new Font("Verdana",14));
		this.lCopyright.setTextFill(Color.WHITE);
		
		return this.lCopyright;
	}

	public VBox getDesignVbox() {
		VBox vbox = new VBox(this.cuadro,this.bPlay);
		vbox.setSpacing(40);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20));
		vbox.setBackground(new Background(new BackgroundFill(Color.CYAN,null,null)));
		return vbox;
	}

	public Button getDesignBoton() {
		this.bPlay = new Button("PLAY");
		this.bPlay.setMinSize(500, 60);
		BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null,new BorderWidths(4));
        Border border = new Border(borderStroke);
		this.bPlay.setBorder(border);
		this.bPlay.setFont(new Font("Arial",20));
		this.bPlay.setTextFill(Color.WHITE);
		this.bPlay.setBackground(new Background(new BackgroundFill(Color.CORAL, null, null)));
		
		return this.bPlay;
	}

	public ImageView getDesignImg() throws FileNotFoundException {
		this.inputStream = new FileInputStream("img/hangman_7.jpg");
		this.image = new Image(inputStream);
		this.cuadro = new ImageView(image);
		this.cuadro.setPreserveRatio(true);//Cambiar tama�o del marco ajustando imagen
		this.cuadro.setFitHeight(500);
		this.cuadro.setFitWidth(500);
		
		return this.cuadro;
	}

	public Header gethPane() {
		return hPane;
	}

	public Button getbPlay() {
		return bPlay;
	}
	
	

}
