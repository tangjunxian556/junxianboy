package com.junxian.service;

import com.junxian.dto.UserDTO;

/**
 * @Classname: UserService
 * @Date: 2022-01-04 10:58
 * @Author: tang_junXian
 * @Description: 用户接口类
 */
public interface UserService {

    /**
     * 根据用户名查询用户详细信息
     * @param userName 用户名
     * @return 用户信息
     */
    UserDTO getUserInfoByUserName(String userName);
}
