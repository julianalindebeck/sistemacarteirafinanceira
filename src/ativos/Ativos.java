package ativos;

public abstract class Ativos {
    protected String nome;
    protected String ticker;
    protected double precoAtual;

    public Ativos(String nome, String ticker, double precoAtual){
        this.nome = nome;
        this.ticker = ticker;
        this.precoAtual = precoAtual;
    }

    public String getNome(){
        return nome;
    }
    public String getTicker(){
        return ticker;
    }
    public double getPrecoAtual(){
        return precoAtual;
    }
}
