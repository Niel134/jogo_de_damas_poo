package modelo;

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
		if (alvo.cor != cor) {
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
	// a ser implementado na definição concreta (peça comum)
	public Peca promoverPeca() {
		return this;
	}
	
	// polimorfismo: cada tipo de peça implementa os métodos seguintes da sua própria forma
	public abstract String getSimbolo();
	
}
