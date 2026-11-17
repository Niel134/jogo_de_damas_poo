package modelo;

public enum Cor {
	BRANCA("BRANCAS", "b", 7, 1),
	PRETA("PRETAS", "p", 0, -1);
	
	private final String nomeDaCor;
	private final String simboloDaCor;
	private final int linhaDePromocao;
	private final int direcaoDaCor;
	
	Cor(String cor, String simbolo, int linha, int direcao) {
		nomeDaCor = cor;
		simboloDaCor = simbolo;
		linhaDePromocao = linha;
		direcaoDaCor = direcao;
	}
	
	public String getCor() {
		return nomeDaCor;
	}
	
	public String getSimbolo() {
		return simboloDaCor;
	}
	
	public int getLinhaPromocao() {
		return linhaDePromocao;
	}
	
	public int getDirecao() {
		return direcaoDaCor;
	}
	
	public Cor oposta() {
		if (this == BRANCA) {
			return PRETA;
		} else {
			return BRANCA;
		}
	}

}
