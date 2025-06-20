package com.jotta.jogodavelha;

public final class Base {
    private final int[][] tabuleiro;
    private static final int VAZIO = -1;
    static final int JOGADOR_X = 1;
    static final int JOGADOR_O = 0;
    
    public Base() {
        this.tabuleiro = new int[3][3];
        restauraTabuleiro();
    }
    
    public boolean verificaGanhador(int jogador) {
        // Verifica linhas e colunas
        for(int i = 0; i < 3; i++) {
            // Verifica linha
            if(tabuleiro[i][0] == jogador && 
               tabuleiro[i][1] == jogador && 
               tabuleiro[i][2] == jogador) {
                return true;
            }
            
            // Verifica coluna
            if(tabuleiro[0][i] == jogador && 
               tabuleiro[1][i] == jogador && 
               tabuleiro[2][i] == jogador) {
                return true;
            }
        }
        
        // Verifica diagonais
        if(tabuleiro[0][0] == jogador && 
           tabuleiro[1][1] == jogador && 
           tabuleiro[2][2] == jogador) {
            return true;
        }
        
        if(tabuleiro[0][2] == jogador && 
           tabuleiro[1][1] == jogador && 
           tabuleiro[2][0] == jogador) {
            return true;
        }
        
        return false;
    }
    
    public boolean verificaEmpate() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(tabuleiro[i][j] == VAZIO) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean setJogada(int linha, int coluna, int jogador) {
        if(tabuleiro[linha][coluna] == VAZIO) {
            tabuleiro[linha][coluna] = jogador;
            return true;
        }
        return false;
    }
    
    public void restauraTabuleiro() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.tabuleiro[i][j] = VAZIO;
            }
        }
    }
    
    public int[][] getTabuleiro() {
        return tabuleiro;
    }
}