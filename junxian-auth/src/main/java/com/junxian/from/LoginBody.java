package com.junxian.from;

import lombok.Data;

/**
 * @Classname: LoginBody
 * @Date: 2021-12-31 15:52
 * @Author: tang_junXian
 * @Description: 登录请求参数类
 */
@Data
public class LoginBody {

    private String userName;

    private String password;

}
