package com.emall.authenticationserver.config;

import com.emall.authenticationserver.exception.MyWebResponseExceptionTranslator;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;
import java.util.List;

/**
 * 授权服务器策略定义
 * POST /oauth/authorize  授权码模式认证授权接口
 * GET/POST /oauth/token  获取 token 的接口
 * POST  /oauth/check_token  检查 token 合法性接口
 */
@Configuration
@EnableAuthorizationServer
public class AuthenticationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore redisTokenStore;

    @Autowired
    private MyWebResponseExceptionTranslator myWebResponseExceptionTranslator;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("userDetailsServer")
    private UserDetailsService userDetailsService;

    // jwt 对称加密密钥
    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;

    /**
     * 限制客户端访问认证接口的权限
     *
     * @param oauthServer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.allowFormAuthenticationForClients();    //允许客户端访问 OAuth2 授权接口，否则请求 token 会返回 401。
        oauthServer.tokenKeyAccess("isAuthenticated()");    //获取 token 接口
        oauthServer.checkTokenAccess("permitAll()");        //允许已授权用户访问 checkToken 接口
    }

    /**
     * 定义客户端详细信息服务的配置器。客户详细信息可以初始化
     * 本项目将客户端信息存储在DB
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端信息，从数据库中读取，对应oauth_client_details表
        clients.withClientDetails(jdbcClientDetails());
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
        //1、token过期时间（表字段：access_token_validity）
        //2、token刷新时间（表字段：refresh_token_validity）
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 1,用于支持密码模式(password模式必须添加authenticationManager)
     * 2,定义授权和令牌端点以及令牌服务
     *
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(redisTokenStore)  //使用redis存储token的方式
//                 .tokenStore(tokenStore())   //使用JWT存储token的方式
                .authenticationManager(authenticationManager)   //主要是存储的数据库表oauth_client_details中的信息，不写可能对于authorized_grant不识别
                .userDetailsService(userDetailsService)
//                 .tokenEnhancer(tokenEnhancer())                //主要是增强token，使用功能—JWT—方式
                //.approvalStore(approvalStore())                //主要是用于将token持久化到数据库(oauth_client_token表中),这里使用JWT可不使用，但是由于生成jwt较慢，可以选择持久化到redis
                .tokenGranter(tokenGranter(endpoints))           //自定义——手机短信验证码登录
                .authorizationCodeServices(authorizationCodeServices())   //授权码模式
                .exceptionTranslator(myWebResponseExceptionTranslator);     //异常增强自定义

    }

    /**
     * 自定义的granter，手机号短信验证登录
     *
     * @param endpoints
     * @return
     */
    private TokenGranter tokenGranter(AuthorizationServerEndpointsConfigurer endpoints) {
        List<TokenGranter> granters = Lists.newArrayList(endpoints.getTokenGranter());
        return null;
    }

    /**
     * 第二种方式——JWT存储Token
     * 自定义token(JWT)
     * MyTokenEnhancer 中设置token存储内容
     *
     * @return
     */
/*    @Bean
    public TokenEnhancer tokenEnhancer() {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(new JwtTokenEnhancer(), accessTokenConverter()));
        return tokenEnhancerChain;
    }*/


    /**
     * 第二种方式——JWT存储Token
     * 使用功能JWT存储Token
     * 基于 JDBC 实现，令牌保存到数据
     * (这里使用JWT，由于JWT中就存在用户信息，所以不存数据库)
     *
     * @return
     */
/*    private TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }*/


    /**
     * 第二种方式——JWT存储Token
     * jwt——token 生成
     *
     * @return
     */
/*    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(signingKey);
        return jwtAccessTokenConverter;
    }*/

    /**
     * 授权信息持久化实现
     *
     * @return JdbcApprovalStore
     */
    @Bean
    public ApprovalStore approvalStore() {
        return new JdbcApprovalStore(dataSource);
    }

    /**
     * 授权码模式持久化授权码code
     *
     * @return JdbcAuthorizationCodeServices
     */
    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
        // 授权码存储等处理方式类，使用jdbc，操作oauth_code表
        return new JdbcAuthorizationCodeServices(dataSource);
    }
}
