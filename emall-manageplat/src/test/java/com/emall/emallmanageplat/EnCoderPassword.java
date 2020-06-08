package com.emall.emallmanageplat;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EnCoderPassword {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
