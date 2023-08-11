package org.ruisnow.ruisnow.controller.support.exception;

import org.ruisnow.ruisnow.controller.support.Code;
import org.ruisnow.ruisnow.controller.support.ErrorResult;
import org.ruisnow.ruisnow.controller.support.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorController {

    @ExceptionHandler(Throwable.class)
    public ErrorResult handleError(Throwable th) {
        return Result.error(th, Code.INTERNAL_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ErrorResult handleError(ServiceException e) {
        return Result.error(e, Code.SERVICE_ERROR);
    }
}
