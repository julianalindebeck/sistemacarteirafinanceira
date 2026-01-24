package investidores;

import java.util.ArrayList;
import java.util.List;

import ativos.Ativos;
import excecoes.InvalidHeritageException;

public abstract class Investidor {
    protected String nome;
    protected String id;
    protected String telefone;
    protected String nascimento;
    protected String endereco;
    protected double patrimonio;
    protected Carteira carteira;
    protected List<Movimentacao> historico;

    public Investidor(String nome, String id, String telefone, String nascimento, String endereco, double patrimonio){
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.endereco = endereco;
        setPatrimonio(patrimonio);

        this.carteira = new Carteira();
        this.historico = new ArrayList<>();
    }

    public void registrarMovimentacao(Movimentacao mov){
        historico.add(mov);
    }

    public void comprarAtivo(Ativos ativo, double quantidade){
        ativo.setQtd(quantidade);

        double custo = ativo.getPrecoAtual() * quantidade;

        if(custo > patrimonio){
            throw new IllegalArgumentException("\nPatrimônio insuficiente para compra.");
        }

        carteira.adicionarAtivo(ativo);

        patrimonio -= custo;
    }

    public void venderAtivo(String ticker, double quantidade){
        double preco = 0;

        for(Ativos a : carteira.getAtivos()){
            if(a.getTicker().equalsIgnoreCase(ticker)){
                preco = a.getPrecoAtual();
                break;
            }
        }

        if(preco == 0){
            throw new IllegalArgumentException("Ativo não encontrado na carteira.");
        }
        
        carteira.removerAtivo(ticker, quantidade);

        patrimonio += preco * quantidade;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setTelefone(String tel){
        this.telefone = tel;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }

    public String getNascimento(){
        return this.nascimento;
    }

    public void setEndereco(String end){
        this.endereco = end;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setPatrimonio(double patrimonio){
        if(patrimonio < 0){
            throw new InvalidHeritageException();
        }
        this.patrimonio = patrimonio;
    }

    public double getPatrimonio(){
        return this.patrimonio;
    }

    public List<Movimentacao> getHistorico(){
        return historico;
    }
}
