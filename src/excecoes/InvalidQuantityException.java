package excecoes;

public class InvalidQuantityException extends IllegalArgumentException{
    public InvalidQuantityException(){
        super("\nQuantidade inválida. A quantidade deve ser maior que zero.");
    }
}
