package com.junxian.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname: WhiteConfig
 * @Date: 2022-01-04 15:05
 * @Author: tang_junXian
 * @Description: 白名单配置
 */
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "security")
public class WhiteConfig {

    /** 放行的白名单 */
    private List<String> whites = new ArrayList<>();

    public List<String> getWhites() {
        return whites;
    }

    public void setWhites(List<String> whites) {
        this.whites = whites;
    }
}
