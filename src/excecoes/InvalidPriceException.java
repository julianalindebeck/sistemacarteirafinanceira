package excecoes;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException() {
        super("\nPreço inválido! Valor não pode ser negativo, nulo ou zero!");
    }
}
