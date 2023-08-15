package org.ruisnow.ruisnow.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ruisnow.ruisnow.support.exception.ServiceException;

public abstract class BaseResult<T> implements Result<T> {

    private static final ObjectMapper mapper = new ObjectMapper();

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

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new ServiceException("Result转json字符串失败");
        }
    }
}
