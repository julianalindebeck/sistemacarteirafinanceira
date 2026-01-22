package investidores;

import java.util.List;
import java.util.ArrayList;

import ativos.Ativos;
import ativos.AtivosInternacionais;
import ativos.AtivosNacionais;

public class Carteira {
    private List<Ativos> ativos = new ArrayList<>();

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

    public void imprimirCarteira(){
        if(ativos.isEmpty()){
            System.out.println("Carteira vazia.");
            return;
        }

        System.out.println("Carteira: ");

        for(Ativos a : ativos){
            System.out.println(
                "Ticker: " + a.getTicker() +
                " | Quantidade: " + a.getQtd() +
                " | Preço: " + a.getPrecoAtual()
            );
        }
    }

    //qtd total de ativos na carteira
    public double getQuantidade(){
        double quantidade = 0;

        for(Ativos a : ativos){
            quantidade += a.getQtd();
        }

        return quantidade;
    }

    public double getValorTotal(){
        double total = 0;

        for (Ativos a : ativos) {
            total += a.getPrecoAtual() * a.getQtd();
        }

        return total;
    }

    public double getPorcentagemRendaVar(){
        double total = getQuantidade();
        if(total == 0) return 0;

        double rendaVariavel = 0;

        for(Ativos a : ativos){
            if(a.getRenda())
                rendaVariavel += a.getQtd();
        }

        return (rendaVariavel/total) * 100;
    }

    public double getPorcentagemRendaFixa(){
        double total = getQuantidade();
        if(total == 0) return 0;

        double rendaFixa = 0;

        for(Ativos a : ativos){
            if(!a.getRenda())
                rendaFixa += a.getQtd();
        }

        return (rendaFixa/total) * 100;
    }

    public double getPorcentagemInter(){
        double total = getQuantidade();
        if(total == 0) return 0;

        double internacionais = 0;

        for(Ativos a : ativos){
            if(a instanceof AtivosInternacionais)
                internacionais += a.getQtd();
        }

        return (internacionais/total) * 100;
    }

    public double getPorcentagemNacional(){
        double total = getQuantidade();
        if(total == 0) return 0;

        double nacionais = 0;
        
        for(Ativos a : ativos){
            if(a instanceof AtivosNacionais)
                nacionais += a.getQtd();
        }

        return (nacionais/total) * 100;
    }

}
