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
            System.out.println("========== MENU ==========");
            System.out.println("1. Ativo\n2. Investidor\n3. Sair");
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
            System.out.println("========== MENU ATIVO ==========");
            System.out.println("1. Cadastrar Ativo\n2. Cadastrar Ativo em Lote\n3. Editar Ativo\n4. Excluir Ativo\n5. Exibir relatório\n6. Voltar ao menu anterior");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") &&!escolha.equals("6"));
        
        if(escolha.equals("1")){
            cadastrarAtivo();
        }
        else if(escolha.equals("2")){
            cadastrarAtivoLote();
        }
        else if(escolha.equals("3")){
            editarAtivo();
        }
        else if(escolha.equals("4")){
            exlcuirAtivo();
        }
        else if(escolha.equals("5")){
            exibirRelatorioAtivo();
        }
        else{
            return;
        }
    }

    public static void cadastrarAtivo(){
        do{
            System.out.println("Escolha o tipo de ativo a ser cadastrado:\n1. Ação\n2. Criptoativo\n3. FII\n4. Stock\n5. Tesouro\n6. Voltar ao menu anterior");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") && !escolha.equals("6"));

        if(escolha.equals("1")){
            //cadastrarAção();
        }
        else if(escolha.equals("2")){
            //cadastrarCriptoativo();
        }
        else if(escolha.equals("3")){
            //cadastrarFii();
        }
        else if(escolha.equals("4")){
            //cadastrarStock();
        }
        else if(escolha.equals("5")){
            //cadastrarTesouro();
        }
        else{
            return;
        }
    }
    
    public static void cadastrarAtivoLote(){
        do{
            System.out.println("Escolha o tipo de ativo a ser cadastrado em lote:\n1. Ação\n2. Criptoativo\n3. FII\n4. Stock\n5. Tesouro\n6. Voltar ao menu anterior");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") && !escolha.equals("6"));

        if(escolha.equals("1")){
            //cadastrarAçãoLote();
        }
        else if(escolha.equals("2")){
            //cadastrarCriptoativoLote();
        }
        else if(escolha.equals("3")){
            //cadastrarFiiLote();
        }
        else if(escolha.equals("4")){
            //cadastrarStockLote();
        }
        else if(escolha.equals("5")){
            //cadastrarTesouroLote();
        }
        else{
            return;
        }
    }

    public static void editarAtivo(){
        do{
            System.out.println("Escolha:\n1. Ação\n2. Criptoativos\n3.FII\n4.Stock\n5.Tesouro");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5"));

        if(escolha.equals("1")){
            //acao
        }
        else if(escolha.equals("2")){
            //cripto
        }
        else if(escolha.equals("3")){
            //fii
        }
        else if(escolha.equals("4")){
            //stock
        }
        else{
            //tesouro
        }
    }
    
    public static void exlcuirAtivo(){
        do{
            System.out.println("Escolha:\n1. Ação\n2. Criptoativos\n3. FII\n4. Stock\n5. Tesouro");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5"));

        if(escolha.equals("1")){
            //acao
        }
        else if(escolha.equals("2")){
            //cripto
        }
        else if(escolha.equals("3")){
            //fii
        }
        else if(escolha.equals("4")){
            //stock
        }
        else{
            //tesouro
        }
    }
    
    public static void exibirRelatorioAtivo(){
        do{
            System.out.println("Escolha:1. Todos os Ativos \n2. Ação\n3. Criptoativos\n4. FII\n5. Stock\n6. Tesouro");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") && !escolha.equals("6"));

        if(escolha.equals("1")){
            //todos os ativos
        }
        else if(escolha.equals("2")){
            //acao
        }
        else if(escolha.equals("3")){
            //cripto
        }
        else if(escolha.equals("4")){
            //fii
        }
        else if(escolha.equals("5")){
            //stock
        }
        else{
            //tesouro
        }
    }

    public static void menuInvestidor(){
        System.out.println("========== MENU INVESTIDOR ==========");
        System.out.println("1. Cadastrar Investidor\n2. Cadastrar Investidor em Lote\n3. Exibir todos investidores\n4. Excluir investidores\n5. Selecionar investidor (por CPF ou CNPJ)\n6. Voltar ao menu anterior");
        escolha = leitura.nextLine();
        while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") &&!escolha.equals("6")){
            System.out.println("Opção invalida!");
            menuInvestidor();
        }
        if(escolha.equals("1")){
            cadastrarInvestidor();
        }
        else if(escolha.equals("2")){
            cadastrarInvestidorLote();
        }
        else if(escolha.equals("3")){
            exibirInvestidores();
        }
        else if(escolha.equals("4")){
            exlcuirInvestidor();
        }
        else if(escolha.equals("5")){
            selecionarInvestidor();
        }
        else{
            return;
        }
    }
    
    public static void cadastrarInvestidor(){
        System.out.println("========== CADASTRAR INVESTIDOR ==========");
        System.out.println("1. Pessoa Física\n2. Pessoa Jurídica\n3. Voltar ao menu anterior");
        escolha = leitura.nextLine();
        while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3")){
            System.out.println("Opção inválida! Escolha 1 para pessoa física ou 2 para pessoa jurídica");
            escolha = leitura.nextLine();
        }
        if(escolha.equals("1")){
            //cadastrarPessoaFisica();
        }
        else if(escolha.equals("2")){
            //cadastrarPessoaJuridica();
        }
        else{
            return;
        }
    }

    public static void cadastrarInvestidorLote(){
        System.out.println("========== CADASTRAR INVESTIDOR EM LOTE ==========");
        System.out.println("1. Pessoa Física\n2. Pessoa Jurídica\n3. Voltar ao menu anterior");
        escolha = leitura.nextLine();
        while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3")){
            System.out.println("Opção inválida! Escolha 1 para pessoa física ou 2 para pessoa jurídica");
            escolha = leitura.nextLine();
        }
        if(escolha.equals("1")){
            //cadastrarPessoaFisicaLote();
        }
        else if(escolha.equals("2")){
            //cadastrarPessoaJuridicaLote();
        }
        else{
            return;
        }
    }
    
    public static void exibirInvestidores(){
        //exibir todos investidores
    }
    
    public static void exlcuirInvestidor(){
        //excluir investidores
    }

    public static void selecionarInvestidor(){
        System.out.println("========== SELECIONAR INVESTIDOR ==========");
        System.out.println("Digite o CPF ou CNPJ do investidor:");
        String id = leitura.nextLine();
        //selecionar investidor pelo id
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
