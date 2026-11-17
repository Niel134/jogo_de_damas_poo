package modelo;

public class Jogador {
	private final String nome;
	private final Cor cor;
	
	public Jogador(String nomeJogador, Cor corJogador) {
		nome = nomeJogador;
		cor = corJogador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cor getCor() {
		return cor;
	}
}
