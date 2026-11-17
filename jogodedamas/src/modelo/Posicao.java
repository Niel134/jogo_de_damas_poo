package modelo;

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

}
