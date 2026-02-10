import java.util.ArrayList;
import java.util.List;

public class HtmlAnalyzerFacade {
    private final HtmlFetcher fetcher;

    public HtmlAnalyzerFacade() {
        this.fetcher = new HtmlFetcher();
    }

    public String analyzeHtml(String url) throws UrlConnectionException, MalformedHtmlException {
        List<String> lines = fetcher.fetchContent(url);

        HtmlValidator validator = new HtmlValidator();
        HtmlParser parser = new HtmlParser();

        for (String line : lines) {
            validator.handle(line);
            parser.handle(line);
        }

        if (validator.isMalformed()) {
            throw new MalformedHtmlException("malformed HTML");
        }

        String result = parser.getDeepestText();
        if (result.isEmpty()) {
            throw new MalformedHtmlException("malformed HTML");
        }

        return result;
    }
}