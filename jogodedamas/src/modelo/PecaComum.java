package modelo;

import java.util.List;

import jogo.Movimento;
import jogo.Tabuleiro;

public class PecaComum extends Peca {

	public PecaComum(Cor corDaPeca) {
		super(corDaPeca);
	}
	
	@Override
	public Peca promoverPeca() {
		return new Dama(getCor());
	}

	@Override
	public String getSimbolo() {
		return getCor().getSimbolo();
		
	}

	@Override
	public List<Movimento> getMovimentosSimples(Tabuleiro tabuleiro, Posicao origem) {
		// TODO : alguem do grupo precisa implementar
		return null;
	}

	@Override
	public List<List<Movimento>> getSequenciasCaptura(Tabuleiro tabuleiro, Posicao origem) {
		// TODO : alguem do grupo precisa implementar
		return null;
	}
	
}
