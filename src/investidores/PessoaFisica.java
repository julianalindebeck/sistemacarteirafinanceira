package investidores;

public class PessoaFisica extends Investidor {
    private String perfil;

    public PessoaFisica(String nome, String id, String telefone, String nascimento, String endereco, double patrimonio, String perfil){
        super(nome, id, telefone, nascimento, endereco, patrimonio);
        this.perfil = perfil;
    }

    public void setPerfil(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil(){
        return this.perfil;
    }

    @Override
    public String toString() {
        return "Pessoa Física | " +
                "Nome: " + nome  +
                ", CPF: " + id +
                ", Perfil: " + perfil +
                '.';
    }

}
