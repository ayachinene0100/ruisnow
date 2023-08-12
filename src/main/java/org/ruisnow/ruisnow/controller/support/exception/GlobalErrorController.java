package org.ruisnow.ruisnow.controller.support.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.ruisnow.ruisnow.controller.support.Code;
import org.ruisnow.ruisnow.controller.support.ErrorResult;
import org.ruisnow.ruisnow.controller.support.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalErrorController.class);

    @Aspect
    @Component
    private static class HandleErrorAspect {

        @Before("execution(" +
                "public org.ruisnow.ruisnow.controller.support.ErrorResult " +
                "org.ruisnow.ruisnow.controller.support.exception.GlobalErrorController." +
                "handleError(..))")
        public void beforeHandle(JoinPoint joinPoint) {
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof Throwable) {
                    logger.error("Error occurred!", (Throwable) arg);
                }
            }
        }
    }

    @ExceptionHandler(Throwable.class)
    public ErrorResult handleError(Throwable th) {
        return Result.error(th, Code.INTERNAL_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ErrorResult handleError(ServiceException e) {
        return Result.error(e, Code.SERVICE_ERROR);
    }
}
