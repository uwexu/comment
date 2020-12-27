package com.demo.comment.entity;

import com.demo.comment.constant.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDTO {

    private int code;
    private String message;
    private Object result;

    //成功方法
    public static ResponseDTO success(Object result) {
        return new ResponseDTO(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),result);
    }

    // 失败方法
    public static ResponseDTO fail(Integer code, String message) {
        return new ResponseDTO(code, message,null);
    }

    public ResponseDTO(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }


}
