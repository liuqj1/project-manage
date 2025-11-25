package com.example.science.util.exception;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义
 * 基础异常类
 * see： https://blog.csdn.net/m0_59640673/article/details/132229137
 */
public class BaseException extends RuntimeException{

    private final ErrorCode error;
    private final HashMap<String, Object> data = new HashMap<>();

    public BaseException(ErrorCode error, Map<String, Object> data) {
        super(error.getMessage());
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    public ErrorCode getError() {
        return error;
    }

    public HashMap<String, Object> getData() {
        return data;
    }
}
