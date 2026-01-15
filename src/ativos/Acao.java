package ativos;

public class Acao extends AtivosNacionais {
    private String tipo;
    private boolean qualificado;

    public Acao(String nome, String ticker, double precoAtual, boolean qualificado){
        super(nome, ticker, precoAtual);
        this.qualificado = qualificado;
        rendaVariavel = true;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

}
