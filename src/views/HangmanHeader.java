package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Marcador;

public class HangmanHeader extends FlowPane{

		private Label lMarcador;
		private Label lVictorias;
		private Label lDerrotas;
		private Marcador m;

		public HangmanHeader(Marcador m) {

			this.lMarcador = new Label("MARCADOR");
			this.lMarcador.setFont(new Font("Verdana", 40));
			this.lMarcador.setTextFill(Color.WHITE);
			
			this.m = m;
			int victoria = this.m.getVictoria();
			this.lVictorias = new Label("Victorias: " + victoria);
			this.lVictorias.setFont(new Font("Verdana", 16));
			this.lVictorias.setTextFill(Color.GREEN);

			int derrota = m.getDerrota();
			this.lDerrotas = new Label("Derrotas: " + derrota);
			this.lDerrotas.setFont(new Font("Verdana", 16));
			this.lDerrotas.setTextFill(Color.RED);

			HBox hbox = new HBox(lVictorias, lDerrotas);
			hbox.setSpacing(30);
			
			VBox vbox = new VBox(this.lMarcador,hbox);
			vbox.setSpacing(10);

			this.getChildren().add(vbox);
			this.setAlignment(Pos.CENTER);
			this.setPadding(new Insets(20));

			this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		}

		public Label getlVictorias() {
			return lVictorias;
		}

		public Label getlDerrotas() {
			return lDerrotas;
		}
		
}
