package com.emall.authorizationserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /*    //客户端id
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    //客户端secret
    @Value("${security.oauth2.client.client-secret}")
    private String secret;
    //收到客户端的请求时，请求此url携带token去认证服务端校验token
    @Value("${security.oauth2.authorization.check-token-access}")
    private String checkTokenEndpointUrl;

   @Bean
    public TokenStore redisTokenStore (){
        return new RedisTokenStore(redisConnectionFactory);
    }*/

    /**
     * 使用的是 redis 作为 token 的存储，所以需要特殊配置一下叫做 tokenService 的 Bean，
     * 通过这个 Bean 才能实现 token 的验证
     *
     * @return
     */
    /*@Bean
    public RemoteTokenServices tokenService() {
        *//*
        一般访问量不大的时候使用RemoteTokenServices
        主要用于内存与数据库
        会调用RemoteTokenServices.loadAuthentication 进行token校验
        *//*
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(secret);
        tokenService.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
        return tokenService;
    }*/
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
//                tokenServices(tokenService());//token存redis的方式

    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signingKey);
        return converter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/actuator/**")
                .permitAll()
                .antMatchers("/v2/api-docs")
                .permitAll()
                .anyRequest().authenticated();;
    }
}
