package views;

import java.io.FileNotFoundException;
import javafx.scene.layout.BorderPane;

public class MyPane extends BorderPane{
	
	private Header hPane;
	private Body bPane;
	private Bottom btPane;
	
	public MyPane() throws FileNotFoundException {
		this.hPane = new Header();
		this.bPane = new Body();
		this.btPane = new Bottom();
		
		this.setTop(hPane);
		this.setCenter(bPane);
		this.setBottom(btPane);
		
	}

	public Header gethPane() {
		return hPane;
	}

	public Body getbPane() {
		return bPane;
	}

	public Bottom getBtPane() {
		return btPane;
	} 

}
