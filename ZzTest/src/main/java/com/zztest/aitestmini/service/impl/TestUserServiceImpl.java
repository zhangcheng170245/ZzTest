package com.zztest.aitestmini.service.impl;

import com.zztest.aitestmini.dto.UserDto;
import com.zztest.aitestmini.service.TestUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/23/023 17:44
 * @Version: 1.0
 */

@Service
public class TestUserServiceImpl implements TestUserService {

    @Override
    public String login(UserDto userDto) {
            System.out.println("userDto.getName()"+userDto.getName());
            System.out.println("userDto.pwd" +
                    "()"+userDto.getPwd());
            return  userDto.getName() +"-"+userDto.getPwd();
    }
}
