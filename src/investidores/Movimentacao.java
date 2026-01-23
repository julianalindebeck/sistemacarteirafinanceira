package investidores;

public class Movimentacao {

    private String id;
    private String indicador;   
    private String instituicao;
    private String ativo;       
    private double qtd;
    private String data;
    private double preco;

    public Movimentacao(
        String id,
        String indicador,
        String instituicao,
        String ativo,
        double qtd,
        String data,
        double preco
    ) {
        this.id = id;
        this.indicador = indicador;
        this.instituicao = instituicao;
        this.ativo = ativo;
        this.qtd = qtd;
        this.data = data;
        this.preco = preco;
    }

    public boolean verificaCompra(){
        return indicador.equalsIgnoreCase("C");
    }

    public boolean verificaVenda(){
        return indicador.equalsIgnoreCase("V");
    }

    public String getId(){
        return this.id;
    }

    public String getInstituicao(){
        return this.instituicao;
    }

    public String getAtivo(){
        return this.ativo;
    }

    public double getQtd(){
        return this.qtd;
    }

    public String getData(){
        return this.data;
    }

    public double getPreco(){
        return this.preco;
    }

}
