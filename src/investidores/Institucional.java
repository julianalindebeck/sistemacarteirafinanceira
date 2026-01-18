package investidores;

public class Institucional extends Investidor {
    private String razao;

    public Institucional(String nome, String id, int telefone, String nascimento, String endereco, double patrimonio){
        super(nome, id, telefone, nascimento, endereco, patrimonio);
    }

    public void setRazao(String razao){
        this.razao = razao;
    }

    public String getRazao(){
        return this.razao;
    }
    
}
