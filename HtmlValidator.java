import java.util.Stack;

/**
 * Valida a estrutura do HTML verificando o balanceamento das tags de abertura e fechamento.
 * Lança {@link MalformedHtmlException} imediatamente ao detectar uma inconsistência,
 * interrompendo o processamento sem necessidade de iterar o restante do documento.
 */
public class HtmlValidator implements HtmlLineHandler {
    private final Stack<String> tags = new Stack<>();

    /**
     * Processa uma linha e valida o balanceamento de tags.
     * Tags de abertura são empilhadas; tags de fechamento devem corresponder ao topo da pilha.
     * @param line Linha do HTML.
     * @throws MalformedHtmlException Se uma tag de fechamento não corresponder à abertura esperada.
     */
    @Override
    public void handle(String line) throws MalformedHtmlException {
        if (HtmlUtils.isOpeningTag(line)) {
            tags.push(line.substring(1, line.length() - 1));
        } else if (HtmlUtils.isClosingTag(line)) {
            String tagName = line.substring(2, line.length() - 1);
            if (tags.isEmpty() || !tags.pop().equals(tagName)) {
                throw new MalformedHtmlException("malformed HTML");
            }
        }
    }
}