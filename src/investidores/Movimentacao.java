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

}

