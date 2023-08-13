package org.ruisnow.ruisnow.support.exception;

import org.ruisnow.ruisnow.controller.support.exception.ServiceException;

import java.io.Serial;

public class UserExistsException extends ServiceException {

    @Serial
    private static final long serialVersionUID = 1193733379960609122L;

    public UserExistsException() {
    }

    public UserExistsException(String message) {
        super(message);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsException(Throwable cause) {
        super(cause);
    }
}
