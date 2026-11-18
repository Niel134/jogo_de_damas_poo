package persistencia;

import jogo.Partida;

public interface PersistenciaPartida {
	public void salvar(Partida partida, String caminhoArquivo) throws PersistenciaException;
	public Partida carregar(String caminhoArquivo) throws PersistenciaException;
}