package com.zztest.aitestmini.service;

import com.zztest.aitestmini.dto.ResultDto;
import com.zztest.aitestmini.dto.user.UserDto;
import com.zztest.aitestmini.entity.ZzTestUser;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/23/023 17:43
 * @Version: 1.0
 */
public interface TestUserService {
    //登录接口
    public String login(UserDto userDto);
    // 注册
    public ResultDto<ZzTestUser> save(ZzTestUser zzTestUser);
}
