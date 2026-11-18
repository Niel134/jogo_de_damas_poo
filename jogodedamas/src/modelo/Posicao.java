package modelo;

import java.util.Objects;

import jogo.JogadaInvalidaException;

public class Posicao {
	private final int linha;
	private final int coluna;
	
	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public boolean isEscura() {
		return (linha + coluna) %2 == 0; 
	}
	
	public boolean isClara() {
		return (linha + coluna) %2 == 1;
	}
	
	public boolean isDentroDoTabuleiro() {
		return (linha >= 0 && linha <=7) && (coluna >=0 && coluna <=7);
	}
	
	public String toNotacao() {
		char colChar = (char) ('A' + coluna);
		char linChar = (char) ('1' + linha);
		return "" + colChar + linChar;
	}
	
	public static Posicao fromNotacao(String notacao)  throws JogadaInvalidaException {
		if (notacao == null || notacao.length() != 2) {
			throw new JogadaInvalidaException("Coordenada inválida: " + notacao);
		}
		String limpa = notacao.toUpperCase();
		int col = limpa.charAt(0) - 'A';
		int lin = limpa.charAt(1) - '1';
		Posicao pos = new Posicao(lin, col);
		if (!pos.isDentroDoTabuleiro()) {
			throw new JogadaInvalidaException("Coordenada fora do tabuleiro: " + notacao);
		}
		return pos;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Posicao)) return false;
		Posicao outra = (Posicao) obj;
		return outra.getLinha() == linha && outra.getColuna() == coluna;
	}
	
	@Override
	public String toString() {
		return toNotacao();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(linha, coluna);
	}

}
