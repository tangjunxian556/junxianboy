package com.junxian.controller;

import com.junxian.dto.UserDTO;
import com.junxian.service.UserService;
import com.junxian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: UserController
 * @Date: 2022-01-04 9:54
 * @Author: tang_junXian
 * @Description: 用户模块
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info/byUserName")
    public Result<UserDTO> getUserInfoByUserName(@RequestParam String userName) {
        return new Result<UserDTO>().ok(userService.getUserInfoByUserName(userName));
    }

}
