package com.zztest.dto;

import lombok.Data;

/**
 * @Author: zhangcheng
 * @Description: 实体类，    封装客户端与服务器交互请求响应参数
 * @Date: 2021/3/23/023 15:46
 * @Version: 1.0
 */
@Data
public class UserDto {
    private String name;
    private String  pwd;
}
