import java.util.List;
import java.util.Stack;

public class HtmlValidator {
    /**
     * verifica se o código Html é malformado
     * @param lines Linhas do Html
     * @return true se o html for malformado, false do contrário
     */
    public boolean isMalformedHtml(List<String> lines) {
        Stack<String> tags = new Stack<>();

        for (String line : lines) {
            if (HtmlUtils.isOpeningTag(line)) {
                String tagName = line.substring(1, line.length() - 1);
                tags.push(tagName);
            } else if (HtmlUtils.isClosingTag(line)) {
                String tagName = line.substring(2, line.length() - 1);
                if (tags.isEmpty() || !tags.pop().equals(tagName)) {
                    return true;
                }
            }
        }

        return !tags.isEmpty();
    }
}