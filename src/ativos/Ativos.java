package ativos;

public abstract class Ativos {
    protected String nome;
    protected String ticker;
    protected double precoAtual;
    protected boolean qualificado;

    public Ativos(String nome, String ticker, double precoAtual, boolean qualificado){
        this.nome = nome;
        this.ticker = ticker;
        this.precoAtual = precoAtual;
        this.qualificado = qualificado;
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
    public boolean getQualificado(){
        return qualificado;
    }
}
