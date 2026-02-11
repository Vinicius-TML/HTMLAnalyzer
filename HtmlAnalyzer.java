/**
 * Classe principal que inicia a análise de HTML a partir de uma URL.
 * Ponto de entrada do programa, responsável por receber o argumento
 * da linha de comando e exibir o resultado ou mensagem de erro adequada.
 */
public class HtmlAnalyzer {
    /**
     * Método principal do programa.
     * @param args Recebe apenas a URL como argumento na linha de comando.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("URL connection error");
            return;
        }
        HtmlAnalyzerFacade facade = new HtmlAnalyzerFacade();

        try {
            String deepestText = facade.analyzeHtml(args[0]);
            System.out.println(deepestText);
        } catch (UrlConnectionException e) {
            System.out.println("URL connection error");
        } catch (MalformedHtmlException e) {
            System.out.println("malformed HTML");
        }
    }
}