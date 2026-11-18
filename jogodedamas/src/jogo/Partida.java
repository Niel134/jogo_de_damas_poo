package jogo;

import modelo.Cor;
import modelo.Jogador;
import modelo.Posicao;
import java.util.List;

public class Partida {
	private final Jogador jogadorBrancas, jogadorPretas;
	private final Tabuleiro tabuleiroDaPartida;
	private StatusPartida status;
	private Cor turno;
	private Posicao pecaEmCapturaMultipla;
	private List<List<Movimento>> sequenciasEmAndamento;
	
	public Partida(Jogador jogadorBrancas, Jogador jogadorPretas, StatusPartida status, Cor turno, Tabuleiro tabuleiroDaPartida) {
		this.jogadorBrancas = jogadorBrancas;
		this.jogadorPretas = jogadorPretas;
		this.status = status;
		this.turno = turno;
		this.tabuleiroDaPartida = tabuleiroDaPartida;
		this.pecaEmCapturaMultipla = null;
		this.sequenciasEmAndamento = null;
	}
	
	
	// metodo para facilitar a criação de uma nova partida. Recebe o nome dos jogadores e isntancia os dois, assim como instancia o tabuleiro e retorna um novo objeto de partida
	public static Partida iniciarNovaPartida(String nomeBrancas, String nomePretas) {
        Jogador branca = new Jogador(nomeBrancas, Cor.BRANCA);
        Jogador preta = new Jogador(nomePretas, Cor.PRETA);

        Tabuleiro novoTabuleiro = new Tabuleiro();
        novoTabuleiro.inicializarTabuleiro();

        return new Partida(branca, preta, StatusPartida.EM_ANDAMENTO, Cor.BRANCA, novoTabuleiro);
    }
	
	public void realizarMovimento(Movimento movimento) throws JogadaInvalidaException {
		// TODO (Integrante 3): Implementar validação, captura múltipla, promoção e vitória.
		throw new JogadaInvalidaException("Movimentação ainda não implementada.");
	}
	
	public Jogador getJogadorBrancas() {
		return jogadorBrancas;
	}
	
	public Jogador getJogadorPretas() {
		return jogadorPretas;
	}
	
	public Jogador getJogadorAtual() {
		if (turno == Cor.BRANCA) {
			return jogadorBrancas;
		} else {
			return jogadorPretas;
		}
			
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiroDaPartida;
	}
	
	public StatusPartida getStatus() {
		return status;
	}
	
	public Cor getTurno() {
		return turno;
	}
	
	public boolean isEmCapturaMultipla() {
		return pecaEmCapturaMultipla != null;
	}
	
	public Posicao getPecaEmCapturaMultipla() {
		return pecaEmCapturaMultipla;
	}
	

}
