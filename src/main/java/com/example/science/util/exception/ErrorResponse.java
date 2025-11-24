package com.example.science.util.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

/**
 * 返回给前端的封装数据
 */
@Component
public class ErrorResponse {

    private int code;
    private int status;
    private String message;
    private Object data;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, int status, String message, HashMap<String, Object> data) {
        this.code = code;
        this.status = status;
        this.message = message;
        if (!ObjectUtils.isEmpty(data)) {
            this.data = data;
        }
    }

    public ErrorResponse(int code, int status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 成功情况返回
     * @param data
     * @return
     */
    public static ResponseEntity<ErrorResponse> success(Object data) {
        ErrorCode ex = ErrorCode.SUCCESS;
        ErrorResponse response=new ErrorResponse();
        response.setCode(ex.getCode());
        response.setStatus(ex.getHttpStatus().value());
        response.setMessage(ex.getMessage());
        response.setData(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
