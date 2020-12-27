package com.demo.comment.exceptions;

import com.demo.comment.constant.ResponseCode;

public class BizException extends Exception {

    private final int code;

    public int getCode() {
        return code;
    }

    public BizException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }

}
