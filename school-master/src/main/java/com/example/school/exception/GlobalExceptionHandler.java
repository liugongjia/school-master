package com.example.school.exception;


import com.example.school.util.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


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
        e.printStackTrace();
        return R.failed(e.getMessage());
    }
}
