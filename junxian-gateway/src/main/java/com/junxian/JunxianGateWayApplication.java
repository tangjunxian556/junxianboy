package com.junxian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname: JunxianGateWayApplication
 * @Date: 2021-12-30 15:10
 * @Author: tang_junXian
 * @Description: 网关服务
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JunxianGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JunxianGateWayApplication.class, args);
        System.out.println("junxian-网关服务启动成功！！！");
    }

}
