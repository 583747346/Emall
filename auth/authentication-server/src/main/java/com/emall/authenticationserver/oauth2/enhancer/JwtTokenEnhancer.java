package com.emall.authenticationserver.oauth2.enhancer;

import com.google.common.collect.Maps;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Date;
import java.util.Map;

/**
 * 这是使用JWT存储token的方式
 * 主要是设置JWT中所需要存储的内容
 */
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> additionalInfo = Maps.newHashMap();
        additionalInfo.put("username", oAuth2Authentication.getName());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setExpiration(new Date(System.currentTimeMillis() + 7200 * 1000));
        return oAuth2AccessToken;
    }
}
