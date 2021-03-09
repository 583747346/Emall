package com.emall.emallumsservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密
 */
@Configuration
public class PasswordEncoder {

    @Bean
    public BCryptPasswordEncoder mypasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
