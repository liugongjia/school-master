package com.example.school.exception;


import com.example.school.util.R;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 全局异常处理器
 *
 * @author zhangzhengguang
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 全局异常
     */
    @ExceptionHandler(Exception.class)
    public R baseServiceException(Exception e) {
        return R.failed(e.getMessage());
    }
}
