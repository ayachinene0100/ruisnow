package org.ruisnow.ruisnow.controller.support;

public class DataResult<T> extends BaseResult<T> {

    T data;

    @Override
    public T getData() {
        return this.data;
    }
}
