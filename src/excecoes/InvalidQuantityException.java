package excecoes;

public class InvalidQuantityException extends IllegalArgumentException{
    public InvalidQuantityException(){
        super("Quantidade inválida. A quantidade deve ser maior que zero.");
    }
}
