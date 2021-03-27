package com.zztest.aitestmini.service.impl;

import com.zztest.aitestmini.dao.ZzTestUserMapper;
import com.zztest.aitestmini.dto.ResultDto;
import com.zztest.aitestmini.dto.user.UserDto;
import com.zztest.aitestmini.entity.ZzTestUser;
import com.zztest.aitestmini.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/23/023 17:44
 * @Version: 1.0
 */

@Service

public class TestUserServiceImpl implements TestUserService {
    @Autowired
    private ZzTestUserMapper zzTestUserMapper;

    /**
     * user注册方法
     * @param zzTestUser
     * @return
     */
    @Override
    public ResultDto<ZzTestUser> save(ZzTestUser zzTestUser) {
        zzTestUser.setCreateTime(new Date());
        zzTestUser.setUpdateTime(new Date());
        zzTestUserMapper.insertUseGeneratedKeys(zzTestUser);
        return ResultDto.success("成功",zzTestUser);
    }

    @Override
    public String login(UserDto userDto) {
            System.out.println("userDto.getName()"+userDto.getName());
            System.out.println("userDto.pwd" +
                    "()"+userDto.getPwd());
            return  userDto.getName() +"-"+userDto.getPwd();
    }
}
