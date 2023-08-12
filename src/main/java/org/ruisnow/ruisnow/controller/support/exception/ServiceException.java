package org.ruisnow.ruisnow.controller.support.exception;

import java.io.Serial;

/**
 * 业务异常类
 * 例如：
 * 用户名非法、用户不存在等等
 */
public class ServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3118307753511049342L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
