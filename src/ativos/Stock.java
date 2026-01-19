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

    public void setBolsa(String bolsa){
        this.bolsa = bolsa;
    }

    public String getBolsa(){
        return bolsa;
    }
    
    public void setSetor(String setor){
        this.setor = setor;
    }

    public String getSetor(){
        return setor;
    }

    @Override
    public String toString() {
        return "Nome: " + nome  +
               ", ticker: " + ticker +
               ", preço: " + precoAtual +
               ", bolsa de negociação: " + bolsa +
               ", setor da empresa: " + setor +
               ", qualificado: " + qualificado +
               '.';
    }
}
