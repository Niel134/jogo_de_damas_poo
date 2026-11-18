package modelo;

import java.util.List;

import jogo.Movimento;
import jogo.Tabuleiro;

public class Dama extends Peca {

	public Dama(Cor corDaPeca) {
		super(corDaPeca);
	}

	@Override
	public String getSimbolo() {
		return getCor().getSimbolo().toUpperCase();
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
