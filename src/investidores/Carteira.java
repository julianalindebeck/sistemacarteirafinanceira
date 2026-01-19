package investidores;

import java.util.List;
import java.util.ArrayList;

import ativos.Ativos;
import ativos.AtivosInternacionais;
import ativos.AtivosNacionais;

public class Carteira {
    private List<Ativos> ativos = new ArrayList<>();
    private double quantidade;
    private double valorTotal = 0;
    private double rendaFixa = 0;
    private double rendaVariavel = 0; //double?
    private double internacionais = 0;
    private double nacionais = 0;

    public Carteira(){
        this.ativos = new ArrayList<>();
    }

    public void adicionarAtivo(Ativos novoAtivo){
        for(Ativos a : ativos){
            if(a.getTicker().equalsIgnoreCase(novoAtivo.getTicker())){
                a.setQtd(a.getQtd() + novoAtivo.getQtd());
                return;
            }
        }
        ativos.add(novoAtivo);
    } 
    
    public void removerAtivo(String ticker, double quantidade){
        for(Ativos a : ativos){
            if(a.getTicker().equalsIgnoreCase(ticker)){

                if(a.getQtd() < quantidade){
                    throw new IllegalArgumentException("Quantidade insuficiente para venda.");
                }

                a.setQtd(a.getQtd() - quantidade);

                if(a.getQtd() == 0){
                    ativos.remove(a);
                }
                return;
            }
        }
        throw new IllegalArgumentException("Ativo não encontrado na carteira.");
    }

    public List<Ativos> getAtivos(){
        return ativos;
    }

    public double getQuantidade(){
        return quantidade;
    } 

    public double getValorTotal(){
        for(Ativos a : ativos)
            valorTotal += a.getPrecoAtual();

        return valorTotal;
    }

    public double getPorcentagemRendaVar(){
        for(Ativos a : ativos){
            if(a.getRenda())
                rendaVariavel++;
        }

        return (rendaVariavel/quantidade) * 100;
    }

    public double getPorcentagemRendaFixa(){
        for(Ativos a : ativos){
            if(!a.getRenda())
                rendaFixa++;
        }

        return (rendaFixa/quantidade) * 100;
    }

    public double getPorcentagemInter(){
        for(Ativos a : ativos){
            if(a instanceof AtivosInternacionais)
                internacionais++;
        }

        return (internacionais/quantidade) * 100;
    }

    public double getPorcentagemNacional(){
        for(Ativos a : ativos){
            if(a instanceof AtivosNacionais)
                nacionais++;
        }

        return (nacionais/quantidade) * 100;
    }

}
