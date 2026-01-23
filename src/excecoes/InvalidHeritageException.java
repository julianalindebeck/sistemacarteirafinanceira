package excecoes;

public class InvalidHeritageException extends IllegalArgumentException {
    public InvalidHeritageException() {
        super("\nPatrimônio inválido! Valor não pode ser negativo!");
    }
}
