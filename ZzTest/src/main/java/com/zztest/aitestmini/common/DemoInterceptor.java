package com.zztest.aitestmini.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhangcheng
 * @Description: 拦截器示例
 * @Date: 2021/3/24/024 11:28
 * @Version: 1.0
 */
@Component  // 生成 springBean 以便注入
@Slf4j
public class DemoInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle===================");
        log.info("request.getURI:请求地址："+request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
        log.info("request.getURI"+request.getRequestURI());
        response.setCharacterEncoding("utf-8");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
        log.info("request.getURI"+request.getRequestURI());
        response.setCharacterEncoding("utf-8"); // 解决乱码

    }
}
