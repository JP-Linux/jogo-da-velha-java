
package com.jotta.jogodavelha;

/**
 *
 * @author Jorge Paulo Santos
 */
public final class Base {
    private final int[][] tabuleiro;
    private int contador, coluna, num;
    
    public Base() {
        this.tabuleiro = new int[3][3];
        restauraTabuleiro();
        this.num=0;
    }
    
    public boolean verificaGanhador(){
        contador=0;
        for(int x=0; x<3; x++){
            for(int i=0; i<3; i++){
                contador=0;
                for(int j=0; j <3; j++){
                    switch (x) {
                        case 0 -> {
                            // Verifica no horizontal
                            if(tabuleiro[i][j] == this.num){
                                contador += 1;
                                if(contador==3){
                                    return false;
                                }
                            }
                        }
                            case 1 -> {
                                // Verifica no vertical
                                if(tabuleiro[j][i] == this.num){
                                    contador += 1;
                                    if(contador==3){
                                        return false;
                                }
                            }
                        }
                            default -> {
                                if(tabuleiro[j][j] == this.num){
                                    contador += 1;
                                    if(contador==3){
                                        return false;
                                }
                            }
                        }
                    }
                }
                contador = 0;
            }
        }
        coluna=0;
        for(int linha=2; linha>=0; linha--){
            if(tabuleiro[linha][coluna] == this.num){
                contador+=1;
                coluna+=1;
                if(contador==3){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void setTabela(int linha, int coluna, String letra){
        if("X".equals(letra)){
            this.num = 1;
        }else{
            this.num = 0;
        }
        
        if(tabuleiro[linha][coluna] == -1){
            this.tabuleiro[linha][coluna] = this.num;
        } 
    }
    
    public void restauraTabuleiro(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.tabuleiro[i][j]=-1;
            }
        }
    }
    
    public int[][] getTabela(){
        return tabuleiro;
    }  
}
