package movimentacao;

import java.time.LocalDate;

import ativos.Ativos;
import investidores.Institucional;
import investidores.Investidor;
import investidores.PessoaFisica;

public class Compra extends Movimentacao {
    public Compra(String id, String indicador, String instituicao, Ativos ativo, double qtdA, LocalDate data, double precoE){
        super(id, "COMPRA",instituicao,ativo, qtdA, data, precoE);
    }
    
}
