package excecoes;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException() {
        super("Preço inválido! Valor não pode ser negativo, nulo ou zero!");
    }
}
