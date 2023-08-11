package org.ruisnow.ruisnow.controller.support;

import org.springframework.http.HttpStatus;

public interface Result<T> {

    Integer getCode();

    String getMsg();

    T getData();

    static <T> Result<T> success(T data) {
        DataResult<T> result = new DataResult<>();
        result.code = HttpStatus.OK.value();
        result.msg = HttpStatus.OK.name();
        result.data = data;
        return result;
    }

    static ErrorResult error(Throwable th, Integer code) {
        ErrorResult result = new ErrorResult();
        result.code = code;
        result.msg = th.getMessage();
        return result;
    }
}
