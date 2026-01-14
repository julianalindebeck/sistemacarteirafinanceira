package ativos;

public abstract class AtivosInternacionais extends Ativos {
    protected double fatorConversao = 5.39;
    
    public AtivosInternacionais(String nome, String ticker, double precoAtual){
        super(nome, ticker, precoAtual);
    }

    public double conversao(){
        return fatorConversao * precoAtual;
    }
    
}
