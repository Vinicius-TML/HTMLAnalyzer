import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Classe responsável por obter o conteúdo HTML de uma URL.
 */
public class HtmlFetcher {
    /**
     * Busca o conteúdo HTML de uma URL.
     * @param urlString URL a ser acessada.
     * @return Conteúdo HTML como String.
     * @throws UrlConnectionException Se a conexão falhar.
     */
    public String fetchContent(String urlString) throws UrlConnectionException {
    StringBuilder content = new StringBuilder();
    
    try {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } finally {
            connection.disconnect();
        }
    } catch (Exception e) {
        throw new UrlConnectionException("URL connection error", e);
    }
    
    return content.toString();
    }
}