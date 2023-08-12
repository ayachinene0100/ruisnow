package org.ruisnow.ruisnow.controller.support;

public enum Code {

    /**
     * 正常返回
     */
    OK(0, "ok"),
    /**
     * 业务错误
     */
    SERVICE_ERROR(1, "service error"),
    /**
     * 服务器内部错误
     */
    INTERNAL_ERROR(2, "internal error");

    private final int value;

    private final String msg;

    Code(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }
}
