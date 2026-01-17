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
            System.out.println("\nEscolha:\n(1) Ação\n(2) Criptoativos\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5"));

        if(escolha.equals("1")){
            exibirAcoes();
            editarAcao();
        }
        else if(escolha.equals("2")){
            exibirCriptoativos();
            editarCriptoativo();
        }
        else if(escolha.equals("3")){
            exibirFii();
            editarFii();
        }
        else if(escolha.equals("4")){
            exibirStock();
            editarStock();
        }
        else{
            exibirTesouro();
            editarTesouro();
        }
    }
    
    public static void excluirAtivo(){
        do{
            System.out.println("Escolha:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro");
            escolha = leitura.nextLine();
        }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3") && !escolha.equals("4") && !escolha.equals("5"));

        if(escolha.equals("1")){
            excluirAcao();
        }
        else if(escolha.equals("2")){
            excluirCriptoativo();
        }
        else if(escolha.equals("3")){
            excluirFii();
        }
        else if(escolha.equals("4")){       
            excluirStock();
        }
        else{
            excluirTesouro();
        }
    }
    
    public static void exibirRelatorioAtivo(){
        do{
            System.out.println("Escolha:\n(1) Todos os Ativos \n(2) Ação\n(3) Criptoativo\n(4) Fundo de Investimento Imobiliário\n(5) Stock\n(6) Tesouro");
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
        for (Acao a : acoes) {
            System.out.println(a);
        }
    }

    public static void exibirCriptoativos(){
        for (Criptoativo c : criptoativos) {
            System.out.println(c);
        }
    }

    public static void exibirFii(){
        for (Fii f : fiis) {
            System.out.println(f);
        }
    }

    public static void exibirStock(){
        for (Stock s : stocks) {
            System.out.println(s);
        }
    }

    public static void exibirTesouro(){
        for (Tesouro t : tesouros) {
            System.out.println(t);
        }
    }

    private static Acao buscarAcao(String ticker) {
        for (Acao a : acoes) {
            if (a.getTicker().equalsIgnoreCase(ticker)) {
                return a;
            }
        }
        return null;
    }

    private static Criptoativo buscarCriptoativo(String ticker) {
        for (Criptoativo c : criptoativos) {
            if (c.getTicker().equalsIgnoreCase(ticker)) {
                return c;
            }
        }
        return null;
    }

    private static Fii buscarFii(String ticker) {
        for (Fii f : fiis) {
            if (f.getTicker().equalsIgnoreCase(ticker)) {
                return f;
            }
        }
        return null;
    }

    private static Stock buscarStock(String ticker) {
        for (Stock s : stocks) {
            if (s.getTicker().equalsIgnoreCase(ticker)) {
                return s;
            }
        }
        return null;
    }

    private static Tesouro buscarTesouro(String ticker) {
        for (Tesouro t : tesouros) {
            if (t.getTicker().equalsIgnoreCase(ticker)) {
                return t;
            }
        }
        return null;
    }

    private static void editarAcao() {
        System.out.print("Digite o ticker da ação que deseja editar: ");
        String ticker = leitura.nextLine();

        Acao a = buscarAcao(ticker);

        if (a == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nAção encontrada!");

        System.out.print("Digite o novo nome: ");
        a.setNome(leitura.nextLine());

        System.out.print("Digite o novo preço: ");
        a.setPrecoAtual(verificaDouble());

        System.out.print("Digite o novo qualificado: ");
        a.setQualificado(verificaQualificado());

        System.out.println("Ação atualizada com sucesso!");
    }

    private static void editarCriptoativo() {
        System.out.print("Digite o ticker da ação que deseja editar: ");
        String ticker = leitura.nextLine();

        Criptoativo c = buscarCriptoativo(ticker);

        if (c == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nAção encontrada!");

        System.out.print("Digite o novo nome: ");
        c.setNome(leitura.nextLine());

        System.out.print("Digite o novo preço: ");
        c.setPrecoAtual(verificaDouble());

        System.out.print("Digite o novo Algoritmo: ");
        c.setAlgoritmo(leitura.nextLine());

        BigInteger novaQtdMax;

        while (true) {
            try {
                System.out.print("Digite a nova Quantidade Máxima: ");
                String valor = leitura.nextLine();
                novaQtdMax = new BigInteger(valor);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro válido.");
            }
        }
        c.setQtdMax(novaQtdMax);

        System.out.print("Digite o novo qualificado: ");
        c.setQualificado(verificaQualificado());

        System.out.println("Ação atualizada com sucesso!");
    }
    
    private static void editarFii(){
        System.out.print("Digite o ticker do FII que deseja editar: ");
        String ticker = leitura.nextLine();
        Fii f = buscarFii(ticker);
        
        if (f == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nFII encontrado!");
        System.out.print("Digite o novo nome: ");
        f.setNome(leitura.nextLine());

        System.out.print("Digite o novo preço: ");
        f.setPrecoAtual(verificaDouble());

        System.out.print("Digite o novo segmento: ");
        f.setSegmento(leitura.nextLine());

        System.out.print("Digite o novo dividendo: ");
        f.setDividendo(verificaDouble());

        System.out.print("Digite o novo TaxaAdm: ");
        f.setTaxaAdm(verificaDouble());

        System.out.print("Digite o novo TaxaAdm: ");
        f.setQualificado(verificaQualificado());

        System.out.println("Fii atualizado com sucesso!");
    }
    
    private static void editarStock(){
        System.out.print("Digite o ticker do Stock que deseja editar: ");
        String ticker = leitura.nextLine();
        Stock s = buscarStock(ticker);

        if (s == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nStock encontrado!");
        System.out.print("Digite o novo nome: ");
        s.setNome(leitura.nextLine());

        System.out.print("Digite o novo preço: ");
        s.setPrecoAtual(verificaDouble());

        System.out.print("Digite a nova bolsa: ");
        s.setBolsa(leitura.nextLine());

        System.out.print("Digite o novo setor: ");
        s.setSetor(leitura.nextLine());

        System.out.print("Digite o novo qualificado: ");
        s.setQualificado(verificaQualificado());

        System.out.println("Stock atualizado com sucesso!");
    
    }
    
    private static void editarTesouro(){
        System.out.print("Digite o ticker do Tesouro que deseja editar: ");
        String ticker = leitura.nextLine();
        Tesouro t = buscarTesouro(ticker);

        if (t == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nTesouro encontrado!");
        System.out.print("Digite o novo nome: ");
        t.setNome(leitura.nextLine());
        
        System.out.print("Digite o novo preço: ");
        t.setPrecoAtual(verificaDouble());

        System.out.print("Digite o novo rendimento: ");
        t.setRendimento(leitura.nextLine());

        System.out.print("Digite o novo vencimento: ");
        t.setVencimento(leitura.nextLine());

        System.out.print("Digite o novo qualificado: ");
        t.setQualificado(verificaQualificado());

        System.out.println("Tesouro atualizado com sucesso!");
    }
    
    private static void excluirAcao() {
        exibirAcoes();

        System.out.print("\nDigite o ticker da ação que deseja excluir: ");
        String ticker = leitura.nextLine();

        Acao a = buscarAcao(ticker);

        if (a == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nAção encontrada");

        acoes.remove(a);
        System.out.println("\nAção excluída com sucesso!");
    }

    private static void excluirCriptoativo() {
        exibirCriptoativos();

        System.out.print("\nDigite o ticker do criptoativo que deseja excluir: ");
        String ticker = leitura.nextLine();

        Criptoativo c = buscarCriptoativo(ticker);

        if (c == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nCriptoativo encontrado");

        criptoativos.remove(c);
        System.out.println("\nCriptoativo excluído com sucesso!");
    }
    
    private static void excluirFii() {
        exibirFii();

        System.out.print("\nDigite o ticker do FII que deseja excluir: ");
        String ticker = leitura.nextLine();

        Fii f = buscarFii(ticker);

        if (f == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nFII encontrado");

        fiis.remove(f);
        System.out.println("\nFII excluído com sucesso!");
    }

    private static void excluirStock() {
        exibirStock();

        System.out.print("\nDigite o ticker do Stock que deseja excluir: ");
        String ticker = leitura.nextLine();

        Stock s = buscarStock(ticker);

        if (s == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nStock encontrado");

        stocks.remove(s);
        System.out.println("\nStock excluído com sucesso!");
    }

    private static void excluirTesouro() {
        exibirTesouro();

        System.out.print("\nDigite o ticker do Tesouro que deseja excluir: ");
        String ticker = leitura.nextLine();

        Tesouro t = buscarTesouro(ticker);

        if (t == null) {
            System.out.println("\nTicker não encontrado.");
            return;
        }

        System.out.println("\nTesouro encontrado");

        tesouros.remove(t);
        System.out.println("\nTesouro excluído com sucesso!");
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
