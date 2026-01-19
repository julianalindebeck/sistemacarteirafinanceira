package movimentacao;

import java.time.LocalDate;

import ativos.Ativos;

public abstract class Movimentacao {
    protected String id;
    protected String indicador;
    protected String instituicao;
    protected Ativos ativo;
    protected double qtdA;
    protected LocalDate data;
    protected double precoE;

    public Movimentacao(String id, String indicador, String instituicao, Ativos ativo, double qtdA, LocalDate data, double precoE) {
        this.id = id;
        this.indicador=indicador;
        this.instituicao = instituicao;
        this.ativo=ativo;
        this.qtdA = qtdA;
        this.data=data;
        this.precoE=precoE;
    }

    public static void realizarMovimentação(){
        
    }
   
}
