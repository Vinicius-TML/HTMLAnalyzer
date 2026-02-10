import java.util.Stack;
public class HtmlValidator implements HtmlLineHandler {
    private final Stack<String> tags = new Stack<>();
    private boolean malformed = false;

    /**
     * verifica se o código Html é malformado
     * @param lines Linhas do Html
     * @return true se o html for malformado, false do contrário
     */
    @Override
    public void handle(String line) {
        if (malformed) return;

        if (HtmlUtils.isOpeningTag(line)) {
            tags.push(line.substring(1, line.length() - 1).toLowerCase());
        } else if (HtmlUtils.isClosingTag(line)) {
            String tagName = line.substring(2, line.length() - 1).toLowerCase();
            if (tags.isEmpty() || !tags.pop().equals(tagName)) {
                malformed = true;
            }
        }
    }

    public boolean isMalformed() {
        return malformed || !tags.isEmpty();
    }
}