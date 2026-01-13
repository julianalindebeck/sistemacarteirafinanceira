package ativos;

public abstract class AtivosInternacionais extends Ativos{
    protected double fatorConversao = 5.39;
    protected double precoReal;
    public AtivosInternacionais(String nome, String ticker, double precoAtual, boolean qualificado){
        super(nome, ticker, precoAtual, qualificado);
    }

    public void conversao(double precoAtual){
        precoReal = fatorConversao * precoAtual;
    }
}
