package com.junxian.service.impl;

import com.junxian.dao.UserDao;
import com.junxian.dto.UserDTO;
import com.junxian.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname: UserServiceImpl
 * @Date: 2022-01-04 10:58
 * @Author: tang_junXian
 * @Description: 用户接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDTO getUserInfoByUserName(String userName) {
        return userDao.selectUserInfoByUserName(userName);
    }

}
