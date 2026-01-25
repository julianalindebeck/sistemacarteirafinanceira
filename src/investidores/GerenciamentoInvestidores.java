package investidores;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ativos.Ativos;
import ativos.Criptoativo;
import ativos.GerenciamentoAtivos;
import ativos.Stock;
import excecoes.InvalidHeritageException;
import leituraDeArquivos.Leitor;
import relatorio.Relatorio;

public class GerenciamentoInvestidores {
    private Scanner leitura;
    private String escolha;

    private List<PessoaFisica> pessoaFisica;
    private List<Institucional> institucional;
    private GerenciamentoAtivos gerenciamentoAtivos;

    public GerenciamentoInvestidores(
        Scanner leitura,
        List<PessoaFisica> pessoaFisica,
        List<Institucional> institucional, 
        GerenciamentoAtivos gerenciamentoAtivos
    ){
        this.leitura = leitura;
        this.pessoaFisica = pessoaFisica;
        this.institucional = institucional;
        this.gerenciamentoAtivos = gerenciamentoAtivos;
    }

    public void menuInvestidor(){
        do{
            System.out.println("\n*------------* MENU INVESTIDOR *------------*");
            System.out.println("(1) Cadastrar Investidor\n(2) Cadastrar Investidor em lote\n(3) Exibir todos Investidores\n(4) Excluir Investidores\n(5) Selecionar Investidor\n(6) Voltar ao menu principal");

            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-6]"));
        
        switch(escolha){
            case "1":
                cadastrarInvestidor();
                break;
            case "2":
                cadastrarInvestidorLote();
                break;
            case "3":
                exibirInvestidores();
                break;
            case "4":
                excluirInvestidorPorLista();
                break;
            case "5": {
                Investidor inv = selecionarInvestidor();

                if(inv != null){
                    menuInvestidorSelecionado(inv);
                }
                break;
            }
            case "6":
                return;
        }
    }

    public void menuInvestidorSelecionado(Investidor inv){
        do{
            System.out.println("\n*------------* INVESTIDOR SELECIONADO *------------*");
            System.out.println("(1) Editar Investidor \n(2) Excluir investidor\n(3) Exibir ativos e outras opções\n(4) Realizar movimentações\n(5) Voltar ao menu inicial");

            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-5]"));

        switch(escolha){
            case "1":
                if(inv instanceof PessoaFisica){
                    editarPessoaFisica((PessoaFisica) inv);
                } else{
                    editarInstitucional((Institucional) inv);
                }
                break;

            case "2":
                excluirInvestidorSelecionado(inv);
                break;
            case "3":
                opcoesAtivos(inv);
                break;
            case "4":
                realizarMovimentacao(inv);
                break;
            case "5":
                return;
        }
    }
    
    //cadastrar investidores
    private void cadastrarInvestidor(){
        System.out.println("\n*------------* CADASTRAR INVESTIDOR *------------*");
        System.out.println("(1) Pessoa Física\n(2) Pessoa Jurídica\n(3) Voltar ao menu inicial");
        
        escolha = leitura.nextLine();
        while(!escolha.matches("[1-3]")){
            System.out.println("\nOpção inválida! Escolha (1) para Pessoa Física, (2) para Pessoa Jurídica ou (3) para voltar ao menu inicial.");
            escolha = leitura.nextLine();
        }

        if(!escolha.equals("3")){
            cadastroInvestidor();
        }
        else{
            return;
        }
    }

    private void cadastrarInvestidorLote(){
        System.out.println("\n*------------* CADASTRAR INVESTIDOR EM LOTE *------------*");
        System.out.println("(1) Pessoa Física\n(2) Pessoa Jurídica\n(3) Voltar ao menu inicial");
        
        escolha = leitura.nextLine();
        while(!escolha.matches("[1-3]")){
            System.out.println("\nOpção inválida! Escolha (1) para Pessoa Física, (2) para Pessoa Jurídica ou (3) para voltar ao menu inicial.");
            escolha = leitura.nextLine();
        }

        System.out.println("\nInforme o caminho do arquivo: ");
        String caminho = leitura.nextLine();

        switch(escolha){
            case "1":
                List<PessoaFisica> pessoaFisicaLote = Leitor.listaPessoaFisica(caminho);
                pessoaFisica.addAll(pessoaFisicaLote);
                break;
            case "2":
                List<Institucional> institucionalLote = Leitor.listaInstitucional(caminho);
                institucional.addAll(institucionalLote);
                break;
            case "3":
                return;
        }
        carregar();
        esperar(700);
        System.out.println("\nInvestidor cadastrado com sucesso!");
    }

    private void cadastroInvestidor(){
        System.out.println("\nDigite o nome: ");
        String nome = leitura.nextLine();

        System.out.println("\nDigite o telefone: ");
        String telefone = leitura.nextLine();

        System.out.println("\nDigite a data de nascimento (dd/mm/aa): ");
        String nascimento = leitura.nextLine();

        System.out.println("\nDigite o endereço: ");
        String endereco = leitura.nextLine();

        System.out.println("\nDigite o patrimônio: ");
        double patrimonio = lerPatrimonio();

        String id;

        if(escolha.equals("1")){
            System.out.println("\nDigite o CPF: ");
            id = leitura.nextLine();

            String perfil = selecionarPerfil();

            pessoaFisica.add(new PessoaFisica(nome, id, telefone, nascimento, endereco, patrimonio, perfil));
        }
        else{
            System.out.println("\nDigite o CNPJ: ");
            id = leitura.nextLine();

            System.out.println("\nDigite a razão social: ");
            String razao = leitura.nextLine();

            institucional.add(new Institucional(nome, id, telefone, nascimento, endereco, patrimonio, razao));
        }

        carregar();
        esperar(500);
        System.out.println("\nInvestidor cadastrado com sucesso!");
    }

    private String selecionarPerfil(){
        do{
            System.out.println("\nSelecione seu perfil: ");
            System.out.println("(1) Arrojado\n(2) Moderado\n(3) Conservador\n(4) Fazer um quiz");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-4]"));

        String p = "";
        switch (escolha) {
            case "1":
                p = "Arrojado";
                break;
            case "2":
                p = "Moderado";
                break;
            case "3":
                p = "Conservador";
                break;
            case "4":
                p = quizPerfil();
                break;
        }
        return p;
    }

    private String quizPerfil(){
        carregar();
        esperar(1100);
        System.out.println("\nDeseja descobrir o seu perfil?");
        esperar(1100);
        System.out.println("\nVocê está no lugar certo!");
        esperar(1100);
        System.out.println("\nResponda essas 3 simples perguntas e diremos o perfil que melhor se encaixa com você!");
        esperar(1100);
        System.out.println("\nVamos lá!");
        esperar(1100);

        int m = 0, a = 0, c = 0;

        do{
            System.out.println("\n(1) Nas férias, prefere (a) ir para a praia, (b) escalar uma montanha ou (c) ficar em casa com a família?");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[a, b, c]"));

        if(escolha.equals("a")) m++;
        else if(escolha.equals("b")) a++;
        else c++;

        do{
            System.out.println("\n(2) Você vai em um restaurante 5 estrelas, prefere (a) pedir o de sempre, (b) experimentar um prato novo ou (c) pedir o prato mais exótico?");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[a, b, c]"));

        if(escolha.equals("a")) c++;
        else if(escolha.equals("b")) m++;
        else a++;

        do{
            System.out.println("\n(3) A caminho do trabalho, você escuta: (a) Chitãozinho e Xororó, (b) Guerreiras do K-Pop ou (c) Gusttavo Lima?");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[a, b, c]"));

        if(escolha.equals("a")) m++;
        else if(escolha.equals("b")) a++;
        else c++;

        carregar();
        esperar(700);
        if(a > m && a > c){
            System.out.println("\nSeu perfil é: Arrojado! Você gosta de aventuras, se divertir e não tem medo de arriscar um pouquinho!");
            return "Arrojado";
        }
        else if(c > a && c > m){
            System.out.println("\nSeu perfil é: Conservador! Você prefere ficar no seguro e garantido, afinal dinheiro não nasce em árvore!");
            return "Conservador";
        }
        else{
            System.out.println("\nSeu perfil é: Moderado! Você entende que tudo precisa de equilíbrio, um pouco de aventura e um pouco de segurança deixam tudo perfeito!");
            return "Moderado";
        }

    }

    //exibir investidores
    private void exibirInvestidores(){
        exibirPessoaFisica();
        exibirInstitucional();
    }

    private void exibirPessoaFisica(){
        System.out.println("\n*-----* PESSOAS FÍSICAS *-----*");

        if(pessoaFisica.isEmpty()){
            System.out.println("Nenhum Investidor do tipo (Pessoa Física) cadastrado.");
            return;
        }

        for(PessoaFisica p : pessoaFisica){
            System.out.println(p);
        }
    }

    private void exibirInstitucional(){
        System.out.println("\n*-----* INSTITUIÇÕES *-----*");

        if(institucional.isEmpty()){
            System.out.println("Nenhum Investidor do tipo (Institucional) cadastrado.");
            return;
        }

        for(Institucional i : institucional){
            System.out.println(i);
        }
    }

    //excluir investidores
    private void excluirInvestidorSelecionado(Investidor inv){
        inv.getCarteira().excluirCarteira();

        if(inv instanceof PessoaFisica){
            pessoaFisica.remove(inv);
        }
        else if(inv instanceof Institucional){
            institucional.remove(inv);
        }

        excluir();
        esperar(700);
        System.out.println("\nInvestidor excluído com sucesso!");
    }

    private void excluirInvestidorPorLista(){
        System.out.println("\nDigite os CPFs/CNPJs separados por vírgula:");
        String escolha = leitura.nextLine();

        if(escolha == null || escolha.isBlank()){
            System.out.println("\nNenhum ID informado.");
            return;
        }

        String[] listaIds = escolha.split(",");

        for(String id : listaIds){
            Investidor inv = buscarInvestidor(id);
            if(inv != null){
                excluirInvestidorSelecionado(inv);
                excluir();
                esperar(700);
                System.out.println("\nInvestidor com ID " + id + " excluído com sucesso.");
            } else {
                System.out.println("\nInvestidor com ID " + id + " não encontrado.");
            }
        }
    }

    private Investidor buscarInvestidor(String id){
        for(PessoaFisica p : pessoaFisica){
            if(p.getId().equals(id)){
                return p;
            }
        }
        for(Institucional i : institucional){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    //editar investidores
    private void editarDadosComuns(Investidor inv){
        carregar();
        esperar(700);
        
        System.out.println("\nDigite o novo nome: ");
        inv.setNome(leitura.nextLine());

        System.out.println("\nDigite o novo telefone: ");
        inv.setTelefone(leitura.nextLine());

        System.out.println("\nDigite a nova data de nascimento: ");
        inv.setNascimento(leitura.nextLine());

        System.out.println("\nDigite o novo endereço: ");
        inv.setEndereco(leitura.nextLine());

        System.out.println("\nDigite o novo patrimônio: ");
        inv.setPatrimonio(verificaDouble());
    }

    private void editarPessoaFisica(PessoaFisica p){
        editarDadosComuns(p);
        System.out.println("\nDigite o novo perfil: ");
        p.setPerfil(selecionarPerfil());

        carregar();
        esperar(700);
        System.out.println("\nPessoa Física atualizada com sucesso!");
    }

    private void editarInstitucional(Institucional i){
        editarDadosComuns(i);
        System.out.println("\nDigite a nova razão social: ");
        i.setRazao(leitura.nextLine());

        carregar();
        esperar(700);
        System.out.println("\nInstitucional atualizado com sucesso!");
    }

    //ativos
    private void opcoesAtivos(Investidor inv){
        do{
            System.out.println("\n*------------* ATIVOS *------------*");
            System.out.println("(1) Exibir Ativos\n(2) Exibir valor total gasto\n(3) Exibir valor total atual\n(4) Exibir porcentagem de produtos de renda fixa e variável\n(5) Exibir porcentagem de produtos internacionais e nacionais\n(6) Salvar relatório\n(7) Voltar ao menu inicial");

            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-7]"));

        switch(escolha){
            case "1":
                exibirAtivos(inv);
                break;
            case "2":
                exibirValorTotalGasto(inv);
                break;
            case "3":
                exibirValorTotalAtual(inv);
                break;
            case "4":
                exibirPorcentagemRenda(inv);
                break;
            case "5":
                exibirPorcentagemIntNac(inv);
                break;
            case "6":
                salvarRelatorio(inv);
                break;
            case "7":
                return;
        }
    }

    private void exibirAtivos(Investidor inv){
        inv.getCarteira().imprimirCarteira();
    }

    private void exibirValorTotalAtual(Investidor inv){
        double total = inv.getCarteira().getValorTotal();
        System.out.println("\nValor total atual da carteira: R$ " + total);
    }

    private void exibirValorTotalGasto(Investidor inv){
        double totalGasto = 0;

        for(Movimentacao m : inv.getHistorico()){
            if(m.verificaCompra()){
                totalGasto += m.getQtd() * m.getPreco();
            }
        }

        System.out.println("\nValor total gasto em compras: R$ " + totalGasto);
    }

    private void exibirPorcentagemRenda(Investidor inv){
        double rendaVar = inv.getCarteira().getPorcentagemRendaVar();
        double rendaFixa = inv.getCarteira().getPorcentagemRendaFixa();

        System.out.println("\nPorcentagem renda variável: " + rendaVar + "%");
        System.out.println("Porcentagem renda fixa: " + rendaFixa + "%");
    }

    private void exibirPorcentagemIntNac(Investidor inv){
        double inter = inv.getCarteira().getPorcentagemInter();
        double nac = inv.getCarteira().getPorcentagemNacional();

        System.out.println("\nPorcentagem ativos internacionais: " + inter + "%");
        System.out.println("Porcentagem ativos nacionais: " + nac + "%");
    }

    private void salvarRelatorio(Investidor inv){
        double valorTotalAtual = inv.getCarteira().getValorTotal();

        double valorTotalGasto = 0;
        for(Movimentacao m : inv.getHistorico()){
            if(m.verificaCompra()){
                valorTotalGasto += m.getQtd() * m.getPreco();
            }
        }

        Relatorio relatorio = new Relatorio(
            inv.getNome(),
            inv.getId(),
            inv.getCarteira().getAtivos(),
            valorTotalAtual,
            valorTotalGasto,
            inv.getCarteira().getPorcentagemRendaFixa(),
            inv.getCarteira().getPorcentagemRendaVar(),
            inv.getCarteira().getPorcentagemNacional(),
            inv.getCarteira().getPorcentagemInter()
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String arquivo = "relatorio_" + inv.getNome() + ".json";

        try(FileWriter writer = new FileWriter(arquivo)){
            gson.toJson(relatorio, writer);

            salvar();
            esperar(700);
            System.out.println("\nRelatório salvo com sucesso!");
            System.out.println("Arquivo do relatório: " + arquivo);
        } catch(IOException e){
            System.out.println("\nErro ao salvar o relatório: " + e.getMessage());
        }
    }

    //realizar movimentação
    private void realizarMovimentacao(Investidor investidor){
        if(investidor == null){
            return;
        }

        System.out.println("\nEscolha o que deseja:\n(1) Comprar ativo\n(2) Vender ativo");
        escolha = leitura.nextLine();

        System.out.println("\nTicker do ativo:");
        String ticker = leitura.nextLine();

        System.out.println("\nQuantidade:");
        double quantidade = verificaQuantidade();

        System.out.println("\nDigite a data (dd/mm/aa) da movimentação: ");
        String data = leitura.nextLine();

        try{
            if(escolha.equals("1")){
                Ativos ativo = gerenciamentoAtivos.buscarAtivos(ticker);

                if(ativo == null){
                    System.out.println("\nAtivo não encontrado.");
                    return;
                }

                if(investidor instanceof PessoaFisica){
                    boolean verifica = verificaMovimentacao(investidor, ativo);
                    if(!verifica){
                        return;
                    }
                }

                Ativos ativoCompra = ativo.clonar();

                investidor.comprarAtivo(ativoCompra, quantidade);

                Movimentacao mov = new Movimentacao(ativo.getTicker() + "C", "C", ativo.getNome(), ticker, quantidade, data, ativo.getPrecoAtual());

                investidor.registrarMovimentacao(mov);

                carregar();
                esperar(700);
                System.out.println("\nCompra realizada com sucesso!");
            }
            else{
                investidor.venderAtivo(ticker, quantidade);

                Movimentacao mov = new Movimentacao(investidor.getId() + "V", "V", "Venda", ticker, quantidade, data, 0);

                investidor.registrarMovimentacao(mov);

                carregar();
                esperar(700);
                System.out.println("\nVenda realizada com sucesso!");
            }

            investidor.getCarteira().imprimirCarteira();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private boolean verificaMovimentacao(Investidor investidor, Ativos ativo){
        PessoaFisica pf = (PessoaFisica) investidor;
        String perfil = pf.getPerfil();

        if(ativo instanceof Criptoativo){
            if(perfil.equalsIgnoreCase("Conservador")){
                System.out.println("\nInvestidores conservadores não podem investir em criptoativos.");
                return false;
            }
            if(perfil.equalsIgnoreCase("Moderado")){
                System.out.println("\nInvestidores moderados não podem investir em criptoativos.");
                return false;
            }
        }

        if(ativo instanceof Stock){
            if(perfil.equalsIgnoreCase("Conservador")){
                System.out.println("\nInvestidores conservadores não podem investir em stocks.");
                return false;
            }
        }

        if(ativo.getQualificado() && pf.getPatrimonio() < 1000000){
            System.out.println("\nApenas investidores qualificados podem movimentar este ativo.");
            return false;
        }

        return true;
    }

    //selecionar investidores
    private Investidor selecionarInvestidor(){        
        do{
            System.out.println("\n*------------* SELECIONAR INVESTIDOR *------------*");
            System.out.println("(1) Pessoa Física \n(2) Institucional");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-2]"));

        if(escolha.equals("1")){
            exibirPessoaFisica();
            System.out.println("\nDigite o CPF do Investidor: ");
            escolha = leitura.nextLine();
            return selecionarCPF();
        }
        else{
            exibirInstitucional();
            System.out.println("\nDigite o CNPJ do Investidor: ");
            escolha = leitura.nextLine();
            return selecionarCNPJ();
        }
    }

    private PessoaFisica selecionarCPF(){
        for(PessoaFisica p : pessoaFisica){
            if(escolha.equals(p.getId())){
                return p;
            }
        }

        System.out.println("\nCPF não encontrado!");
        return null;
    }

    private Institucional selecionarCNPJ(){
        for(Institucional i : institucional){
            if(escolha.equals(i.getId())){
                return i;
            }
        }

        System.out.println("\nCNPJ não encontrado!");
        return null;
    }

    //funções de auxílio
    private double lerPatrimonio(){
        while(true){
            try{
                double patrimonio = verificaDouble();

                if(patrimonio < 0){
                    throw new InvalidHeritageException();
                }

                return patrimonio;
            } catch(InvalidHeritageException e){
                System.out.println(e.getMessage() + "\n\nDigite o patrimônio novamente:");
            }
        }
    }

    private double verificaQuantidade(){
        while(true){
            try{
                double quantidade = verificaDouble();

                if(quantidade <= 0){
                    throw new IllegalArgumentException("\nQuantidade inválida! Deve ser maior que zero.\n");
                }

                return quantidade;
            } catch(IllegalArgumentException e){
                System.out.println("\nQuantidade inválida! Digite novamente:");
            }
        }
    }

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

    private void salvar(){
        System.out.print("\nSalvando");
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
