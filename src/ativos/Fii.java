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

    public void setSegmento(String segmento){
        this.segmento = segmento;
    }

    public String getSegmento(){
        return segmento;
    }

    public void setDividendo(double dividendo){
        this.dividendo = dividendo;
    }

    public double getDividendo(){
        return dividendo;
    }
    
    public void setTaxaAdm(double taxaAdm){
        this.taxaAdm = taxaAdm;
    }

    public double getTaxaAdm(){
        return taxaAdm;
    }

    @Override
    public String toString() {
        return "FII | " +
                "Nome: " + nome  +
                ", Ticker: " + ticker +
                ", Preço: " + precoAtual +
                ", Segmento: " + segmento +
                ", Dividendo: " + dividendo +
                ", Taxa: " + taxaAdm +
                '.';
    }
}
