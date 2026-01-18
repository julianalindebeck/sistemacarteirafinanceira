package investidores;

public class Institucional extends Investidor {
    private String razao;

    public Institucional(String nome, String id, String telefone, String nascimento, String endereco, double patrimonio, String razao){
        super(nome, id, telefone, nascimento, endereco, patrimonio);
        this.razao = razao;
    }

    public void setRazao(String razao){
        this.razao = razao;
    }

    public String getRazao(){
        return this.razao;
    }

    @Override
    public String toString() {
        return "Instituicional | " +
                "Nome: " + nome  +
                ", CNPJ: " + id +
                ", Razão Social: " + razao +
                '.';
    }
    
}
