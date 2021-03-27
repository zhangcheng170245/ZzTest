package com.zztest.aitestmini.controller;

import com.alibaba.fastjson.JSONObject;
import com.zztest.aitestmini.dto.ResultDto;
import com.zztest.aitestmini.dto.user.AddUserDto;
import com.zztest.aitestmini.entity.ZzTestUser;
import com.zztest.aitestmini.service.TestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/27/027 17:52
 * @Version: 1.0
 */
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("ZzUser")
@Slf4j
public class ZzTestController {
    @Autowired
    private TestUserService testUserService;

    //用户注册
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultDto<ZzTestUser> save(@RequestBody AddUserDto addUserDto){
        ZzTestUser zztestUser = new ZzTestUser();
        //使用spring 工具直接赋值
        BeanUtils.copyProperties(addUserDto,zztestUser);
        // 单独赋值
        //       zztestUser.setEmail(addUserDto.getEmail());
        //实体类转换为json
      log.info("请求入参"+JSONObject.toJSONString(zztestUser));
        testUserService.save(zztestUser);
        return ResultDto.success("成功",zztestUser);
    }
}
