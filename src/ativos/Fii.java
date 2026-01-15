package ativos;

public class Fii extends AtivosNacionais {
    private String segmento;
    private double dividendo;
    private double taxaAdm;

    public Fii(String nome, String ticker, double precoAtual, String segmento, double dividendo, double taxaAdm){
        super(nome, ticker, precoAtual);
        this.segmento = segmento;
        this.dividendo = dividendo;
        this.taxaAdm = taxaAdm;
        rendaVariavel = true;
    }

    //interface?
    public void exibirTaxa(){
        System.out.println(taxaAdm + "%");
    }
    
}
