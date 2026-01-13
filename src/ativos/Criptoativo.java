package ativos;

public class Criptoativo extends AtivosInternacionais{
    private String algoritmo;
    private int qtdMax;

    public Criptoativo(String nome, String ticker, double precoAtual, String algoritmo, int qtdMax){
        super(nome, ticker, precoAtual);
        this.algoritmo = algoritmo;
        this.qtdMax = qtdMax;
    }

}
