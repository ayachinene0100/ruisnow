package org.ruisnow.ruisnow.support;

public abstract class BaseResult<T> implements Result<T> {

    protected Integer code;

    protected String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public abstract T getData();
}
