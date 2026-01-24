package relatorio;

import java.util.List;
import ativos.Ativos;

public class Relatorio {
    private String nome;
    private String id;
    private List<Ativos> ativos;
    private double valorTotalAtual;
    private double valorTotalGasto;
    private double porcentagemRendaFixa;
    private double porcentagemRendaVar;
    private double porcentagemNac;
    private double porcentagemInt;

    public Relatorio(
        String nome,
        String id,
        List<Ativos> ativos,
        double valorTotalAtual,
        double valorTotalGasto,
        double rendaFixa,
        double rendaVar,
        double nacional,
        double internacional
    ){
        this.nome = nome;
        this.id = id;
        this.ativos = ativos;
        this.valorTotalAtual = valorTotalAtual;
        this.valorTotalGasto = valorTotalGasto;
        this.porcentagemRendaFixa = rendaFixa;
        this.porcentagemRendaVar = rendaVar;
        this.porcentagemNac = nacional;
        this.porcentagemInt = internacional;
    }
}
