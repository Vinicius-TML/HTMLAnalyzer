import java.util.ArrayList;
import java.util.List;

/**
 * Facade que comanda o fluxo de comandos para analise e verificação do código HTML
 */
public class HtmlAnalyzerFacade {
    private final HtmlFetcher fetcher;
    private final HtmlValidator validator;
    private final HtmlParser parser;

    public HtmlAnalyzerFacade() {
        this.fetcher = new HtmlFetcher();
        this.validator = new HtmlValidator();
        this.parser = new HtmlParser();
    }

    /**
     * Executa o fluxo completo de análise de HTML.
     * @param url URL do HTML a ser analisado.
     * @return Texto no nível mais profundo do HTML.
     * @throws UrlConnectionException Se houver erro na conexão com a URL.
     * @throws MalformedHtmlException Se o HTML estiver malformado.
     */
    
    public String analyzeHtml(String url) throws UrlConnectionException, MalformedHtmlException {
        if (url.isEmpty()){
        }
        String htmlContent = fetcher.fetchContent(url);

        List<String> lines = preprocessHtml(htmlContent);

        if (validator.isMalformedHtml(lines)) {
            throw new MalformedHtmlException("malformed HTML");
        }

        String deepestText = parser.parse(lines);
        if(deepestText.isEmpty()){
            throw new MalformedHtmlException("malformed HTML");
        }

        return deepestText;
    }

    /**
     * Pré-processa o conteúdo HTML: divide em linhas, remove espaços em branco e linhas vazias.
     * @param htmlContent Conteúdo HTML bruto.
     * @return Lista de linhas pré-processadas.
     */
    private List<String> preprocessHtml(String htmlContent) {
        List<String> lines = new ArrayList<>();
        String[] rawLines = htmlContent.split("\n");

        for (String line : rawLines) {
            String trimmedLine = line.trim();
            if (!trimmedLine.isEmpty()) {
                lines.add(trimmedLine);
            }
        }

        return lines;
    }
}