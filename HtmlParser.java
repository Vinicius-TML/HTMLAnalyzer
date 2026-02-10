import java.util.List;

/**
 * Classe responsável por varrer o HTML e encontrar o texto mais profundo.
 */
public class HtmlParser {
    /**
     * Analisa as linhas do HTML para encontrar o texto mais profundo.
     * @param lines Linhas pré-processadas do HTML.
     * @return Texto no nível mais profundo.
     */
    public String parse(List<String> lines) {
        int currentDepth = 0;
        int maxDepth = 0;
        String deepestText = "";

        for (String line : lines) {
            if (HtmlUtils.isOpeningTag(line)) {
                currentDepth++;
            } else if (HtmlUtils.isClosingTag(line)) {
                currentDepth--;
            } else {
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                    deepestText = line;
                }
            }
        }

        return deepestText;
    }
}