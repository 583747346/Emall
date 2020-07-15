package com.emall.emallweb.intercepter;

import com.emall.emallweb.context.UserApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户拦截器
 * 微服务件调用，网关用户信息校验
 */

@Slf4j
public class UserIntercepter implements HandlerInterceptor {

    //服务间调用token用户信息
    private static final String CLIENT_TOKEN_USER = "client-token-user";
    //服务间调用的token
    private static final String CLIENT_TOKEN = "client-token";

    /**
     * 调用前处理：
     * 主要是对网关中token的校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从网关获取并校验,通过校验就可信任client-token-user中的信息
        checkToken(request.getHeader(CLIENT_TOKEN));
        String userInfoString = StringUtils.defaultIfBlank(request.getHeader(CLIENT_TOKEN_USER), "{}");
        UserApplicationContext.getInstance().setContext(new ObjectMapper().readValue(userInfoString, Map.class));
        return true;
    }

    private void checkToken(String token) {
        //TODO 从网关获取并校验,通过校验就可信任x-client-token-user中的信息
        log.debug("//TODO 校验token:{}", token);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        UserApplicationContext.getInstance().clear();
    }

}
