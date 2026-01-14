package ativos;

public class Stock extends AtivosInternacionais {
    private String bolsa;
    private String setor;

    public Stock(String nome, String ticker, double precoAtual, String bolsa, String setor){
        super(nome, ticker, precoAtual);
        this.bolsa = bolsa;
        this.setor = setor;
        rendaVariavel = true;
    }
}
