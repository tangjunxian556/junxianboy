package com.junxian.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Classname: UrlFilter
 * @Date: 2021-12-31 8:52
 * @Author: tang_junXian
 * @Description: url拦截器
 */
@Component
public class UrlFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        //TODO 拦截特定URL地址
        System.out.println("url:"+url);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
