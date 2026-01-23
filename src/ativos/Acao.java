package ativos;

public class Acao extends AtivosNacionais {
    private String tipo;

    public Acao(String nome, String ticker, double precoAtual, boolean qualificado){
        super(nome, ticker, precoAtual);
        this.qualificado = qualificado;
        rendaVariavel = true;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public Ativos clonar(){
        Acao copia = new Acao(this.nome, this.ticker, this.precoAtual, this.qualificado);
        copia.setTipo(this.tipo);
        copia.setQtd(this.qtd);
        return copia;
    }

    @Override
    public String toString() {
        return "Nome: " + nome  +
               ", ticker: " + ticker +
               ", preço: " + precoAtual +
               ", qualificado: " + qualificado +
               '.';
    }
    
}
