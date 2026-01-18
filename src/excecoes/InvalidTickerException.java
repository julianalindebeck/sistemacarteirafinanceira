package excecoes;

public class InvalidTickerException extends IllegalArgumentException {
    public InvalidTickerException(){
        super("Ticker inválido! Não pode ser nulo ou em branco!");
    }
}
