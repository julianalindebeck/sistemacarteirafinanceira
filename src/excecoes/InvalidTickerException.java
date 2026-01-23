package excecoes;

public class InvalidTickerException extends IllegalArgumentException {
    public InvalidTickerException(){
        super("\nTicker inválido! Não pode ser nulo ou em branco!");
    }
}
