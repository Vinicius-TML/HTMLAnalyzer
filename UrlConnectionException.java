/**
 * Exceção lançada quando não é possível obter o conteúdo HTML da URL fornecida,
 * seja por falha de rede, URL inválida ou qualquer outro erro de conexão.
 */
public class UrlConnectionException extends Exception {

    public UrlConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
