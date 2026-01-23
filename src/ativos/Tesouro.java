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

    public String getVencimento(){
        return vencimento;
    }

    @Override
    public Ativos clonar(){
        Tesouro copia = new Tesouro(this.nome, this.ticker, this.precoAtual, this.rendimento, this.vencimento);
        copia.setQualificado(this.qualificado);
        copia.setQtd(this.qtd);
        return copia;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome  +
               ", ticker: " + ticker +
               ", preço: " + precoAtual +
               ", rendimento: " + rendimento +
               ", vencimento: " + vencimento +
               ", qualificado: " + qualificado +
               '.';
    }
}
