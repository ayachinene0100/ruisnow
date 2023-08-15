package org.ruisnow.ruisnow.support.exception;

import java.io.Serial;

public class NeedLoginException extends ServiceException {

    @Serial
    private static final long serialVersionUID = 5345047968169089646L;

    public NeedLoginException() {
    }

    public NeedLoginException(String message) {
        super(message);
    }

    public NeedLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public NeedLoginException(Throwable cause) {
        super(cause);
    }
}
