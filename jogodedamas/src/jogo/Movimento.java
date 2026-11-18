package jogo;

import java.util.Objects;

import modelo.Posicao;

public class Movimento {
	private final Posicao origem, destino;
	
	public Movimento(Posicao origem, Posicao destino) {
		this.origem = origem;
		this.destino = destino;
	}
	
	public Posicao getOrigem() {
		return origem;
	}
	
	public Posicao getDestino() {
		return destino;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Movimento)) return false;
		Movimento outro = (Movimento) obj;
		return Objects.equals(outro.getOrigem(), origem) && Objects.equals(outro.getDestino(), destino);
	}
	
	@Override
	public String toString() {
		return origem + ">" + destino;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(origem, destino);
	}
}
