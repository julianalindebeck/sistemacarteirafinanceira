package leituraDeArquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ativos.Acao;
import ativos.Criptoativo;
import ativos.Fii;
import ativos.Stock;
import ativos.Tesouro;

public class Leitor {
    public static List<String[]> lerCSV(String caminho){
        List<String[]> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String linha;
            br.readLine(); 

            while ((linha = br.readLine()) != null){
                String[] partes = linha.split(",");
                linhas.add(partes);
            } 

        } catch (Exception e){
            System.out.println("Erro ao ler: " + caminho);
            e.printStackTrace();
        }

        return linhas;
    }

    public static List<Acao> listaAcao(){
        List<Acao> lista = new ArrayList<>();

        for (String[] c : lerCSV("arquivos/acao.csv")){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = Double.parseDouble(c[2]);
            int qualificado = Integer.parseInt(c[3]);

            lista.add(new Acao(nome, ticker, precoaAtual, qualificado));
        }

        return lista;
    }

    public static List<Fii> listaFii(){
        List<Fii> lista = new ArrayList<>();

        for (String[] c : lerCSV("arquivos/fii.csv")){
            String ticker = c[0];
            String nome = c[1];
            String segmento = c[2];
            double precoaAtual = Double.parseDouble(c[3]);
            double dividendo = Double.parseDouble(c[4]);
            double taxaAdm = Double.parseDouble(c[5]);

            lista.add(new Fii(nome, ticker, precoaAtual, segmento, dividendo, taxaAdm));
        }

        return lista;
    }

    public static List<Criptoativo> listaCriptoativo(){
        List<Criptoativo> lista = new ArrayList<>();

        for (String[] c : lerCSV("arquivos/acao.csv")){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = Double.parseDouble(c[2]);
            String algoritmo = c[3];
            int qtdMax = Integer.parseInt(c[4]);

            lista.add(new Criptoativo(nome, ticker, precoaAtual, algoritmo, qtdMax));
        }

        return lista;
    }

    public static List<Stock> listaStock(){
        List<Stock> lista = new ArrayList<>();

        for (String[] c : lerCSV("arquivos/stock.csv")){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = Double.parseDouble(c[2]);
            String bolsa = c[3];
            String setor = c[4];

            lista.add(new Stock(nome, ticker, precoaAtual, bolsa, setor));
        }

        return lista;
    }

    public static List<Tesouro> listaTesouro(){
        List<Tesouro> lista = new ArrayList<>();

        for (String[] c : lerCSV("arquivos/tesouro.csv")){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = Double.parseDouble(c[2]);
            String rendimento = c[3];
            String vencimento = c[4];

            lista.add(new Tesouro(nome, ticker, precoaAtual, rendimento, vencimento));
        }
        return lista;
    }

}
