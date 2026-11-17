package modelo;

public class PecaComum extends Peca {

	public PecaComum(Cor corDaPeca) {
		super(corDaPeca);
	}

	@Override
	public String getSimbolo() {
		return getCor().getSimbolo();
		
	}
	
}
