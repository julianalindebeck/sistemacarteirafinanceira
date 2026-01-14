package investidores;

public abstract class Investidor {
    protected String nome;
    protected String id;
    protected int telefone; //int?
    protected String nascimento;
    protected String endereco;
    protected double patrimonio;
    protected Carteira carteira;

    public Investidor(String nome, String id, int telefone, String nascimento, String endereco, double patrimonio){
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.patrimonio = patrimonio;
    }
}
