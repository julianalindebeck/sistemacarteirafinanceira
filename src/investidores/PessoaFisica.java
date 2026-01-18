package investidores;

public class PessoaFisica extends Investidor {
    private String perfil;

    public PessoaFisica(String nome, String id, int telefone, String nascimento, String endereco, double patrimonio){
        super(nome, id, telefone, nascimento, endereco, patrimonio);
    }

    public void setPerfil(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil(){
        return this.perfil;
    }

}
