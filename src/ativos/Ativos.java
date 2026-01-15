package ativos;

public abstract class Ativos {
    protected String nome;
    protected String ticker;
    protected double precoAtual;
    protected boolean qualificado;
    protected boolean rendaVariavel;

    public Ativos(String nome, String ticker, double precoAtual){
        this.nome = nome;
        this.ticker = ticker;
        this.precoAtual = precoAtual;
        this.qualificado = false;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setTicker(String ticker){
        this.ticker = ticker;
    }

    public String getTicker(){
        return ticker;
    }
    
    public void setPrecoAtual(double precoAtual){
        this.precoAtual = precoAtual;
    }

    public double getPrecoAtual(){
        return precoAtual;
    }

    public void setQualificado(boolean qualificado){
        this.qualificado = qualificado;
    }

    public boolean getQualificado(){
        return this.qualificado;
    }

    public void setRenda(boolean renda){
        this.rendaVariavel = renda;
    }

    public boolean getRenda(){
        return rendaVariavel;
    }

}
