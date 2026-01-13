import java.util.List;

import ativos.Criptoativo;
import ativos.Acao;
import ativos.Fii;
import ativos.Stock;
import ativos.Tesouro;
import leituraDeArquivos.Leitor;

public class App {
    public static void main(String[] args) throws Exception {
        List<Acao> acoes = Leitor.listaAcao();
        List<Criptoativo> criptoativos = Leitor.listaCriptoativo();
        List<Fii> fiis = Leitor.listaFii();
        List<Tesouro> tesouros = Leitor.listaTesouro();
        List<Stock> stocks = Leitor.listaStock();

        System.out.println("Ações: " + acoes);
        System.out.println("Criptoativos: " + criptoativos);
        System.out.println("FIIs: " + fiis);
        System.out.println("Tesouros: " + tesouros);
        System.out.println("Stocks: " + stocks);
    }
}
