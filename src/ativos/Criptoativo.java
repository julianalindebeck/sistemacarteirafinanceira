package ativos;

public class Criptoativo extends AtivosInternacionais {
    private String algoritmo;
    private String qtdMax;

    public Criptoativo(String nome, String ticker, double precoAtual, String algoritmo, String qtdMax){
        super(nome, ticker, precoAtual);
        this.algoritmo = algoritmo;
        this.qtdMax = qtdMax;
        rendaVariavel = true;
    }

}
