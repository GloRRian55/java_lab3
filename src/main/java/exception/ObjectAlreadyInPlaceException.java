package exception;

import java.io.Serial;

public class ObjectAlreadyInPlaceException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6149513127208409086L;

    public ObjectAlreadyInPlaceException() {
        super();
    }
    public ObjectAlreadyInPlaceException(String message) {
        super(message);
    }
    public ObjectAlreadyInPlaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
