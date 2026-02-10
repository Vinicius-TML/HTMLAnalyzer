/**
 * Classe utilitária para operações relacionadas a tags HTML.
 */
public class HtmlUtils {

    /**
     * Verifica se a linha representa uma tag de abertura (ex: <div>).
     * @param line Linha do HTML.
     * @return true se for uma tag de abertura.
     */
    public static boolean isOpeningTag(String line) {
        return line.startsWith("<") && 
               line.endsWith(">") && 
               !line.startsWith("</");
    }

    /**
     * Verifica se a linha representa uma tag de fechamento (ex: </div>).
     * @param line Linha do HTML.
     * @return true se for uma tag de fechamento.
     */
    public static boolean isClosingTag(String line) {
        return line.startsWith("</") && 
               line.endsWith(">");
    }
}