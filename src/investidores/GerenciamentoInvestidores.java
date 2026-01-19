package investidores;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import excecoes.InvalidHeritageException;
import leituraDeArquivos.Leitor;

public class GerenciamentoInvestidores {
    private Scanner leitura;
    private String escolha;

    private List<PessoaFisica> pessoaFisica;
    private List<Institucional> institucional;
    private List<String> ids = new ArrayList<>();

    public GerenciamentoInvestidores(
        Scanner leitura,
        List<PessoaFisica> pessoaFisica,
        List<Institucional> institucional
    ){
        this.leitura = leitura;
        this.pessoaFisica = pessoaFisica;
        this.institucional = institucional;
    }

    public void menuInvestidor(){
        do{
            System.out.println("\n*------------* MENU INVESTIDOR *------------*");
            System.out.println("(1) Cadastrar Investidor\n(2) Cadastrar Investidor em lote\n(3) Exibir todos Investidores\n(4) Excluir Investidores\n(5) Editar Investidor\n(6) Voltar ao menu inicial");

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
        for(PessoaFisica p : pessoaFisica){
            System.out.println(p);
        }
    }

    private void exibirInstitucional(){
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
                double valor = verificaDouble();
                if (valor < 0) {
                    throw new InvalidHeritageException();
                }
                return valor;
            } catch (InvalidHeritageException e) {
                System.out.println(e.getMessage());
                System.out.println("\nDigite o patrimônio novamente:");
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
