package investidores;

public class Movimentacao {
    private static String id;
    private static String indicador;
    private static String instituicao;
    private static double qtd;
    private static String data;
    private static double preco;

    public static void realizarVenda(){
        indicador = "Venda";
    }

    public static void realizarCompra(){
        indicador = "Compra";
    }
   
}
