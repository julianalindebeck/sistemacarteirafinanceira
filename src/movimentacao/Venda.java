package movimentacao;

import java.time.LocalDate;

import ativos.Ativos;

public class Venda extends Movimentacao{
    public Venda(String id, String indicador, String instituicao, Ativos ativo, double qtdA, LocalDate data, double precoE){
        super(id, "VENDA",instituicao,ativo, qtdA, data, precoE);
    }
}
