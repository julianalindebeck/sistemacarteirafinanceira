package ativos;

import excecoes.InvalidPriceException;
import excecoes.InvalidTickerException;

public abstract class Ativos {
    protected String nome;
    protected String ticker;
    protected double precoAtual;
    protected boolean qualificado;
    protected boolean rendaVariavel;
    protected double qtd;

    public Ativos(String nome, String ticker, double precoAtual){
        this.nome = nome;
        setTicker(ticker);
        this.precoAtual = precoAtual;
        this.qualificado = false;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setQtd(double qtd){
        this.qtd = qtd;
    }

    public double getQtd(){
        return qtd;
    }

    public void setTicker(String ticker){
        if(ticker == null || ticker == "0"){
            throw new InvalidTickerException();
        }

        this.ticker = ticker;
    }

    public String getTicker(){
        return ticker;
    }
    
    public void setPrecoAtual(double precoAtual){
        if(precoAtual <= 0){
            throw new InvalidPriceException();
        }
        
        this.precoAtual = precoAtual;
    }

    public double getPrecoAtual(){
        return precoAtual;
    }

    public void setQualificado(boolean qualificado){
        this.qualificado = qualificado;
    }

    public boolean getQualificado(){
        return this.qualificado;
    }

    public void setRenda(boolean renda){
        this.rendaVariavel = renda;
    }

    public boolean getRenda(){
        return rendaVariavel;
    }

}
