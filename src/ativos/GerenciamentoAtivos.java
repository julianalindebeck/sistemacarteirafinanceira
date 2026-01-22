package ativos;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import excecoes.InvalidPriceException;
import leituraDeArquivos.Leitor;
import java.math.BigInteger;

public class GerenciamentoAtivos {
    private Scanner leitura;
    private String escolha;

    private List<Acao> acoes;
    private List<Criptoativo> criptoativos;
    private List<Fii> fiis;
    private List<Stock> stocks;
    private List<Tesouro> tesouros;

    public GerenciamentoAtivos(Scanner leitura,
        List<Acao> acoes,
        List<Criptoativo> criptoativos,
        List<Fii> fiis,
        List<Stock> stocks,
        List<Tesouro> tesouros
    ){
        this.leitura = leitura;
        this.acoes = acoes;
        this.criptoativos = criptoativos;
        this.fiis = fiis;
        this.stocks = stocks;
        this.tesouros = tesouros;
    }

    public void menuAtivo(){
        do{
            System.out.println("\n*------------* MENU ATIVO *------------*");
            System.out.println("(1) Cadastrar Ativo\n(2) Cadastrar Ativo em lote\n(3) Editar Ativo\n(4) Excluir Ativo\n(5) Exibir relatório\n(6) Voltar ao menu inicial");

            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-6]"));
        
        switch(escolha){
            case "1":
                cadastrarAtivo();
                break;
            case "2":
                cadastrarAtivoLote();
                break;
            case "3":
                editarAtivo();
                break;
            case "4":
                excluirAtivo();
                break;
            case "5":
                exibirRelatorioAtivo();
                break;
            case "6":
                return;
        }
    }

    //cadastrar ativos
    private void cadastrarAtivo(){
        do{
            System.out.println("\nEscolha o tipo de ativo a ser cadastrado:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro\n(6) Voltar ao menu inicial");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-6]"));

        cadastrar();
    }
    
    private void cadastrarAtivoLote(){
        do{
            System.out.println("\nEscolha o tipo de ativo a ser cadastrado em lote:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro\n(6) Voltar ao menu inicial");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-6]"));

        System.out.println("\nInforme o caminho do arquivo: ");
        String caminho = leitura.nextLine();

        switch(escolha){
            case "1":
                List<Acao> acaoLote = Leitor.listaAcao(caminho);
                acoes.addAll(acaoLote);
                break;
            case "2":
                List<Criptoativo> criptoLote = Leitor.listaCriptoativo(caminho);
                criptoativos.addAll(criptoLote);
                break;
            case "3":
                List<Fii> fiiLote = Leitor.listaFii(caminho);
                fiis.addAll(fiiLote);
                break;
            case "4":
                List<Stock> stockLote = Leitor.listaStock(caminho);
                stocks.addAll(stockLote);
                break;
            case "5":
                List<Tesouro> tesouroLote = Leitor.listaTesouro(caminho);
                tesouros.addAll(tesouroLote);
                break;
            case "6":
                return;
        }

        carregar();
        esperar(700);
        System.out.println("\nCadastramento de Ativo realizado com sucesso!");
    }

    private void cadastrar(){
        if (escolha.equals("6")) {
            return;
        }

        System.out.println("\nDigite o nome: ");
        String nome = leitura.nextLine();

        System.out.println("\nDigite o ticker: ");
        String ticker = leitura.nextLine();

        System.out.println("\nDigite o preço: ");
        double precoAtual = verificaPreco();

        switch(escolha){
            case "1": {
                boolean qualificado = verificaQualificado();

                acoes.add(new Acao(nome, ticker, precoAtual, qualificado));
                break;
            }
            case "2": {
                boolean qualificado = verificaQualificado();

                System.out.println("\nDigite o algoritmo de consenso: ");
                String algoritmo = leitura.nextLine();

                BigInteger qtdMax;
                while(true){
                    try{
                        System.out.println("\nDigite a quantidade máxima: ");
                        qtdMax = new BigInteger(leitura.nextLine());
                        break;
                    } catch (NumberFormatException e){
                        System.out.println("\nEntrada inválida! Digite novamente.");
                    }
                }

                Criptoativo cripto = new Criptoativo(nome, ticker, precoAtual, algoritmo, qtdMax);
                cripto.setQualificado(qualificado);
                criptoativos.add(cripto);
                break;
            }
            case "3": {
                boolean qualificado = verificaQualificado();

                System.out.println("\nDigite o segmento: ");
                String segmento = leitura.nextLine();

                System.out.println("\nDigite o dividendo: ");
                double dividendo = verificaDouble();

                System.out.println("\nDigite a taxa de administração: ");
                double taxaAdm = verificaDouble();

                Fii fii = new Fii(nome, ticker, precoAtual, segmento, dividendo, taxaAdm);
                fii.setQualificado(qualificado);
                fiis.add(fii);
                break;
            }

            case "4": {
                boolean qualificado = verificaQualificado();

                System.out.println("\nDigite a bolsa de negociação: ");
                String bolsa = leitura.nextLine();

                System.out.println("\nDigite o setor da empresa: ");
                String setor = leitura.nextLine();

                Stock stock = new Stock(nome, ticker, precoAtual, bolsa, setor);
                stock.setQualificado(qualificado);
                stocks.add(stock);
                break;
            }
            case "5": {
                boolean qualificado = verificaQualificado();

                System.out.println("\nDigite o rendimento: ");
                String rendimento = leitura.nextLine();

                System.out.println("\nDigite o vencimento: ");
                String vencimento = leitura.nextLine();

                Tesouro tesouro = new Tesouro(nome, ticker, precoAtual, rendimento, vencimento);
                tesouro.setQualificado(qualificado);
                tesouros.add(tesouro);
                break;
            }
        }

        carregar();
        esperar(500);
        System.out.println("\nAtivo cadastrado com sucesso!");
    }

    //editar ativos
    private void editarAtivo(){
        do{
            System.out.println("\nEscolha o ativo que deseja alterar:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-5]"));

        switch(escolha){
            case "1":
                exibirAcoes();
                editarAcao();
                break;
            case "2":
                exibirCriptoativos();
                editarCriptoativo();
                break;
            case "3":
                exibirFii();
                editarFii();
                break;
            case "4":
                exibirStock();
                editarStock();
                break;
            case "5":
                exibirTesouro();
                editarTesouro();
                break;
        }
    }

    private void editarAcao(){
        System.out.println("\nDigite o ticker da Ação que deseja alterar: ");
        String ticker = leitura.nextLine();

        Acao a = buscarAcao(ticker);

        if(a == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nAção encontrada!");

        System.out.println("\nDigite o novo nome: ");
        a.setNome(leitura.nextLine());

        System.out.println("\nDigite o novo preço: ");
        a.setPrecoAtual(verificaDouble());

        a.setQualificado(verificaQualificado());

        carregar();
        esperar(700);
        System.out.println("\nAção atualizada com sucesso!");
    }

    private void editarCriptoativo(){
        System.out.println("\nDigite o ticker do Criptoativo que deseja alterar: ");
        String ticker = leitura.nextLine();

        Criptoativo c = buscarCriptoativo(ticker);

        if(c == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nCriptoativo encontrado!");

        System.out.println("\nDigite o novo nome: ");
        c.setNome(leitura.nextLine());

        System.out.println("\nDigite o novo preço: ");
        c.setPrecoAtual(verificaDouble());

        System.out.println("\nDigite o novo algoritmo de consenso: ");
        c.setAlgoritmo(leitura.nextLine());

        BigInteger novaQtdMax;

        while (true) {
            try {
                System.out.println("\nDigite a nova quantidade máxima: ");
                String valor = leitura.nextLine();
                novaQtdMax = new BigInteger(valor);
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nEntrada inválida! Digite um número inteiro válido.");
            }
        }
        c.setQtdMax(novaQtdMax);

        c.setQualificado(verificaQualificado());

        carregar();
        esperar(700);
        System.out.println("\nCriptoativo atualizado com sucesso!");
    }
    
    private void editarFii(){
        System.out.println("Digite o ticker do Fundo de Investimento Imobiliário que deseja alterar: ");
        String ticker = leitura.nextLine();
        Fii f = buscarFii(ticker);
        
        if(f == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nFundo de Investimento Imobiliário encontrado!");
        
        System.out.println("\nDigite o novo nome: ");
        f.setNome(leitura.nextLine());

        System.out.println("\nDigite o novo preço: ");
        f.setPrecoAtual(verificaDouble());

        System.out.println("\nDigite o novo segmento: ");
        f.setSegmento(leitura.nextLine());

        System.out.println("\nDigite o novo dividendo: ");
        f.setDividendo(verificaDouble());

        System.out.println("\nDigite a nova taxa de administração: ");
        f.setTaxaAdm(verificaDouble());

        f.setQualificado(verificaQualificado());

        carregar();
        esperar(700);
        System.out.println("\nFundo de Investimento Imobiliário atualizado com sucesso!");
    }
    
    private void editarStock(){
        System.out.println("\nDigite o ticker do Stock que deseja alterar: ");
        String ticker = leitura.nextLine();

        Stock s = buscarStock(ticker);

        if(s == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nStock encontrado!");

        System.out.println("\nDigite o novo nome: ");
        s.setNome(leitura.nextLine());

        System.out.println("\nDigite o novo preço: ");
        s.setPrecoAtual(verificaDouble());

        System.out.println("\nDigite a nova bolsa de negociação: ");
        s.setBolsa(leitura.nextLine());

        System.out.println("\nDigite o novo setor da empresa: ");
        s.setSetor(leitura.nextLine());

        s.setQualificado(verificaQualificado());

        carregar();
        esperar(700);
        System.out.println("\nStock atualizado com sucesso!");
    }
    
    private void editarTesouro(){
        System.out.println("\nDigite o ticker do Tesouro que deseja alterar: ");
        String ticker = leitura.nextLine();

        Tesouro t = buscarTesouro(ticker);

        if(t == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nTesouro encontrado!");

        System.out.println("\nDigite o novo nome: ");
        t.setNome(leitura.nextLine());
        
        System.out.println("\nDigite o novo preço: ");
        t.setPrecoAtual(verificaDouble());

        System.out.println("\nDigite o novo rendimento: ");
        t.setRendimento(leitura.nextLine());

        System.out.println("\nDigite o novo vencimento: ");
        t.setVencimento(leitura.nextLine());

        t.setQualificado(verificaQualificado());

        carregar();
        esperar(700);
        System.out.println("\nTesouro atualizado com sucesso!");
    }
    
    //excluir ativos
    private void excluirAtivo(){
        do{
            System.out.println("\nEscolha o ativo que deseja apagar:\n(1) Ação\n(2) Criptoativo\n(3) Fundo de Investimento Imobiliário\n(4) Stock\n(5) Tesouro");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-5]"));

        switch(escolha){
            case "1":
                excluirAcao();
                break;
            case "2":
                excluirCriptoativo();
                break;
            case "3":
                excluirFii();
                break;
            case "4":
                excluirStock();
                break;
            case "5":
                excluirTesouro();
                break;
        }
    }

    private void excluirAcao(){
        exibirAcoes();

        System.out.print("\nDigite o ticker da ação que deseja excluir: ");
        String ticker = leitura.nextLine();

        Acao a = buscarAcao(ticker);

        if(a == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nAção encontrada!");

        acoes.remove(a);
        excluir();
        esperar(700);
        System.out.println("\nAção excluída com sucesso!");
    }

    private void excluirCriptoativo(){
        exibirCriptoativos();

        System.out.print("\nDigite o ticker do Criptoativo que deseja excluir: ");
        String ticker = leitura.nextLine();

        Criptoativo c = buscarCriptoativo(ticker);

        if(c == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nCriptoativo encontrado!");

        criptoativos.remove(c);
        excluir();
        esperar(700);
        System.out.println("\nCriptoativo excluído com sucesso!");
    }
    
    private void excluirFii(){
        exibirFii();

        System.out.print("\nDigite o ticker do Fundo de Investimento Imobiliário que deseja excluir: ");
        String ticker = leitura.nextLine();

        Fii f = buscarFii(ticker);

        if(f == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nFundo de Investimento Imobiliário encontrado!");

        fiis.remove(f);
        excluir();
        esperar(700);
        System.out.println("\nFII excluído com sucesso!");
    }

    private void excluirStock(){
        exibirStock();

        System.out.print("\nDigite o ticker do Stock que deseja excluir: ");
        String ticker = leitura.nextLine();

        Stock s = buscarStock(ticker);

        if(s == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nStock encontrado!");

        stocks.remove(s);
        excluir();
        esperar(700);
        System.out.println("\nStock excluído com sucesso!");
    }

    private void excluirTesouro(){
        exibirTesouro();

        System.out.print("\nDigite o ticker do Tesouro que deseja excluir: ");
        String ticker = leitura.nextLine();

        Tesouro t = buscarTesouro(ticker);

        if(t == null){
            System.out.println("\nTicker não encontrado.");
            return;
        }

        carregar();
        esperar(700);
        System.out.println("\nTesouro encontrado!");

        tesouros.remove(t);
        excluir();
        esperar(700);
        System.out.println("\nTesouro excluído com sucesso!");
    }
    
    //exibir relatórios
    private void exibirRelatorioAtivo(){
        do{
            System.out.println("\nEscolha o ativo que deseja exibir o relatório:\n(1) Todos os Ativos \n(2) Ação\n(3) Criptoativo\n(4) Fundo de Investimento Imobiliário\n(5) Stock\n(6) Tesouro");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-6]"));

        switch(escolha){
            case "1":
                exibirTodos();
                break;
            case "2":
                exibirAcoes();
                break;
            case "3":
                exibirCriptoativos();
                break;
            case "4":
                exibirFii();
                break;
            case "5":
                exibirStock();
                break;
            case "6":
                exibirTesouro();
                break;
        }
    }

    private void exibirTodos(){
        exibirAcoes();
        exibirCriptoativos();
        exibirFii();
        exibirStock();
        exibirTesouro();
    }

    private void exibirAcoes(){
        System.out.println("\n*-----* AÇÕES *-----*");
        for(Acao a : acoes){
            System.out.println(a);
        }
    }

    private void exibirCriptoativos(){
        System.out.println("\n*-----* CRIPTOATIVOS *-----*");
        for(Criptoativo c : criptoativos){
            System.out.println(c);
        }
    }

    private void exibirFii(){
        System.out.println("\n*-----* FUNDO DE INVESTIMENTO IMOBILIÁRIO *-----*");
        for(Fii f : fiis){
            System.out.println(f);
        }
    }

    private void exibirStock(){
        System.out.println("\n*-----* STOCKS *-----*");
        for(Stock s : stocks){
            System.out.println(s);
        }
    }

    private void exibirTesouro(){
        System.out.println("\n*-----* TESOUROS *-----*");
        for(Tesouro t : tesouros){
            System.out.println(t);
        }
    }

    //buscar ativos
    private Acao buscarAcao(String ticker){
        for(Acao a : acoes){
            if(a.getTicker().equalsIgnoreCase(ticker)){
                return a;
            }
        }
        return null;
    }

    private Criptoativo buscarCriptoativo(String ticker){
        for(Criptoativo c : criptoativos){
            if(c.getTicker().equalsIgnoreCase(ticker)){
                return c;
            }
        }
        return null;
    }

    private Fii buscarFii(String ticker){
        for(Fii f : fiis){
            if(f.getTicker().equalsIgnoreCase(ticker)){
                return f;
            }
        }
        return null;
    }

    private Stock buscarStock(String ticker){
        for(Stock s : stocks){
            if(s.getTicker().equalsIgnoreCase(ticker)){
                return s;
            }
        }
        return null;
    }

    private Tesouro buscarTesouro(String ticker){
        for(Tesouro t : tesouros){
            if(t.getTicker().equalsIgnoreCase(ticker)){
                return t;
            }
        }
        return null;
    }

    public Ativos buscarAtivos(String ticker){
        Ativos ativo;

        ativo = buscarAcao(ticker);
        if(ativo != null){
            return ativo;
        }
        ativo = buscarCriptoativo(ticker);
        if(ativo != null){
            return ativo;
        }

        ativo = buscarFii(ticker);
        if(ativo != null){
            return ativo;
        }

        ativo = buscarStock(ticker);
        if(ativo != null){
            return ativo;
        }

        ativo = buscarTesouro(ticker);
        if(ativo != null){
            return ativo;
        }
        return null;
    }

    //funções de auxílio
    private double verificaDouble(){
        while(true){
            try{
                double valor = leitura.nextDouble();
                leitura.nextLine();
                return valor;
            } catch(InputMismatchException e){
                System.out.println("\nEntrada inválida! Digite novamente:");
                leitura.nextLine();
            }
        }
    }
    
    private boolean verificaQualificado(){
        while(true){
            try{
                System.out.println("\nDigite (true) para qualificado e (false) para não qualificado: ");
                boolean qualificado = leitura.nextBoolean();
                leitura.nextLine();
                return qualificado;
            } catch(InputMismatchException e){
                System.out.println("\nEntrada inválida! Digite (true) para qualificado e (false) para não qualificado.");
                leitura.nextLine();
            }
        }
    }

    private double verificaPreco() {
        while (true) {
            try {
                double preco = verificaDouble();
                if (preco <= 0) {
                    throw new InvalidPriceException();
                }
                return preco;
            } catch (InvalidPriceException e) {
                System.out.println("\nPreço inválido! O preço deve ser maior que zero. Digite novamente:\n");
            }
        }
    }

    private void esperar(long ms){
        try{
            Thread.sleep(ms);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void carregar(){
        System.out.print("\nCarregando");
        for(int i = 0; i < 3; i++){
            esperar(700);
            System.out.print(".");
        }
        System.out.println("");
    }

    private void excluir(){
        System.out.print("\nApagando do sistema");
        for(int i = 0; i < 3; i++){
            esperar(700);
            System.out.print(".");
        }
        System.out.println("");
    }

}
