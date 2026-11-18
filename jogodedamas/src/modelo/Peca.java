package modelo;

import jogo.Movimento;
import jogo.Tabuleiro;
import java.util.List;

public abstract class Peca {
	
	private final Cor cor;
	private boolean capturada = false;
	
	public Peca(Cor corDaPeca) {
		cor = corDaPeca;
	}
	
	public Cor getCor() {
		return cor;
	}
	
	public boolean podeCapturar(Peca alvo) {
		if (alvo.cor != cor && !alvo.isCapturada()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean isCapturada() {
		return capturada;
	}
	
	public void marcarCapturada() {
		capturada = true;
	}
	
	public void desmarcarCapturada() {
		capturada = false;
	}
	
	// a ser implementado na definição concreta (peça comum)
	public Peca promoverPeca() {
		return this;
	}
	
	// polimorfismo: cada tipo de peça implementa os métodos seguintes da sua própria forma
	public abstract String getSimbolo();
	public abstract List<Movimento> getMovimentosSimples(Tabuleiro tabuleiro, Posicao origem);
	public abstract List<List<Movimento>> getSequenciasCaptura(Tabuleiro tabuleiro, Posicao origem);
}
