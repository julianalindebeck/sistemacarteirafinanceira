package excecoes;

public class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException() {
        super("Preço inválido! Valor não pode ser negativo, nulo ou zero!");
    }
}
