/**
 * Classe principal que inicia a análise de HTML a partir de uma URL.
 */
public class HtmlAnalyzer {
    /**
     * Método principal do programa.
     * @param args Recebe apenas a URL como argumento na linha de comando.
     */
    public static void main(String[] args) {
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