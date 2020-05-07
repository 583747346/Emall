package com.emall.authenticationserver;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class generatePassword {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }

}
