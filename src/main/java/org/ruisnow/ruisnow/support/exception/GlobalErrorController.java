package org.ruisnow.ruisnow.support.exception;

import jakarta.validation.ConstraintViolationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.ruisnow.ruisnow.support.Code;
import org.ruisnow.ruisnow.support.ErrorResult;
import org.ruisnow.ruisnow.support.Result;
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

        /**
         * 在非业务异常处理之前打印异常堆栈
         */
        @Before("execution(" +
                "public org.ruisnow.ruisnow.support.ErrorResult " +
                "GlobalErrorController.handleError(Throwable))")
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
        return Result.error("Internal error!", Code.INTERNAL_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ErrorResult handleError(ServiceException e) {
        return Result.error(e, Code.SERVICE_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResult handleError(ConstraintViolationException e) {
        // 多个错误出现时只取第一个
        //noinspection OptionalGetWithoutIsPresent
        return Result.error(e.getConstraintViolations().stream().findFirst().get().getMessage(), Code.SERVICE_ERROR);
    }
}
