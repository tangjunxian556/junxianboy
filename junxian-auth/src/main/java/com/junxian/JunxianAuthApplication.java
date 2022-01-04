package com.junxian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname: JunxianAuthApplication
 * @Date: 2021-12-31 15:49
 * @Author: tang_junXian
 * @Description: 权限模块
 */
@SpringBootApplication
@EnableFeignClients
public class JunxianAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JunxianAuthApplication.class, args);
        System.out.println("junxian-登录服务启动成功！！！");
    }

}
