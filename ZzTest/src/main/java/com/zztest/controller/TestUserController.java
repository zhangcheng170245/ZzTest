package com.zztest.controller;

import com.zztest.dto.UserDto;
import com.zztest.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/23/023 15:35
 * @Version: 1.0
 */

@RestController  //转换响应写入http响应
@RequestMapping("/user") // 将客户端请求路劲与后端方法绑定
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

   // @RequestMapping(value = "login",method = RequestMethod.POST)
    @PostMapping(value = "login")  // 只能用于方法级别
    //将request body中的json/xm1对象解析成该参数类型的Javabean对象
    public  String login(@RequestBody UserDto userDto){
        String login = testUserService.login(userDto);
        return "成功"+ login;
    }

    @RequestMapping(value = "byId/{userId}",method = RequestMethod.GET)
    //处理动态的URI，URI 的值可以作为控制器中处理方法的参数
    public  String get(@PathVariable("userId") Long userId){
        System.out.println("userId"+userId);
        return "成功"+userId;
    }

    @GetMapping( "byId")
    public  String get2(@RequestParam(value = "userId",required = true) Long userId){
        System.out.println("RequestParam userId1"+userId);
        return "成功"+userId;
    }


}

