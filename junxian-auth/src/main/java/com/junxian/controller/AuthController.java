package com.junxian.controller;

import com.junxian.dto.UserDTO;
import com.junxian.from.LoginBody;
import com.junxian.service.LoginService;
import com.junxian.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname: AuthController
 * @Date: 2021-12-31 15:48
 * @Author: tang_junXian
 * @Description: 登录模块
 */
@RestController
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginBody loginBody, HttpServletRequest request) {
        // 用户登录校验
        UserDTO userInfo = loginService.loginCheck(loginBody.getUserName(), loginBody.getPassword(), request);
        // 生成token
        return TokenUtil.createToken(loginBody.getUserName(), userInfo.getId());
    }

}
