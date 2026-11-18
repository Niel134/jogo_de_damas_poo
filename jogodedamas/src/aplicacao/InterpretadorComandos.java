package aplicacao;

import java.util.Scanner;

import jogo.JogadaInvalidaException;
import jogo.Movimento;
import jogo.Partida;
import jogo.StatusPartida;
import jogo.Tabuleiro;
import modelo.Peca;
import modelo.Posicao;
import persistencia.PersistenciaArquivo;
import persistencia.PersistenciaException;
import persistencia.PersistenciaPartida;

public class InterpretadorComandos {

    private Partida partida;
    private final PersistenciaPartida persistencia;

    public InterpretadorComandos() {
        this(new PersistenciaArquivo());
    }

    public InterpretadorComandos(PersistenciaPartida persistencia) {
        this.persistencia = persistencia;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        exibirCabecalho();

        boolean executando = true;
        while (executando) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) {
                break;
            }

            String linha = scanner.nextLine().trim();
            if (linha.isEmpty()) {
                continue;
            }

            String[] partes = linha.split("\\s+");
            String comando = partes[0].toUpperCase();

            try {
                switch (comando) {
                    case "NOVO":
                        processarNovo(partes);
                        break;
                    case "MOVER":
                        processarMover(partes);
                        break;
                    case "ESTADO":
                        processarEstado();
                        break;
                    case "SALVAR":
                        processarSalvar(partes);
                        break;
                    case "CARREGAR":
                        processarCarregar(partes);
                        break;
                    case "SAIR":
                        System.out.println("Programa encerrado.");
                        executando = false;
                        break;
                    default:
                        System.out.println("Erro: Comando desconhecido. Use NOVO, MOVER, ESTADO, SALVAR, CARREGAR ou SAIR.");
                        break;
                }
            } catch (JogadaInvalidaException | IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (PersistenciaException e) {
                System.out.println("Erro de arquivo: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private void exibirCabecalho() {
        System.out.println("=================================");
        System.out.println("          JOGO DE DAMAS          ");
        System.out.println("=================================");
        System.out.println("Comandos disponíveis:");
        System.out.println("  NOVO <jogador1> <jogador2>");
        System.out.println("  MOVER <origem> <destino>");
        System.out.println("  ESTADO");
        System.out.println("  SALVAR <arquivo>");
        System.out.println("  CARREGAR <arquivo>");
        System.out.println("  SAIR");
    }

    private void processarNovo(String[] partes) {
        if (partes.length != 3) {
            System.out.println("Erro: Uso correto -> NOVO <jogador1> <jogador2>");
            return;
        }

        this.partida = Partida.iniciarNovaPartida(partes[1], partes[2]);
        System.out.println("Partida iniciada.");
        System.out.println("Jogador atual: " + partida.getJogadorAtual().getNome()
                + " (" + partida.getTurno().getCor() + ")");
    }

    private void processarMover(String[] partes) throws JogadaInvalidaException {
        if (partida == null) {
            System.out.println("Erro: Nenhuma partida em andamento. Inicie com NOVO ou carregue com CARREGAR.");
            return;
        }

        if (partes.length != 3) {
            System.out.println("Erro: Uso correto -> MOVER <origem> <destino>");
            return;
        }
        
        Posicao origem = Posicao.fromNotacao(partes[1]);
        Posicao destino = Posicao.fromNotacao(partes[2]);
        Movimento movimento = new Movimento(origem, destino);

        partida.realizarMovimento(movimento);
        System.out.println("Movimento realizado.");

        if (partida.getStatus() != StatusPartida.EM_ANDAMENTO) {
            System.out.println("Partida encerrada! Resultado: " + partida.getStatus().name());
        } else if (partida.isEmCapturaMultipla()) {
            System.out.println("Captura múltipla em andamento! Continue movendo a peça em "
                    + partida.getPecaEmCapturaMultipla().toNotacao() + ".");
        } else {
            System.out.println("Próximo jogador: " + partida.getJogadorAtual().getNome()
                    + " (" + partida.getTurno().getCor() + ")");
        }
    }

    private void processarEstado() {
        if (partida == null) {
            System.out.println("Erro: Nenhuma partida em andamento.");
            return;
        }

        Tabuleiro tabuleiro = partida.getTabuleiro();
        System.out.println("TABULEIRO_INICIO");

        for (int linha = 7; linha >= 0; linha--) {
            StringBuilder linhaTexto = new StringBuilder();
            for (int coluna = 0; coluna < 8; coluna++) {
                Peca peca = tabuleiro.getPeca(new Posicao(linha, coluna));
                if (peca == null || peca.isCapturada()) {
                    linhaTexto.append('.');
                } else {
                    linhaTexto.append(peca.getSimbolo());
                }
            }
            System.out.println(linhaTexto.toString());
        }

        System.out.println("TABULEIRO_FIM");
        System.out.println("TURNO=" + partida.getTurno().getCor());
        System.out.println("STATUS=" + partida.getStatus().name());
    }

    private void processarSalvar(String[] partes) throws PersistenciaException {
        if (partida == null) {
            System.out.println("Erro: Nenhuma partida em andamento para salvar.");
            return;
        }

        if (partes.length != 2) {
            System.out.println("Erro: Uso correto -> SALVAR <arquivo>");
            return;
        }

        if (partida.isEmCapturaMultipla()) {
            System.out.println("Erro: Não é permitido salvar a partida durante uma captura múltipla.");
            return;
        }

        persistencia.salvar(partida, partes[1]);
        System.out.println("Partida salva com sucesso.");
    }

    private void processarCarregar(String[] partes) throws PersistenciaException {
        if (partes.length != 2) {
            System.out.println("Erro: Uso correto -> CARREGAR <arquivo>");
            return;
        }

        Partida partidaCarregada = persistencia.carregar(partes[1]);
        this.partida = partidaCarregada;

        System.out.println("Partida carregada com sucesso.");
        System.out.println("Jogador atual: " + partida.getJogadorAtual().getNome()
                + " (" + partida.getTurno().getCor() + ")");
    }
}