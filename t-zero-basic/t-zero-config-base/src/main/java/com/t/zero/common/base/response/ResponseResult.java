package com.t.zero.common.base.response;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private int status;

    private Object message;

    private T data;

    private static String TO_STRING_FORMAT = "{\"status\": %d, \"message\": \"%s\"}";

    public static <T> ResponseResult<T> ok(T data) {
        return new ResponseResult<T>(TZeroResponseStatus.OK.value(), null, data);
    }

    public static <T> ResponseResult<T> loginFailed(T data) {
        return new ResponseResult<T>(403, "用户名或者密码错误", data);
    }

    public static <T> ResponseResult<T> loginFailedSend(T data) {
        return new ResponseResult<T>(403, "请先注册", data);
    }

    public static <T> ResponseResult<T> validSMS(T data) {
        return new ResponseResult<T>(203, "你已接收验证码，10分钟内有效", data);
    }

    public static <T> ResponseResult<T> failed(Object message) {
        return new ResponseResult<T>(TZeroResponseStatus.ERROR.value(), message, null);
    }

    public ResponseResult(int status, Object message, T data) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, this.status, this.message);

    }
}
