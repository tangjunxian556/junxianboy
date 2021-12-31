package com.junxian.controller;

import com.junxian.dao.TestDao;
import com.junxian.server.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: TestController
 * @Date: 2021-12-31 9:50
 * @Author: tang_junXian
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/aaa")
    public String test() {
        String test = testService.select();
        return "hello, world!!!";
    }

}
