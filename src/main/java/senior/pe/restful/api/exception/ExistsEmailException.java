package senior.pe.restful.api.exception;

public class ExistsEmailException extends RuntimeException {
    public ExistsEmailException(String message) {
        super(message);
    }
}
