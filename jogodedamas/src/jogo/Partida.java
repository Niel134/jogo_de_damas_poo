package jogo;

import modelo.Cor;
import modelo.Jogador;

public class Partida {
	private final Jogador jogadorBrancas, jogadorPretas;
	private final Tabuleiro tabuleiroDaPartida;
	private StatusPartida status;
	private Cor turno;
	
	public Partida(Jogador jogadorBrancas, Jogador jogadorPretas, StatusPartida status, Cor turno, Tabuleiro tabuleiroDaPartida) {
		this.jogadorBrancas = jogadorBrancas;
		this.jogadorPretas = jogadorPretas;
		this.status = status;
		this.turno = turno;
		this.tabuleiroDaPartida = tabuleiroDaPartida;
		
	}
	
	

}
