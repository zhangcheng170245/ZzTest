package com.zztest.aitestmini.common;

/**
 * @Author: zhangcheng
 * @Description: 服务异常自定义类
 * @Date: 2021/3/23/023 21:39
 * @Version: 1.0
 */
public class ServiceException extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceException(final String message, Throwable th){
        super(message,th);
        this.message = message;
    }

    public ServiceException(final String message){
        this.message = message;
    }

    public static void throwEx(String message){
        throw new ServiceException(message);
    }

}


