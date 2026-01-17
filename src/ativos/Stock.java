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

    public String getBolsa(){
        return bolsa;
    }

    public void setBolsa(String bolsa){
        this.bolsa = bolsa;
    }

    public String getSetor(){
        return setor;
    }
    
    public void setSetor(String setor){
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Stock | " +
                "Nome: " + nome  +
                ", Ticker: " + ticker +
                ", Preço: " + precoAtual +
                ", Bolsa: " + bolsa +
                ", Setor: " + setor +
                '.';
    }
}
