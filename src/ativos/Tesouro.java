package ativos;

public class Tesouro extends Ativos{
    private String rendimento;
    private String vencimento;

    public Tesouro(String nome, String ticker, double precoAtual, String rendimento, String vencimento){
        super(nome, ticker, precoAtual);
        this.rendimento = rendimento;
         this.vencimento = vencimento;
    }
}
