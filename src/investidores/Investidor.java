package investidores;

import excecoes.InvalidHeritageException;

public abstract class Investidor {
    protected String nome;
    protected String id;
    protected String telefone;
    protected String nascimento;
    protected String endereco;
    protected double patrimonio;
    protected Carteira carteira;
    protected boolean qualificado;

    public Investidor(String nome, String id, String telefone, String nascimento, String endereco, double patrimonio){
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.patrimonio = patrimonio;
        if(patrimonio>=1000000){
            this.qualificado=true;
        }
        else{
            this.qualificado=false;
        }
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

}
