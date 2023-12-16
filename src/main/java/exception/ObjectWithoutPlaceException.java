package exception;

import java.io.Serial;

public class ObjectWithoutPlaceException extends Exception{
    @Serial
    private static final long serialVersionUID = 5946520803894786125L;

    public ObjectWithoutPlaceException() {
        super();
    }
    public ObjectWithoutPlaceException(String message) {
        super(message);
    }
    public ObjectWithoutPlaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
