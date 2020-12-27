package com.demo.comment.constant;


public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(0,"success"),
    /**
     * 服务器异常
     */
    SERVER_ERROR(23,"server error"),
    /**
     * 签名校验失败
     */
    CHECK_SIGN_ERROR(10001,"check sign error"),
    /**
     * 缺少参数
     */
    PARAM_EMPTY_ERROR(10002,"param empty error"),
    /**
     * 接口频率限制
     */
    FREQUENCY_RESTRICT_ERROR(10003,"frequency_restrict_error");

    ResponseCode(int code, String message){
        this.code=code;
        this.message=message;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}