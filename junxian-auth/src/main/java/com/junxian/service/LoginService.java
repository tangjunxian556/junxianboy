package com.junxian.service;

import com.junxian.dto.UserDTO;
import com.junxian.exception.AuthException;
import com.junxian.feign.UserFeignClient;
import com.junxian.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname: LoginService
 * @Date: 2021-12-31 16:01
 * @Author: tang_junXian
 * @Description: 登录服务
 */
@Service
public class LoginService {

    @Autowired
    private UserFeignClient userFeignClient;

    public UserDTO loginCheck(String userName, String password, HttpServletRequest request) {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(userName, password)) {
            throw new AuthException(500, "用户/密码必须填写");
        }
        // 根据userName查询用户信息
        UserDTO userInfo = userFeignClient.getUserInfoByUserName(userName).getData();
        // 用户不存在
        if (userInfo == null) {
            throw new AuthException(500, "用户不存在");
        }
        // 用户密码错误
        if (!userInfo.getPassword().equals(password)) {
            throw new AuthException(500, "用户密码错误");
        }
        // 登录成功
        return userInfo;
    }

}
