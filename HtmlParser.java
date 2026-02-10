/**
 * Classe responsável por varrer o HTML e encontrar o texto mais profundo.
 */
public class HtmlParser implements HtmlLineHandler {
    private int currentDepth = 0;
    private int maxDepth = 0;
    private String deepestText = "";
    /**
     * Processa uma linha, atualizando a profundidade atual e o texto mais profundo encontrado.
     * @param line Linha do HTML.
     */
    @Override
    public void handle(String line) {
        if (HtmlUtils.isOpeningTag(line)) {
            currentDepth++;
        } else if (HtmlUtils.isClosingTag(line)) {
            currentDepth--;
        } else if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
            deepestText = line;
        }
    }

    /**
     * Retorna o texto encontrado no nível mais profundo do HTML.
     * @return Texto mais profundo já encontrado.
     */
    public String getDeepestText() {
        return deepestText;
    }
}