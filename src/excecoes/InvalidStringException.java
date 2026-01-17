package excecoes;

public class InvalidStringException extends IllegalArgumentException {
    public InvalidStringException(){
        super("Ticker inválido! Não pode ser nulo ou em branco!");
    }
}
