package com.jotta.jogodavelha;

public class Intermediario {
    private final Base base;
    private boolean fimDoJogo;
    private String vencedor;
    private String simboloAtual;
    private int jogadas;

    public Intermediario() {
        this.base = new Base();
        resetar();
    }
    
    public void registrarJogada(int linha, int coluna, String simbolo) {
        if (fimDoJogo) return;
        
        // Converte símbolo para representação numérica
        int jogador = "X".equals(simbolo) ? Base.JOGADOR_X : Base.JOGADOR_O;
        
        // Registra jogada na base
        base.setJogada(linha, coluna, jogador);
        
        // Verifica vitória
        if (base.verificaGanhador(jogador)) {
            finalizarJogo(simbolo);
            return;
        }
        
        // Verifica empate
        if (base.verificaEmpate()) {
            finalizarJogo("e");
            return;
        }
        
        // Incrementa contador de jogadas
        jogadas++;
    }
    
    public String obterProximoSímbolo() {
        if (fimDoJogo) return "";
        
        if (jogadas == 0) {
            simboloAtual = "X";
        } else {
            simboloAtual = ("X".equals(simboloAtual)) ? "O" : "X";
        }
        
        return simboloAtual;
    }
    
    public final void resetar() {
        base.restauraTabuleiro();
        vencedor = null;
        simboloAtual = null;
        fimDoJogo = false;
        jogadas = 0;
    }
    
    public String getVencedor() {
        return vencedor;
    }
    
    public boolean getFimJogo() {
        return fimDoJogo;
    }
    
    public String getSimboloAtual() {
        return simboloAtual;
    }
    
    private void finalizarJogo(String resultado) {
        fimDoJogo = true;
        vencedor = resultado;
        System.out.println(resultado.equals("e") 
            ? "Empate!!!" 
            : "Vitória do " + resultado + " !");
    }
}