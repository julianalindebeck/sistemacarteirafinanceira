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

}
