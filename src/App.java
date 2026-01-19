import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ativos.*;
import investidores.*;
import leituraDeArquivos.Leitor;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitura = new Scanner(System.in);

        //listas dos ativos
        List<Acao> acoes = Leitor.listaAcao("arquivos/acao.csv");
        List<Criptoativo> criptoativos = Leitor.listaCriptoativo("arquivos/criptoativo.csv");
        List<Fii> fiis = Leitor.listaFii("arquivos/fii.csv");
        List<Tesouro> tesouros = Leitor.listaTesouro("arquivos/tesouro.csv");
        List<Stock> stocks = Leitor.listaStock("arquivos/stock.csv");

        GerenciamentoAtivos gerenciamentoAtivos = new GerenciamentoAtivos(leitura, acoes, criptoativos, fiis, stocks, tesouros);

        //lista dos investidores
        List<PessoaFisica> pessoaFisica = new ArrayList<>();
        List<Institucional> institucional = new ArrayList<>();

        GerenciamentoInvestidores gerenciamentoInvestidores = new GerenciamentoInvestidores(leitura, pessoaFisica, institucional);

        //menu inicial
        boolean verifica = true;

        while(verifica){
            System.out.println("\n*------------* MENU INICIAL *------------*");
            System.out.println("(1) Ativos\n(2) Investidores\n(3) Sair");

            String escolha = leitura.nextLine();

            switch(escolha){
                case "1":
                    gerenciamentoAtivos.menuAtivo();
                    break;
                case "2":
                    gerenciamentoInvestidores.menuInvestidor();
                    break;
                case "3":
                    verifica = false;
                    break;
                default:
                    System.out.println("\nOpção inválida! Digite novamente.");
            }
        }

        leitura.close();

        encerrar();
        esperar(700);
        System.out.println("\nSistema encerrado.");
    }

    //funções de auxílio
    public static void esperar(long ms){
        try{
            Thread.sleep(ms);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public static void encerrar(){
        System.out.print("\nEncerrando");
        for(int i = 0; i < 3; i++){
            esperar(700);
            System.out.print(".");
        }
        System.out.println("");
    }

}
