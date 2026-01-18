package leituraDeArquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import ativos.Acao;
import ativos.Criptoativo;
import ativos.Fii;
import ativos.Stock;
import ativos.Tesouro;
import investidores.Institucional;
import investidores.PessoaFisica;

public class Leitor {
    public static List<String[]> lerCSV(String caminho){
        List<String[]> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String linha;
            br.readLine(); 

            while ((linha = br.readLine()) != null){
                String[] partes = linha.split(";");
                linhas.add(partes);
            } 

        } catch (Exception e){
            System.out.println("Erro ao ler: " + caminho);
            e.printStackTrace();
        }

        return linhas;
    }

    //leitura dos ativos
    public static List<Acao> listaAcao(String caminho){
        List<Acao> lista = new ArrayList<>();

        for (String[] c : lerCSV(caminho)){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = converteDouble(c[2]);
            boolean qualificado = Boolean.parseBoolean(c[3]);

            lista.add(new Acao(nome, ticker, precoaAtual, qualificado));
        }

        //define o tipo baseado no último valor do ticker
        for(Acao a : lista){
            int pos = a.getTicker().length() - 1;

            if(a.getTicker().charAt(pos) == '3'){
                a.setTipo("Ordinária");
            }
            else if(a.getTicker().charAt(pos) == '1'){
                a.setTipo("Unit");
            }
            else {
                a.setTipo("Preferencial");
            }
        }

        return lista;
    }

    public static List<Criptoativo> listaCriptoativo(String caminho){
        List<Criptoativo> lista = new ArrayList<>();

        for (String[] c : lerCSV(caminho)){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = Double.parseDouble(c[2]);
            String algoritmo = c[3];

            String val;
            BigInteger qtdMax;

            try{
                val = c[4];
                qtdMax = new BigInteger(val);
            }
            catch(ArrayIndexOutOfBoundsException e){
                qtdMax = new BigInteger("0");
            }
            
            lista.add(new Criptoativo(nome, ticker, precoaAtual, algoritmo, qtdMax));
        }

        return lista;
    }

    public static List<Fii> listaFii(String caminho){
        List<Fii> lista = new ArrayList<>();

        for (String[] c : lerCSV(caminho)){
            String ticker = c[0];
            String nome = c[1];
            String segmento = c[2];
            double precoaAtual = converteDouble(c[3]);
            double dividendo = converteDouble(c[4]);
            double taxaAdm = converteDouble(c[5]);

            lista.add(new Fii(nome, ticker, precoaAtual, segmento, dividendo, taxaAdm));
        }

        return lista;
    }

    public static List<Tesouro> listaTesouro(String caminho){
        List<Tesouro> lista = new ArrayList<>();

        for (String[] c : lerCSV(caminho)){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = Double.parseDouble(c[2]);
            String rendimento = c[3];
            String vencimento = c[4];

            lista.add(new Tesouro(nome, ticker, precoaAtual, rendimento, vencimento));
        }
        return lista;
    }

    public static List<Stock> listaStock(String caminho){
        List<Stock> lista = new ArrayList<>();

        for (String[] c : lerCSV(caminho)){
            String ticker = c[0];
            String nome = c[1];
            double precoaAtual = Double.parseDouble(c[2]);
            String bolsa = c[3];
            String setor = c[4];

            lista.add(new Stock(nome, ticker, precoaAtual, bolsa, setor));
        }

        return lista;
    }

    //leitura dos investidores
    public static List<PessoaFisica> listaPessoaFisica(String caminho){
        List<PessoaFisica> lista = new ArrayList<>();

        for (String[] c : lerCSV(caminho)){
            String nome = c[0];
            String id = c[1];
            String telefone = c[2];
            String nascimento = c[3];
            String endereco = c[4];
            double patrimonio = converteDouble(c[5]);
            String perfil = c[6];

            lista.add(new PessoaFisica(nome, id, telefone, nascimento, endereco, patrimonio, perfil));
        }

        return lista;
    }

    public static List<Institucional> listaInstitucional(String caminho){
        List<Institucional> lista = new ArrayList<>();

        for (String[] c : lerCSV(caminho)){
            String nome = c[0];
            String id = c[1];
            String telefone = c[2];
            String nascimento = c[3];
            String endereco = c[4];
            double patrimonio = converteDouble(c[5]);
            String razao = c[6];

            lista.add(new Institucional(nome, id, telefone, nascimento, endereco, patrimonio, razao));
        }

        return lista;
    }

    //função para auxílio
    private static double converteDouble(String val){
        try{
            val = val.replace(".", "").replace(",", ".");
            return Double.parseDouble(val);
        }
        catch(NumberFormatException e){
            return 0.0;
        }
    } 
}
