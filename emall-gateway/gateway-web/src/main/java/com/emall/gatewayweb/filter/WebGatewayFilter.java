package com.emall.gatewayweb.filter;

import com.emall.authclient.service.IAuthService;
import com.emall.gatewayweb.service.IPermissionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 网关请求过滤
 */
@Configuration
@Slf4j
@ComponentScan(basePackages = "com.emall.authclient")
public class WebGatewayFilter implements GlobalFilter {

    @Autowired
    private IAuthService authService;
    @Autowired
    private IPermissionService permissionService;

    //服务间调用token用户信息
    private static final String CLIENT_TOKEN_USER = "client-token-user";
    //服务间调用的token
    private static final String CLIENT_TOKEN = "client-token";
    /**
     * 检查请求中token是否有效，无效直接返回401，不调用签权服务
     * 调用签权服务器看是否对该请求有权限，有权限进入下一个filter，没有权限返回401
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authentication = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String method = request.getMethodValue();
        String url = request.getPath().value();
        log.debug("**************************************************************");
        log.debug("url:-->", url);
        log.debug("method:-->", method);
        log.debug("headers:-->", request.getHeaders());
        log.debug("**************************************************************");
        //不需要网关签权的url
        if (authService.ignoreAuthentication(url)) {
            return chain.filter(exchange);
        }

        //调用签权服务看用户是否有权限，若有权限进入下一个filter
        if (permissionService.permission(authentication, url, method)) {
            ServerHttpRequest.Builder builder = request.mutate();
            //TODO 转发的请求都加上服务间认证token
            builder.header("ContentType", "application/json;charset=UTF-8");
            builder.header(CLIENT_TOKEN, authentication);
            //将jwt token中的用户信息传给服务
            builder.header(CLIENT_TOKEN_USER, getUserToken(authentication));
            return chain.filter(exchange.mutate().request(builder.build()).build());
        }
        return unauthorized(exchange);
    }


    /**
     * 提取jwt token中的数据，转为json
     *
     * @param authentication
     * @return
     */
    private String getUserToken(String authentication) {
        String token = "{}";
        try {
            token = new ObjectMapper().writeValueAsString(authService.getJwt(authentication).getBody());
            return token;
        } catch (JsonProcessingException e) {
            log.error("token json error:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 网关拒绝，返回401
     *
     * @param
     */
    private Mono<Void> unauthorized(ServerWebExchange serverWebExchange) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer buffer = serverWebExchange.getResponse()
                .bufferFactory().wrap(HttpStatus.UNAUTHORIZED.getReasonPhrase().getBytes());
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }
}
