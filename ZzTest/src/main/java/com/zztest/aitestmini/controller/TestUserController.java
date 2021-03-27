package com.zztest.aitestmini.controller;

import com.alibaba.fastjson.JSONObject;
import com.zztest.aitestmini.common.ServiceException;
import com.zztest.aitestmini.dto.ResultDto;
import com.zztest.aitestmini.dto.user.AddUserDto;
import com.zztest.aitestmini.dto.user.UserDto;
import com.zztest.aitestmini.entity.ZzTestUser;
import com.zztest.aitestmini.service.TestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/23/023 15:35
 * @Version: 1.0
 */

@Slf4j
@Api(tags = "橙子的测试平台-controller首页")
@RestController  //转换响应写入http响应
@RequestMapping("/user") // 将客户端请求路劲与后端方法绑定
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @Value("${zc.key}")  //读取配置文件
    private String zckey;

    @ApiOperation("登录接口")
   // @RequestMapping(value = "login",method = RequestMethod.POST)
    @PostMapping(value = "login")  // 只能用于方法级别
    //将request body中的json/xm1对象解析成该参数类型的Javabean对象
    //   public  String login(@RequestBody UserDto userDto){
    public ResultDto<UserDto> login(@RequestBody UserDto userDto){
        String result = testUserService.login(userDto);
             //全局异常处理
            if (userDto.getName().contains("error")){  //模拟异常类
                ServiceException.throwEx("用户名包含敏感信息");
            }
            if (userDto.getName().contains("error2")){
                throw new NullPointerException();
            }

       // return "成功"+ login+zckey;
        return ResultDto.success("成功"+result+zckey);
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

    //用户注册
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public  String save(@RequestBody AddUserDto addUserDto){
        ZzTestUser zztestUser = new ZzTestUser();
        //使用spring 工具直接赋值
        BeanUtils.copyProperties(addUserDto,zztestUser);
        // 单独赋值
 //       zztestUser.setEmail(addUserDto.getEmail());
        //实体类转换为json
        System.out.println(JSONObject.toJSONString(zztestUser));

        return "成功";
    }

}

