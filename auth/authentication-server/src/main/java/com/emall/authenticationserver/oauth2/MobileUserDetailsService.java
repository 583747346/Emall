package com.emall.authenticationserver.oauth2;

import com.emall.authenticationserver.entity.User;
import com.emall.authenticationserver.provider.SmsCodeProvider;
import com.emall.authenticationserver.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 自定义短信验证码模式与密码模式类似
 * 定义短信验证码 userdetails
 */
@Slf4j
@Service("mobileUserDetailsService")
public class MobileUserDetailsService extends CustomUserDetailsServer{

    @Autowired
    private IUserService userService;
    @Autowired
    private SmsCodeProvider smsCodeProvider;

    @Override
    public UserDetails loadUserByUsername(String uniqueId) {

        User user = userService.getByUniqueId(Long.parseLong(uniqueId));
        log.info("load user by mobile:{}", user.toString());

        // 如果为mobile模式，从短信服务中获取验证码（动态密码）
        String credentials = smsCodeProvider.getSmsCode(uniqueId, "LOGIN");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                credentials,
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                super.obtainGrantedAuthorities(user));
    }

}
