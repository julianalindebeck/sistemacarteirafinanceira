package ativos;

import java.math.BigInteger;

public class Criptoativo extends AtivosInternacionais {
    private String algoritmo;
    private BigInteger qtdMax;

    public Criptoativo(String nome, String ticker, double precoAtual, String algoritmo, BigInteger qtdMax){
        super(nome, ticker, precoAtual);
        this.algoritmo = algoritmo;
        this.qtdMax = qtdMax;
        rendaVariavel = true;
    }

    public void setAlgoritmo(String algoritmo){
        this.algoritmo = algoritmo;
    }

    public String getAlgoritmo(){
        return algoritmo;
    }

    public void setQtdMax(BigInteger qtdMax){
        this.qtdMax = qtdMax;
    }

    public BigInteger getQtdMax(){
        return qtdMax;
    }

    @Override
    public String toString() {
        return "Criptoativo | " +
                "Nome: " + nome  +
                ", Ticker: " + ticker +
                ", Preço: " + precoAtual +
                ", Algoritmo: " + algoritmo +
                ", Quantidade Máxima: " + qtdMax +
                '.';
    }
    
}
