
package com.jotta.jogodavelha;

/**
 *
 * @author Jorge Paulo Santos
 */
public class Intermediario{
    //private final Main grafico;
    private final Base base;
    private int contador;
    private boolean fimDoJogo;
    private String vencedor, simbolo;

    
    public Intermediario(){
        this.vencedor = null;
        this.simbolo = null;
        this.fimDoJogo = false;
        this.base = new Base();
        this.contador = 0;
    }
    
    public void principal(int linha, int coluna, String letra){
        if(!fimDoJogo){
            base.setTabela(linha, coluna, letra);
            if(!base.verificaGanhador()){
                System.out.println("Fim do Jogo!");
                System.out.println("Vitória do "+letra+ " !");
                this.fimDoJogo = true;
                setVencedor(letra);
            }else if(contador==8){
                System.out.println("Empate!!!");
                this.fimDoJogo = true;
                setVencedor("e");
            }
            this.contador +=1;
        }
    }
    
    public String trocaSimbolo(){
        if(!fimDoJogo){
            if(this.contador % 2 == 0){
                simbolo = "X";
                return simbolo;
            }else{
                simbolo = "O";
                return simbolo;
            } 
        }
        return "";
    }
    
    public void resetar(){
        base.restauraTabuleiro();
        this.vencedor=null;
        this.contador = 0;
        this.simbolo=null;
        this.fimDoJogo = false;
    }
    
    public String getVencedor(){
        return this.vencedor;
    }
    public void setVencedor(String vencedor){
        this.vencedor = vencedor;
    }
    
    public boolean getFimJogo(){
        return this.fimDoJogo;
    }
    
    public String getSimbolo(){
        return this.simbolo;
    }
}
