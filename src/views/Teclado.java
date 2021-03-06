package views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Teclado extends GridPane {
	
	Button [] bArray;
	
	public Teclado() {
		this.bArray = new Button [27];
		this.bArray = getTecladoQwerty();
		
		for (int i = 0, f = 0, c = 0; i < this.bArray.length; i++) {
			this.add(this.bArray[i], c, f);
			
			c++;
				
			if (i == 9 || i == 19) {
				f++;
				c = 0;
			}
			
		}
		
		this.backgroundProperty().set(new Background(new BackgroundFill(Color.BLACK, null, null)));
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
	}
	
	public String [] distribucionQwerty() {
		String [] qwerty = {"Q","W","E","R","T","Y","U","I","O","P",// Primera fila
			"A","S","D","F","G","H","J","K","L","?",				// Segunda fila
			"Z","X","C","V","B","N","M"};							// Tercera fila
		
		return qwerty;
	}
	
	public Button [] getTecladoQwerty() {
		Button tecla = null;
		for (int i = 0; i < 27; i++) {
			String letra = distribucionQwerty()[i];// Conseguir letra del bot?n 
			
			tecla = new Button(letra);
			tecla = getDesignBotton(tecla);// Conseguir dise?o del bot?n
			this.bArray [i] = tecla;
		}
		
		return this.bArray;
		
	}
	
	public Button getDesignBotton(Button button) {
		button.setMinSize(40, 40);
		BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null,new BorderWidths(2));
        Border border = new Border(borderStroke);
        button.setBorder(border);
        button.setFont(new Font("Arial",16));
        button.setTextFill(Color.WHITE);
        button.setBackground(new Background(new BackgroundFill(Color.CORAL, null, null)));
		
		return button;
	}
	
	public Button [] getTecladoAlfabetico() {
		Button tecla = null;
		for (int i = 0; i < 26; i++) {
			char asci = 97;
			asci = (char)(asci + i);
			String letra = String.valueOf(asci); 
			
			tecla = new Button(letra);
			tecla = getDesignBotton(tecla);
			this.bArray [i] = tecla;
		}
		tecla = new Button("?");
		tecla = getDesignBotton(tecla);
		this.bArray [26] = tecla;
		
		return this.bArray;
		
	}

	public Button[] getbArray() {
		return bArray;
	}
	
}