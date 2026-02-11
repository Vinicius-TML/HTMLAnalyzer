/**
 * Interface para processadores de linhas HTML.
 * Cada implementação mantém seu próprio estado interno entre chamadas,
 * permitindo que o documento seja processado linha a linha em iteração única.
 */
public interface HtmlLineHandler {
    /**
     * Processa uma linha do HTML.
     * @param line Linha do HTML já sem indentação e sem espaços extras.
     * @throws MalformedHtmlException Se a linha tornar a estrutura HTML inválida.
     */
    void handle(String line) throws MalformedHtmlException;
}