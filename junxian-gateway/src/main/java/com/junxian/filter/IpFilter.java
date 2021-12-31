package com.junxian.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * @Classname: IpFilter
 * @Date: 2021-12-31 8:49
 * @Author: tang_junXian
 * @Description: ip拦截器
 */
@Component
public class IpFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        //TODO 设置ip白名单
        System.out.println("ip:"+remoteAddress.getHostName());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
