package investidores;

public class Institucional extends Investidor {
    private String razao;

    public Institucional(String nome, String id, int telefone, String nascimento, String endereco, double patrimonio){
        super(nome, id, telefone, nascimento, endereco, patrimonio);
    }
}
