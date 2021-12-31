package com.junxian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname: JunxianAdminApplication
 * @Date: 2021-12-31 9:28
 * @Author: tang_junXian
 * @Description:
 */
@SpringBootApplication
public class JunxianAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JunxianAdminApplication.class, args);
        System.out.println("junxian业务模块启动成功！！！");
    }

}
