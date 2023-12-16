package exception;

import java.io.Serial;

public class StateAlreadyRunningException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 2604575758400509132L;

    public StateAlreadyRunningException() {
        super();
    }
    public StateAlreadyRunningException(String message) {
        super(message);
    }
    public StateAlreadyRunningException(String message, Throwable cause) {
        super(message, cause);
    }

}
