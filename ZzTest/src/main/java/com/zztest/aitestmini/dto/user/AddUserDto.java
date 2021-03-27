package com.zztest.aitestmini.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: zhangcheng
 * @Description: 新增用户
 * @Date: 2021/3/27/027 17:20
 * @Version: 1.0
 */
@ApiModel(value = "用户注册对象",description="用户对象user")
@Data
public class AddUserDto {
    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名", example="hogwarts",required=true)
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码", example="hogwarts",required=true)
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱", example="hogwarts",required=true)
    private String email;

    /**
     * 自动生成用例job名称 不为空时表示已经创建job
     */
    @ApiModelProperty(value="用户名", example="hogwarts")
    private String autoCreateCaseJobName;

    /**
     * 执行测试job名称 不为空时表示已经创建job
     */
    @ApiModelProperty(value="用户名", example="hogwarts")
    private String startTestJobName;

    /**
     * 默认Jenkins服务器
     */
    @ApiModelProperty(value="用户名", example="hogwarts")
    private Integer defaultJenkinsId;
}