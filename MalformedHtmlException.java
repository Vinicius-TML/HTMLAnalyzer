/**
 * Exceção lançada quando o HTML analisado possui estrutura inválida,
 * como tags de fechamento sem abertura correspondente ou tags não fechadas.
 */
public class MalformedHtmlException extends Exception {

    public MalformedHtmlException(String message) {
        super(message);
    }
}
