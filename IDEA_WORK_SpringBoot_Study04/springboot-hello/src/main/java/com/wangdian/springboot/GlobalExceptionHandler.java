package com.wangdian.springboot;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    public Map<String, Object> handleArithmeticException(ArithmeticException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        e.printStackTrace();
        map.put("errorCode", "201");
        map.put("errorMsg", "算数异常");
        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handlerException(Exception e) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", "101");
        map.put("errorMsg", "未知异常");
        return map;
    }
}
