package com.junxian.filter;

import com.alibaba.fastjson.JSONObject;
import com.junxian.config.WhiteConfig;
import com.junxian.utils.Result;
import com.junxian.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
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

    @Autowired
    private WhiteConfig whiteConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        // 放行白名单
        if (whiteConfig.getWhites().contains(url)) {
            return chain.filter(exchange);
        }
        // 校验token
        String token = request.getHeaders().getFirst("Authorization");
        if (StringUtils.isNotBlank(token)) {
            return unAuthorizationResponse(exchange, "token令牌不能为空！！！");
        }
        if (!TokenUtil.verifyToken(token)) {
            return unAuthorizationResponse(exchange, "令牌已过期或验证不正确！！！");
        }
        return chain.filter(exchange);
    }

    private Mono<Void> unAuthorizationResponse(ServerWebExchange exchange, String msg) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        Result<?> data = new Result<>().error(401, msg);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSONObject.toJSONString(data).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
