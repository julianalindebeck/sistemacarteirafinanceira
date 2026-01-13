package ativos;

public abstract class AtivosNacionais extends Ativos{
    public AtivosNacionais(String nome, String ticker, double precoAtual, boolean qualificado){
        super(nome, ticker, precoAtual, qualificado);
    }
}
