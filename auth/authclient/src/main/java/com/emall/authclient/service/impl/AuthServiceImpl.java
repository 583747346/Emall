package com.emall.authclient.service.impl;

import com.emall.authclient.service.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@Slf4j
public class AuthServiceImpl implements IAuthService {

    /**
     * 不需要网关签权的url配置(/oauth,/open)
     * 默认/oauth开头是不需要的
     */
    @Value("${gate.ignore.authentication.startWith}")
    private String ignoreUrls = "/oauth";

    @Override
    public boolean ignoreAuthentication(String url) {
        return Stream.of(this.ignoreUrls.split(",")).anyMatch(ignoreUrl -> url.startsWith(StringUtils.trim(ignoreUrl)));
    }

    /**
     * 对请求进行权限校验
     * @param authentication
     * @param url
     * @param method
     * @return
     */
    @Override
    public boolean hasPermission(String authentication, String url, String method) {
        return false;
    }
}
