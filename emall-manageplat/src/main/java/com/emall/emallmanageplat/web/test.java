package com.emall.emallmanageplat.web;

import com.emall.emallcommon.core.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @RequestMapping("/test")
    public String get() throws Exception{
        int a = 0;
        int b = 1;
        if(a==0){
            throw new MyException ("300","asssd","aseeed","qqq");
        }
        return "";
    }
}
