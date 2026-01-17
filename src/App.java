import java.math.BigInteger;
import java.util.InputMismatchException;
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

    static List<Acao> acoes;
    static List<Criptoativo> criptoativos;
    static List<Fii> fiis;
    static List<Tesouro> tesouros;
    static List<Stock> stocks;

    public static void main(String[] args) throws Exception {
        //leitura dos ativos
        acoes = Leitor.listaAcao("arquivos/acao.csv");
        criptoativos = Leitor.listaCriptoativo("arquivos/criptoativo.csv");
        fiis = Leitor.listaFii("arquivos/fii.csv");
        tesouros = Leitor.listaTesouro("arquivos/tesouro.csv");
        stocks = Leitor.listaStock("arquivos/stock.csv");

        menuInicial();
    }

    public static void menuInicial(){
        boolean executar = true;

        while(executar){  
            System.out.println("\n*------------*\nMENU\n*------------*");
            System.out.println("(1) Ativo\n(2) Investidor\n(3) Sair");

            escolha = leitura.nextLine();
            while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3")){
                System.out.println("Opção inválida! Escolha (1) para Ativo ou (2) para Investidor.");
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
        }
    }

    //ativos
    public static void menuAtivo(){
        do{
            System.out.println("\n*------------*\nMENU ATIVO\n*------------*");
            System.out.println("(1) Cadastrar Ativo\n(2) Cadastrar Ativo em lote\n(3) Editar Ativo\n(4) Excluir Ativo\n(5) Exibir relatório\n(6) Voltar ao menu anterior");

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
            excluirAtivo();
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
            System.out.println("\nEscolha o tipo de ativo a ser cadastrado:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro\n(6) Voltar ao menu anterior");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") && !escolha.equals("6"));

        cadastrar();
    }
    
    public static void cadastrarAtivoLote(){
        do{
            System.out.println("\nEscolha o tipo de ativo a ser cadastrado em lote:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro\n(6) Voltar ao menu anterior");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") && !escolha.equals("6"));

        System.out.println("\nInforme o caminho do arquivo: ");
        escolha = leitura.nextLine();

        if(escolha.equals("1")){
            List<Acao> acoesLote = Leitor.listaAcao(escolha);
        }
        else if(escolha.equals("2")){
            List<Criptoativo> criptoativosLote = Leitor.listaCriptoativo(escolha);
        }
        else if(escolha.equals("3")){
            List<Fii> fiiLote = Leitor.listaFii(escolha);
        }
        else if(escolha.equals("4")){
            List<Stock> stocksLote = Leitor.listaStock(escolha);
        }
        else if(escolha.equals("5")){
            List<Tesouro> tesourosLote = Leitor.listaTesouro(escolha);
        }
        else{
            return;
        }

        System.out.println("\nCadastramento de Ativo realizado com sucesso!");
    }

    public static void editarAtivo(){
        do{
            System.out.println("Escolha:\n(1) Ação\n(2) Criptoativos\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro");
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
    
    public static void excluirAtivo(){
        do{
            System.out.println("Escolha:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro");
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
            System.out.println("Escolha:(1) Todos os Ativos \n(2) Ação\n(3) Criptoativo\n(4) Fundo de Investimento Imobiliário\n(5) Stock\n(6) Tesouro");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") && !escolha.equals("6"));

        if(escolha.equals("1")){
            exibirTodos();
        }
        else if(escolha.equals("2")){
            exibirAcoes();
        }
        else if(escolha.equals("3")){
            exibirCriptoativos();
        }
        else if(escolha.equals("4")){
            exibirFii();
        }
        else if(escolha.equals("5")){
            exibirStock();
        }
        else{
            exibirTesouro();
        }
    }

    public static void exibirTodos(){
        exibirAcoes();
        exibirCriptoativos();
        exibirFii();
        exibirStock();
        exibirTesouro();
    }

    public static void exibirAcoes(){

    }

    public static void exibirCriptoativos(){

    }

    public static void exibirFii(){

    }

    public static void exibirStock(){

    }

    public static void exibirTesouro(){

    }
    //investidores
    public static void menuInvestidor(){
        System.out.println("\n*------------*\nMENU INVESTIDOR\n*------------*");
        System.out.println("(1) Cadastrar Investidor\n(2) Cadastrar Investidor em lote\n(3) Exibir todos Investidores\n(4) Excluir Investidores\n(5) Selecionar Investidor (por CPF ou CNPJ)\n(6) Voltar ao menu anterior");
        
        escolha = leitura.nextLine();
        while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5") &&!escolha.equals("6")){
            System.out.println("Opção inválida!");
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
            excluirInvestidor();
        }
        else if(escolha.equals("5")){
            selecionarInvestidor();
        }
        else{
            return;
        }
    }
    
    public static void cadastrarInvestidor(){
        System.out.println("*------------*\nCADASTRAR INVESTIDOR\n*------------*");
        System.out.println("(1) Pessoa Física\n(2) Pessoa Jurídica\n(3) Voltar ao menu anterior");
        
        escolha = leitura.nextLine();
        while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3")){
            System.out.println("Opção inválida! Escolha (1) para Pessoa Física ou (2) para Pessoa Jurídica.");
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
        System.out.println("*------------*\nCADASTRAR INVESTIDOR EM LOTE\n*------------*");
        System.out.println("(1) Pessoa Física\n(2) Pessoa Jurídica\n(3) Voltar ao menu anterior");
        
        escolha = leitura.nextLine();
        while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3")){
            System.out.println("Opção inválida! Escolha (1) para Pessoa Física ou (2) para Pessoa Jurídica.");
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
    
    public static void excluirInvestidor(){
        //excluir investidores
    }

    public static void selecionarInvestidor(){
        System.out.println("*------------*\nSELECIONAR INVESTIDOR\n*------------*");
        System.out.println("Digite o CPF ou CNPJ do Investidor: ");
        String id = leitura.nextLine();
        //selecionar investidor pelo id
    }

    public static void cadastrar(){
        System.out.println("\nDigite o nome: ");
        String nome = leitura.nextLine();

        System.out.println("\nDigite o ticker: ");
        String ticker = leitura.nextLine();

        System.out.println("\nDigite o preço: ");
        double precoAtual = verificaDouble();

        if(escolha.equals("1")){
            boolean qualificado = verificaQualificado();

            acoes.add(new Acao(nome, ticker, precoAtual, qualificado));
        }
        else if(escolha.equals("2")){
            boolean qualificado = verificaQualificado();

            System.out.println("\nDigite o algoritmo de consenso: ");
            String algoritmo = leitura.nextLine();

            BigInteger qtdMax = BigInteger.ZERO;

            while (true){
                try{
                    System.out.println("\nDigite a quantidade máxima: ");
                    String valor = leitura.nextLine();
                    qtdMax = new BigInteger(valor);
                    break;
                } catch(NumberFormatException e){
                    System.out.println("Entrada inválida!");
                }
            }
            Criptoativo ativoCriptoativo = new Criptoativo(nome, ticker, precoAtual, algoritmo, qtdMax);
            ativoCriptoativo.setQualificado(qualificado);
            criptoativos.add(ativoCriptoativo);
        }
        else if(escolha.equals("3")){
            boolean qualificado = verificaQualificado();

            System.out.println("\nDigite o segmento: ");
            String segmento = leitura.nextLine();

            System.out.println("\nDigite o dividendo: ");
            double dividendo = verificaDouble();

            System.out.println("\nDigite a taxa de administração: ");
            double taxaAdm = verificaDouble();

            Fii ativoFii = new Fii(nome, ticker, precoAtual, segmento, dividendo, taxaAdm);
            ativoFii.setQualificado(qualificado);
            fiis.add(ativoFii);
        }
        else if(escolha.equals("4")){
            boolean qualificado = verificaQualificado();

            System.out.println("\nDigite a bolsa de negociação: ");
            String bolsa = leitura.nextLine();

            System.out.println("\nDigite o setor da empresa: ");
            String setor = leitura.nextLine();

            Stock ativoStock = new Stock(nome, ticker, precoAtual, bolsa, setor);
            ativoStock.setQualificado(qualificado);
            stocks.add(ativoStock);
        }
        else if(escolha.equals("5")){
            boolean qualificado = verificaQualificado();

            System.out.println("\nDigite o rendimento: ");
            String rendimento = leitura.nextLine();

            System.out.println("\nDigite o vencimento: ");
            String vencimento = leitura.nextLine();

            Tesouro ativoTesouro = new Tesouro(nome, ticker, precoAtual, rendimento, vencimento);
            ativoTesouro.setQualificado(qualificado);
            tesouros.add(ativoTesouro);
        }
        else{
            return;
        }

        carregar();
        System.out.println("\nAtivo cadastrado com sucesso!");
    }

    public static double verificaDouble(){
        while(true){
            try{
                double valor = leitura.nextDouble();
                leitura.nextLine();
                return valor;
            } catch(InputMismatchException e){
                System.out.println("Entrada Inválida! Digite novamente.");
                leitura.nextLine();
            }
        }
    }
    
    public static boolean verificaQualificado(){
        while(true){
            try{
                System.out.println("\nDigite o qualificado: ");
                boolean qualificado = leitura.nextBoolean();
                leitura.nextLine();
                return qualificado;
            } catch(InputMismatchException e){
                System.out.println("Entrada inválida!");
                leitura.nextLine();
            }
        }
    }

    private static void carregar(){
        System.out.print("\nCarregando");
        for(int i = 0; i < 3; i++){
            esperar(700);
            System.out.print(".");
        }
        System.out.println("");
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
