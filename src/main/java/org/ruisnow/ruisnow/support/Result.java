package org.ruisnow.ruisnow.support;

public interface Result<T> {

    Integer getCode();

    String getMsg();

    T getData();

    static <T> Result<T> ok(T data) {
        DataResult<T> result = new DataResult<>();
        result.code = Code.OK.getValue();
        result.msg = Code.OK.getMsg();
        result.data = data;
        return result;
    }

    static ErrorResult error(Throwable th, Code code) {
        ErrorResult result = new ErrorResult();
        result.code = code.getValue();
        result.msg = th.getMessage();
        return result;
    }
}
