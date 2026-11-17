package modelo;

public class Dama extends Peca {

	public Dama(Cor corDaPeca) {
		super(corDaPeca);
	}

	@Override
	public String getSimbolo() {
		return getCor().getSimbolo().toUpperCase();
	}

}
