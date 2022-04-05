package modelo;

public class Marcador {

	private int victoria;
	private int derrota;
	
	public Marcador(int victoria, int derrota) {
		this.victoria = victoria;
		this.derrota = derrota;
	}

	public int getVictoria() {
		return victoria;
	}

	public void setVictoria(int victoria) {
		this.victoria = victoria;
	}

	public int getDerrota() {
		return derrota;
	}

	public void setDerrota(int derrota) {
		this.derrota = derrota;
	}
	
}
