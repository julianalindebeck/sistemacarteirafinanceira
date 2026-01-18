package excecoes;

public class InvalidHeritageException extends IllegalArgumentException {
    public InvalidHeritageException() {
        super("Patrimônio inválido! Valor não pode ser negativo!");
    }
}
