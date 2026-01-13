package ativos;

import java.util.Optional;

public class Acao extends Ativos{
    private String tipo;
    private int qualificado;

    public Acao(String nome, String ticker, double precoAtual, int qualificado){
        super(nome, ticker, precoAtual);
        this.qualificado = qualificado;
    }

    public void confereTipo(){
        int pos = ticker.length()-1;
        if(ticker.charAt(pos) == '3'){
            this.tipo = "Ordinária";
        }
        else if(ticker.charAt(pos) == '1'){
            this.tipo = "Unit";
        }
        else {
            this.tipo = "Preferencial";
        }
    }
}
