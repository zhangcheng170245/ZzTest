package com.zztest.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhangcheng
 * @Description: 全局异常捕获类 分业务异常和其他异常两种
 * 其中业务异常为使用ServiceException类包装的异常，其他异常则为java原生异常
 * @Date: 2021/3/23/023 21:55
 * @Version: 1.0
 */
@Slf4j  //日志注解
@ResponseBody  //将响应直接映射到http响应中
@ControllerAdvice //处理异常类
public class GlobalExceptionHandler {
    @ExceptionHandler({ServiceException.class})
    public String serviceExceptionHandler(){
        return  "业务异常";
    }

    @ExceptionHandler({Exception.class})
    public String exceptionHandler(){
        return  "非业务异常";
    }

    @ExceptionHandler({Throwable.class})
    public String throwableHandler(){
        return "系统错误";
    }

}
