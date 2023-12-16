package exception;

import java.io.Serial;

public class ObjectNotInThisPlaceException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -3962713269744266693L;

    public ObjectNotInThisPlaceException() {
        super();
    }
    public ObjectNotInThisPlaceException(String message) {
        super(message);
    }
    public ObjectNotInThisPlaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
