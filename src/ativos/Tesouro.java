package ativos;

public class Tesouro extends AtivosNacionais {
    private String rendimento;
    private String vencimento;

    public Tesouro(String nome, String ticker, double precoAtual, String rendimento, String vencimento){
        super(nome, ticker, precoAtual);
        this.rendimento = rendimento;
        this.vencimento = vencimento;
        rendaVariavel = false;
    }

    public void setRendimento(String rendimento){
        this.rendimento = rendimento;
    }

    public String getRendimento(){
        return rendimento;
    }

    public void setVencimento(String vencimento){
        this.vencimento = vencimento;
    }

    public String getInvestimento(){
        return vencimento;
    }

    @Override
    public String toString() {
        return "Tesouro | " +
                "Nome: " + nome  +
                ", Ticker: " + ticker +
                ", Preço: " + precoAtual +
                ", Rendimento: " + rendimento +
                ", Vencimento: " + vencimento +
                '.';
    }
}
