package com.example.science.util.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ErrorResponse response;

    /**
     * 处理controller方法的参数异常
     * @param e
     * @return
     * ConstraintViolationException 通常发生在请求参数违反约束条件的情况，例如使用 @RequestParam 注解时，如果参数校验失败，就会抛出这个异常。
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        response.setCode(400);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("请求参数错误");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * 处理controller方法的实体类参数异常
     * @param ex
     * @return
     * MethodArgumentNotValidException 通常发生在请求参数校验失败的情况，例如使用 @Valid 注解进行参数校验时，如果校验失败，就会抛出这个异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuffer stringBuffer=new StringBuffer();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            stringBuffer.append(errorMessage+";");
        });
        ErrorCode errorCode=ErrorCode.REQUEST_VALIDATION_FAILED;
        response.setCode(errorCode.getCode());
        response.setStatus(errorCode.getHttpStatus().value());
        response.setMessage(stringBuffer.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * 处理基础异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleAppException(BaseException ex) {
        response.setCode(ex.getError().getCode());
        response.setStatus(ex.getError().getHttpStatus().value());
        response.setMessage(ex.getError().getMessage());
        response.setData(ex.getData());
        return ResponseEntity.status(ex.getError().getHttpStatus()).body(response);
    }

}
