package com.t.zero.common.base.controller;

import com.t.zero.component.response.ResponseExceptionHandler;

public class TZeroBasicController {

    public final ResponseExceptionHandler responseExceptionHandler;

    public TZeroBasicController(ResponseExceptionHandler responseExceptionHandler) {
        this.responseExceptionHandler = responseExceptionHandler;
    }

}
