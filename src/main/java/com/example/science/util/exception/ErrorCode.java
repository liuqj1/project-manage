package com.example.science.util.exception;

import org.springframework.http.HttpStatus;

/**
 * 全局异常枚举
 */

public enum ErrorCode {

    SUCCESS(200,HttpStatus.OK, "成功"),
    REQUEST_VALIDATION_FAILED(400, HttpStatus.BAD_REQUEST, "请求参数错误"),
    UNAUTHORIZED(401, HttpStatus.OK, "暂未登录或token已经过期"),
    AUTHORIZED_ERROR(401, HttpStatus.OK, "token验证失败"),
    FORBIDDEN(403, HttpStatus.OK, "没有相关权限"),
    RESOURCE_NOT_FOUND(404, HttpStatus.NOT_FOUND, "未找到该资源"),
    SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "服务器错误"),

    LOGIN_ERROR(1001, HttpStatus.OK, "用户名或密码错误"),
    FORBIDDEN_USER(1002, HttpStatus.OK, "此用户已禁用"),
    VERIFY_CODE_ERROR(1003, HttpStatus.OK, "验证码错误"),
    USER_EXISTED(1004, HttpStatus.OK, "该用户已存在"),
    ROLE_EXISTED(1004, HttpStatus.OK, "该角色已存在"),
    VALIDATECODE_ERROR(1005, HttpStatus.OK, "手机验证码错误"),
    USER_NOT_EXISTED(1006, HttpStatus.OK, "用户不存在"),
    PASSWORD_ERROR(1007,HttpStatus.OK,"密码错误")
    ;


    //错误码
    private final int code;

    //http状态码
    private final HttpStatus httpStatus;

    //提示信息
    private final String message;

    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
