package com.zztest.aitestmini.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: zhangcheng
 * @Description: 实体类，    封装客户端与服务器交互请求响应参数
 * @Date: 2021/3/23/023 15:46
 * @Version: 1.0
 */
@ApiModel("用户登录对象")
@Data
public class UserDto {
    @ApiModelProperty(value = "用户名",required = true)
    private String name;
    @ApiModelProperty(value = "密码",required = true)
    private String pwd;
}
