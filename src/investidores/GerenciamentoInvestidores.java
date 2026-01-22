package investidores;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ativos.Ativos;
import ativos.GerenciamentoAtivos;
import excecoes.InvalidHeritageException;
import leituraDeArquivos.Leitor;

public class GerenciamentoInvestidores {
    private Scanner leitura;
    private String escolha;

    private List<PessoaFisica> pessoaFisica;
    private List<Institucional> institucional;
    private List<String> ids = new ArrayList<>();
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
            System.out.println("(1) Cadastrar Investidor\n(2) Cadastrar Investidor em lote\n(3) Exibir todos Investidores\n(4) Excluir Investidores\n(5) Editar Investidor\n(6) Visualizar Ativos e outras opções\n(7) Realizar movimentação\n(8) Voltar ao menu inicial");

            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-8]"));
        
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
                excluirInvestidor();
                break;
            case "5": {
                Investidor inv = selecionarInvestidor();

                if(inv == null){
                    return;
                }

                if(inv instanceof PessoaFisica){
                    editarPessoaFisica((PessoaFisica) inv);
                }
                else if(inv instanceof Institucional){
                    editarInstitucional((Institucional) inv);
                }
                break;
            }
            case "6":
                opçoesAtivos();
                break;
            case "7":
                realizarMovimentacao();
                break;
            case "8":
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
    }

    private void cadastroInvestidor(){
        System.out.println("\nDigite o nome: ");
        String nome = leitura.nextLine();

        System.out.println("\nDigite o telefone: ");
        String telefone = leitura.nextLine();

        System.out.println("\nDigite a data de nascimento: ");
        String nascimento = leitura.nextLine();

        System.out.println("\nDigite o endereço: ");
        String endereco = leitura.nextLine();

        System.out.println("\nDigite o patrimônio: ");
        double patrimonio = lerPatrimonio();

        String id;

        if(escolha.equals("1")){
            System.out.println("\nDigite o CPF: ");
            id = leitura.nextLine();

            System.out.println("\nDigite o perfil: ");
            String perfil = leitura.nextLine();
            //apenas perfis existentes

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
    private void excluirInvestidor(){
        atualizaIDs();
        //completar
    }

    private void atualizaIDs(){
        ids.clear();

        for(PessoaFisica p : pessoaFisica){
            ids.add(p.getId());
        }

        for(Institucional i : institucional){
            ids.add(i.getId());
        }
    }

    //editar investidores
    private void editarDadosComuns(Investidor inv){
        carregar();
        esperar(700);
        System.out.println("\nInvestidor encontrado!");

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
        p.setPerfil(leitura.nextLine());

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
    private void opçoesAtivos(){
        do{
            System.out.println("\n*------------* ATIVOS *------------*");
            System.out.println("(1) Exibir Ativos\n(2) Exibir valor total gasto\n(3) Exibir valor total atual\n(4) Exibir porcentagem de produtos de renda fixa e variável\n(5) Exibir porcentagem de produtos internacionais e nacionais\n(6) Salvar relatório\n(7) Voltar ao menu inicial");

            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-7]"));

        switch(escolha){
            case "1":
                //exibirAtivos();
                break;
            case "2":
                //exibirValorTotalGasto();
                break;
            case "3":
                //exibirValorTotalAtual();
                break;
            case "4":
                //exibirPorcentagemRenda();
                break;
            case "5":
                //exibirPorcentagemIntNac();
                break;
            case "6":
                //salvarRelatorio();
                break;
            case "7":
                return;
        }
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

    //realizar movimentação
    private void realizarMovimentacao(){
        Investidor investidor = selecionarInvestidor();
        if (investidor == null){
            return;
        }

        do{
            System.out.println("\n(1) Comprar ativo\n(2) Vender ativo\n(3) Voltar para o menu inicial");
            escolha = leitura.nextLine();
        } while(!escolha.matches("[1-3]"));

        if(escolha.equals("3")){
            return;
        }

        System.out.println("\nDigite o ticker do ativo:");
        String ticker = leitura.nextLine();

        System.out.println("\nDigite a quantidade:");
        double quantidade = verificaQuantidade();

        try{
            if(escolha.equals("1")){
                Ativos ativo = gerenciamentoAtivos.buscarAtivos(ticker);
                if(ativo == null){
                    System.out.println("\nAtivo não encontrado.");
                    return;
                }

                Ativos ativoCompra = ativo.clonar();

                investidor.comprarAtivo(ativoCompra, quantidade);
                System.out.println("\nCompra realizada com sucesso!");
                investidor.getCarteira().imprimirCarteira();
            } 
            else{
                investidor.venderAtivo(ticker, quantidade);
                System.out.println("\nVenda realizada com sucesso!");
                investidor.getCarteira().imprimirCarteira();
            }
        } catch(Exception e){
            System.out.println("\nErro: " + e.getMessage());
        }
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

    private double lerPatrimonio(){
        while (true) {
            try {
                double patrimonio = verificaDouble();

                if (patrimonio < 0) {
                    throw new InvalidHeritageException();
                }

                return patrimonio;
            } catch (InvalidHeritageException e) {
                System.out.println("\nPatrimônio inválido! O patrimônio não pode ser negativo. Digite novamente:\n");
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
            }catch(IllegalArgumentException e){
                System.out.println("\nQuantidade inválida! Digite novamente:\n");
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

    /*private void excluir(){
        System.out.print("\nApagando do sistema");
        for(int i = 0; i < 3; i++){
            esperar(700);
            System.out.print(".");
        }
        System.out.println("");
    }*/

}
