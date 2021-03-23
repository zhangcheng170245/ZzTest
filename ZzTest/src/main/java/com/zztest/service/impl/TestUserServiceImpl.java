package com.zztest.service.impl;

import com.zztest.dto.UserDto;
import com.zztest.service.TestUserService;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/23/023 17:44
 * @Version: 1.0
 */

@Component
public class TestUserServiceImpl implements TestUserService {


    @Override
    public String login(UserDto userDto) {
            System.out.println("userDto.getName()"+userDto.getName());
            System.out.println("userDto.pwd" +
                    "()"+userDto.getPwd());
            return  userDto.getName() +"-"+userDto.getPwd();
    }
}
