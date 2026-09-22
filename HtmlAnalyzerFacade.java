import java.util.List;

/**
 * Facade que coordena o fluxo completo de análise do HTML.
 * Delega a busca ao {@link HtmlFetcher} e processa cada linha uma única vez,
 * alimentando simultaneamente o {@link HtmlValidator} e o {@link HtmlParser}.
 */
public class HtmlAnalyzerFacade {
    private final HtmlFetcher fetcher;

    public HtmlAnalyzerFacade() {
        this.fetcher = new HtmlFetcher();
    }

    /**
     * Executa o fluxo completo de análise de HTML.
     * O conteúdo é obtido, validado e parseado em uma única iteração O(N).
     * @param url URL do HTML a ser analisado.
     * @return Texto encontrado no nível mais profundo da estrutura HTML.
     * @throws UrlConnectionException Se houver erro na conexão com a URL.
     * @throws MalformedHtmlException Se o HTML estiver malformado.
     */
    public String analyzeHtml(String url) throws UrlConnectionException, MalformedHtmlException {
        List<String> lines = fetcher.fetchContent(url);

        HtmlValidator validator = new HtmlValidator();
        HtmlParser parser = new HtmlParser();
        List<HtmlLineHandler> handlers = List.of(validator, parser);

        for (String line : lines) {
            for (HtmlLineHandler handler : handlers) {
                handler.handle(line);
            }
        }
        
        if (!lines.isEmpty()) {
            throw new MalformedHtmlException("malformed HTML");
        } 

        String result = parser.getDeepestText();
        if (result.isEmpty()) {
            throw new MalformedHtmlException("malformed HTML");
        }

        return result;
    }
}