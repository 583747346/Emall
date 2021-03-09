/*
package com.emall.emalldeskfronton.config;

import com.emall.emalldeskfronton.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

*/
/**
 * 获取当前用户
 *//*

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CurrentUserConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IMemberService memberService;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> memberService.getCurrentUser(username);
    }

}
*/
