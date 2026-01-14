import java.util.List;
import java.util.Scanner;

import ativos.Criptoativo;
import ativos.Acao;
import ativos.Fii;
import ativos.Stock;
import ativos.Tesouro;
import leituraDeArquivos.Leitor;

public class App {
    static Scanner leitura = new Scanner(System.in);
    static String escolha;
    public static void main(String[] args) throws Exception {
        List<Acao> acoes = Leitor.listaAcao();
        List<Criptoativo> criptoativos = Leitor.listaCriptoativo();
        //List<Fii> fiis = Leitor.listaFii();
        //List<Tesouro> tesouros = Leitor.listaTesouro();
        //List<Stock> stocks = Leitor.listaStock();

        /*for (Fii a : fiis) {
            System.out.println(a);
        }*/
       
        //menu inicial 
        menuInicial();
    }

    public static void menuInicial(){
        boolean executar = true;
        while(executar){  
            System.out.println("MENU");
            System.out.println("1.Ativo\n2.Investidor\n3.Sair");
            escolha = leitura.nextLine();
            while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3")){
                System.out.println("Opção inválida! Escolha 1 para ativo ou 2 para investidor");
                escolha = leitura.nextLine();
            }
            if(escolha.equals("1")){
                menuAtivo();
            }
            else if(escolha.equals("2")){
                menuInvestidor();
            }
            else{
                executar = false;
            }
            esperar(100);
        }
    }

    public static void menuAtivo(){
        do{
            System.out.println("MENU ATIVO");
            System.out.println("1.Cadastrar Ativo\n2.Cadastrar Ativo em Lote\n3.Editar Ativo\n4.Excluir Ativo\n5.Exibir relatório\n6.Voltar ao menu anterior");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") &&!escolha.equals("6"));
        
        if(escolha.equals("1")){
            //cadastrarAtivo();
        }
        else if(escolha.equals("2")){
            //cadastrarAtivoLote();
        }
        else if(escolha.equals("3")){
            //editarAtivo();
        }
        else if(escolha.equals("4")){
            //exlcuirAtivo();
        }
        else if(escolha.equals("5")){
            //exibirRelatorioAtivo();
        }
        else{
            return;
        }
    }

    public static void menuInvestidor(){
        System.out.println("MENU INVESTIDOR");
        System.out.println("1.Cadastrar Investidor\n2.Cadastrar Investidor em Lote\n3.Exibir todos investidores\n4.Excluir investidores\n5.Selecionar investidor (por CPF ou CNPJ)\n6.Voltar ao menu anterior");
        escolha = leitura.nextLine();
        while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") &&!escolha.equals("6")){
            System.out.println("Opção invalida!");
            menuInvestidor();
        }
        if(escolha.equals("1")){
            //cadastrarInvestidor();
        }
        else if(escolha.equals("2")){
            //cadastrarInvestidorLote();
        }
        else if(escolha.equals("3")){
            //exibirInvestidores();
        }
        else if(escolha.equals("4")){
            //exlcuirInvestidor();
        }
        else if(escolha.equals("5")){
            //selecionarInvestidor();
        }
        else{
            return;
        }
    }

    private static void esperar(long ms){
        try{
            Thread.sleep(ms);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
