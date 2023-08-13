package org.ruisnow.ruisnow.support;

public class DataResult<T> extends BaseResult<T> {

    T data;

    @Override
    public T getData() {
        return this.data;
    }
}
